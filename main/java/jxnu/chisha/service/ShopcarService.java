package jxnu.chisha.service;

import jxnu.chisha.dao.Impl.ImplShopcarDao;
import jxnu.chisha.dao.ShopcarDao;
import jxnu.chisha.domain.ShopcarDomain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: chisha
 * @ClassName ShopcarService
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 10:04
 * @Version 1.0
 **/
public class ShopcarService {
    private ShopcarDao shopcarDao = new ImplShopcarDao();
    public List<ShopcarDomain> getshopcar() throws SQLException {
        return shopcarDao.getshopcar(1);
    }
    public int addFood(ShopcarDomain sc,int qty) throws SQLException{
        //判断是否已经在购物车中
        ShopcarDomain s=null;
        s=shopcarDao.getshopcarByFoodId(sc.getFoodByFoodId().getFoodId(),sc.getCustomerByCustId().getCustId());
        if(s!=null){
            s.setQty(s.getQty()+qty);
            return shopcarDao.updateFoodQty(s);
        }else {
            sc.setQty(qty);
            return shopcarDao.addFood(sc);
        }
    }
    public int updateFoodQty(ShopcarDomain sc) throws SQLException{
        return shopcarDao.updateFoodQty(sc);
    }
    public int removeFood(int custId,int foodId) throws SQLException{
        return shopcarDao.removeFood(custId,foodId);
    }
    public int getQty(int custId, int foodId) throws SQLException {
        return  shopcarDao.getQty(custId,foodId);
    }

}
