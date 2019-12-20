package jxnu.chisha.dao;

import jxnu.chisha.domain.ShopcarDomain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ShopcarDao {
    //获得列表
    public List<ShopcarDomain> getshopcar(int custId) throws SQLException;
    public ShopcarDomain getshopcarByFoodId(int foodId,int custId) throws SQLException;
    //添加条目
    public int addFood(ShopcarDomain sc) throws SQLException;
    //更新数量
    public int updateFoodQty(ShopcarDomain sc) throws SQLException;
    //删除条目
    public int removeFood(int custId,int foodId) throws SQLException;
    //public void removeFoods();
    public int getQty(int custId, int foodId) throws SQLException;
}
