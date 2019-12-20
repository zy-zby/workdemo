package jxnu.chisha.dao.Impl;

import jxnu.chisha.dao.OrderDao;
import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.OrderDomain;
import jxnu.chisha.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: chisha
 * @ClassName ImplOrderDao
 * @description: TODO
 * @author: zy
 * @create: 2019-12-18 08:57
 * @Version 1.0
 **/
public class ImplOrderDao implements OrderDao {
    @Override
    public List<OrderDomain> getListByCust(int custId) throws SQLException {
        List<OrderDomain> list=null;
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            String sql="SELECT\n" +
                    "orderinfoview.order_id,\n" +
                    "orderinfoview.order_date,\n" +
                    "orderinfoview.order_addr,\n" +
                    "orderinfoview.order_pay,\n" +
                    "orderinfoview.order_amt,\n" +
                    "orderinfoview.cust_id,\n" +
                    "orderinfoview.cust_name\n" +
                    "FROM\n" +
                    "orderinfoview\n" +
                    "WHERE\n" +
                    "orderinfoview.cust_id=?";
            conn= JDBCUtil.getConnection();
            st=conn.prepareStatement(sql);
            st.setLong(1,custId);
            rs=st.executeQuery();
            list=new ArrayList<OrderDomain>();
            while (rs.next()){
                OrderDomain order=new OrderDomain();
                CustomerDomain user=new CustomerDomain();
                order.setCustomerByCustId(user);
                order.setOrderId(rs.getInt(1));
                order.setOrderDate(rs.getTimestamp(2));
                order.setOrderAddr(rs.getString(3));
                order.setOrderPay(rs.getString(4));
                order.setOrderAmt(rs.getString(5));
                user.setCustId(rs.getInt(6));
                user.setCustName(rs.getString(7));
                list.add(order);
            }
            return list;
        }finally {
            try{
                JDBCUtil.closeResultSet(rs);
                JDBCUtil.closeStatement(st);
                JDBCUtil.closeConnection(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int addOrder(OrderDomain orderDomain) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        int id=0;
        try{
            conn=JDBCUtil.getConnectionByTransaction();
            String sql = "insert into ordert(order_date," +
                    "order_addr,order_pay,order_amt,cust_id) values (?,?,?,?,?)";
            st=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setTimestamp(1,orderDomain.getOrderDate());
            st.setString(2,orderDomain.getOrderAddr());
            st.setString(3, orderDomain.getOrderPay());
            st.setString(4,orderDomain.getOrderAmt());
            st.setInt(5,orderDomain.getCustomerByCustId().getCustId());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()){
                id=rs.getInt(1);
            }
            System.out.println(id);
            return id;
        }finally {
            st.close();
        }
    }
}
