package jxnu.chisha.dao.Impl;

import jxnu.chisha.dao.OrderDetailDao;
import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.domain.OrderDetailDomain;
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
 * @ClassName ImplOrderDetailDao
 * @description: TODO
 * @author: zy
 * @create: 2019-12-18 08:58
 * @Version 1.0
 **/
public class ImplOrderDetailDao implements OrderDetailDao {
    @Override
    public List<OrderDetailDomain> getListByOrder(int orderId) throws SQLException {
        List<OrderDetailDomain> list=null;
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try{

            String sql="SELECT\n" +
                    "orderitemview.order_detail_id,\n" +
                    "orderitemview.order_id,\n" +
                    "orderitemview.food_id,\n" +
                    "orderitemview.food_price,\n" +
                    "orderitemview.order_detail_num,\n" +
                    "orderitemview.food_name,\n" +
                    "orderitemview.food_img\n" +
                    "FROM\n" +
                    "orderitemview\n" +
                    "WHERE\n" +
                    "order_id=?";
            conn= JDBCUtil.getConnection();
            st=conn.prepareStatement(sql);
            st.setInt(1,orderId);
            rs=st.executeQuery();
            list= new ArrayList<OrderDetailDomain>();
            while (rs.next()){
                OrderDetailDomain item=new OrderDetailDomain();
                FoodDomain food=new FoodDomain();
                OrderDomain order=new OrderDomain();
                item.setFoodByFoodId(food);
                item.setOrderByOrderId(order);
                item.setOrderDetailId(rs.getInt(1));
                order.setOrderId(rs.getInt(2));
                food.setFoodId(rs.getInt(3));
                food.setFoodPrice(rs.getBigDecimal(4));
                item.setOrderDetailNum(rs.getInt(5));
                food.setFoodName(rs.getString(6));
                food.setFoodImg(rs.getString(7));

                list.add(item);
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
    public void addOrder(List<OrderDetailDomain> items,int orderId) throws SQLException {
        String sql = "insert into order_detail(order_detail_num," +
                "order_detail_amt,order_id,food_id) values(?,?,?,?)";
        Connection conn=null;
        PreparedStatement st=null;
        try{
            conn= JDBCUtil.getConnectionByTransaction();

            st=conn.prepareStatement(sql);
            for(int i=0;i<items.size();i++) {
                OrderDetailDomain item=items.get(i);
                st.setInt(1, item.getOrderDetailNum());
                st.setString(2, item.getOrderDetailAmt());
                st.setInt(3, orderId);
                st.setInt(4,item.getFoodByFoodId().getFoodId());
                st.executeUpdate();
            }
        }finally {
            st.close();
        }
    }
}
