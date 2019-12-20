package jxnu.chisha.dao.Impl;

import jxnu.chisha.dao.FoodDao;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: chisha
 * @ClassName ImplFoodDao
 * @description: TODO
 * @author: zy
 * @create: 2019-12-01 10:23
 * @Version 1.0
 **/
public class ImplFoodDao implements FoodDao {
    @Override
    public List<FoodDomain> queryFoodType(){
        FoodDomain food = null;
        Connection con=null;
        PreparedStatement pstat=null;
        ResultSet rs=null;
        List<FoodDomain> list=new ArrayList<FoodDomain>();
        try {
            //获取jdbc的connection
            con = JDBCUtil.getConnection();
            String sql = "select distinct food_category " +
                    " from food";
            pstat = con.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {
                food = new FoodDomain();
                food.setFoodCategory(rs.getString(1));
                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeResultSet(rs);
                JDBCUtil.closeStatement(pstat);
                JDBCUtil.closeConnection(con);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<FoodDomain> queryFooodByType(String type) {
        FoodDomain food = null;
        Connection con=null;
        PreparedStatement pstat=null;
        ResultSet rs=null;
        List<FoodDomain> list=new ArrayList<FoodDomain>();
        try {
            //获取jdbc的connection
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM food "+
                    "WHERE food_category=?";
            pstat = con.prepareStatement(sql);
            pstat.setString(1,type);
            rs = pstat.executeQuery();

            while (rs.next()) {
                food = new FoodDomain();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodImg(rs.getString(3));
                food.setFoodPrice(rs.getBigDecimal(4));
                food.setFoodIngredients(rs.getString(5));
                food.setFoodWater(rs.getString(6));
                food.setFoodSalt(rs.getString(7));
                food.setFoodVita(rs.getString(8));
                food.setFoodProteins(rs.getString(9));
                food.setFoodSugar(rs.getString(10));
                food.setFoodFats(rs.getString(11));
                food.setFoodCategory(rs.getString(12));
                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeResultSet(rs);
                JDBCUtil.closeStatement(pstat);
                JDBCUtil.closeConnection(con);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
