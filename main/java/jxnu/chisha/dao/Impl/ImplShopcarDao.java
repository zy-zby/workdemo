package jxnu.chisha.dao.Impl;

import jxnu.chisha.dao.ShopcarDao;
import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.domain.ShopcarDomain;
import jxnu.chisha.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: chisha
 * @ClassName ImplShopcarDao
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:18
 * @Version 1.0
 **/
public class ImplShopcarDao implements ShopcarDao {
    @Override
    public List<ShopcarDomain> getshopcar(int custId) throws SQLException{
        List<ShopcarDomain> list = null;
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        String sql = "SELECT\n" +
                "custshopcar.shopcar_id,\n" +
                "custshopcar.qty,\n" +
                "custshopcar.food_name,\n" +
                "custshopcar.food_price\n" +
                "FROM\n" +
                "custshopcar\nwhere cust_id=?";
        try {
            conn = JDBCUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1,custId);
            rs = st.executeQuery();
            list = new ArrayList<ShopcarDomain>();
            while (rs.next()){
                ShopcarDomain shopcar = new ShopcarDomain();
                FoodDomain food = new FoodDomain();
                shopcar.setFoodByFoodId(food);
                shopcar.setShopcarId(rs.getInt(1));
                shopcar.setQty(rs.getInt(2));
                food.setFoodName(rs.getString(3));
                food.setFoodPrice(rs.getBigDecimal(4));
                list.add(shopcar);
            }
            return list;
        } finally {
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
    public ShopcarDomain getshopcarByFoodId(int foodId, int custId) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ShopcarDomain sc=null;
        String sql="SELECT\n" +
                "custshopcar.shopcar_id,\n" +
                "custshopcar.qty,\n" +
                "custshopcar.food_name,\n" +
                "custshopcar.food_price\n" +
                "FROM\n" +
                "custshopcar\nwhere food_id=? and cust_id=?";
        try {
            conn = JDBCUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1,foodId);
            st.setInt(2,custId);
            rs = st.executeQuery();
            if(rs.next()){
                ShopcarDomain shopcar = new ShopcarDomain();
                FoodDomain food = new FoodDomain();
                CustomerDomain cust = new CustomerDomain();
                shopcar.setFoodByFoodId(food);
                shopcar.setCustomerByCustId(cust);
                cust.setCustId(custId);
                shopcar.setShopcarId(rs.getInt(1));
                shopcar.setQty(rs.getInt(2));
                food.setFoodName(rs.getString(3));
                food.setFoodPrice(rs.getBigDecimal(4));
                food.setFoodId(foodId);
                sc=shopcar;
            }
            return sc;
        } finally {
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
    public int addFood(ShopcarDomain sc) throws SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String sql="insert into shopcar(cust_id,food_id,qty) values "+
                "(?,?,?)";
        try {
            conn =JDBCUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, sc.getCustomerByCustId().getCustId());
            st.setInt(2, sc.getFoodByFoodId().getFoodId());
            st.setInt(3, sc.getQty());
            return st.executeUpdate();
        } finally {
            try{
                JDBCUtil.closeStatement(st);
                JDBCUtil.closeConnection(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateFoodQty(ShopcarDomain sc) throws SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String sql="update shopcar set qty=? "+
                " where food_id=? and cust_id=?";
        try {
            conn = JDBCUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, sc.getQty());
            st.setInt(2, sc.getFoodByFoodId().getFoodId());
            st.setInt(3, sc.getCustomerByCustId().getCustId());
            return st.executeUpdate();
        } finally {
            try{
                JDBCUtil.closeStatement(st);
                JDBCUtil.closeConnection(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public int removeFood(int custId, int foodId) throws SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        String sql="delete from shopcar "+
                "  where cust_id =? and food_id=?";
        try {
            conn = JDBCUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setInt(1, custId);
            st.setInt(2, foodId);
            return st.executeUpdate();
        } finally {
            try{
                JDBCUtil.closeStatement(st);
                JDBCUtil.closeConnection(conn);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
