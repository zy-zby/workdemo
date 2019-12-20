package jxnu.chisha.service;

import jxnu.chisha.dao.Impl.ImplOrderDao;
import jxnu.chisha.dao.Impl.ImplOrderDetailDao;
import jxnu.chisha.dao.Impl.ImplShopcarDao;
import jxnu.chisha.dao.OrderDao;
import jxnu.chisha.dao.OrderDetailDao;
import jxnu.chisha.dao.ShopcarDao;
import jxnu.chisha.domain.OrderDetailDomain;
import jxnu.chisha.domain.OrderDomain;
import jxnu.chisha.domain.ShopcarDomain;
import jxnu.chisha.exceptions.ProductOperationException;
import jxnu.chisha.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: chisha
 * @ClassName OrderService
 * @description: TODO
 * @author: zy
 * @create: 2019-12-18 09:33
 * @Version 1.0
 **/
public class OrderService {
    private OrderDao orderDao=new ImplOrderDao();
    private OrderDetailDao orderDetailDao = new ImplOrderDetailDao();
    private ShopcarDao shopcarDomain = new ImplShopcarDao();
    public List<OrderDomain> getorder(int custId) throws SQLException{
        return orderDao.getListByCust(custId);
    }
    public List<OrderDetailDomain> getoderdetail(int orderId) throws SQLException {
        return orderDetailDao.getListByOrder(orderId);
    }
    public int addorder(OrderDomain order){
        int flag=1;
        Connection conn=null;
        int orderId=0;
        // 开启事务
        try {
            conn= JDBCUtil.getConnectionByTransaction();
            conn.setAutoCommit(false);
            orderId=orderDao.addOrder(order);
            orderDetailDao.addOrder(order.getItemList(),orderId);
            //shopcarDomain.removeFoods(order.getItemList(),order.getCustomerByCustId().getCustId());

            conn.commit();
        } catch (SQLException e) {
            flag=0;
            e.printStackTrace();
            // 事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }  catch (ProductOperationException e) {
            flag=2;
            e.printStackTrace();
            // 事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 释放资源,并且事务提交以及从ThreadLocal中移除Connection。
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
