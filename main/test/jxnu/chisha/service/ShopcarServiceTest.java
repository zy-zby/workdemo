package jxnu.chisha.service;

import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.domain.ShopcarDomain;
import jxnu.chisha.domain.UserDomain;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopcarServiceTest {

    @Test
    void getshopcar() throws SQLException {
        ShopcarService shopcarService = new ShopcarService();
        List<ShopcarDomain> shopcarDomains = shopcarService.getshopcar();
        for(ShopcarDomain shopcarDomain:shopcarDomains){
            System.out.println(shopcarDomain.getFoodByFoodId().getFoodName());
        }
    }
    @Test
    void addFood() throws SQLException{
        ShopcarService shopcarService = new ShopcarService();
        ShopcarDomain s=new ShopcarDomain();
        CustomerDomain c=new CustomerDomain();
        FoodDomain f=new FoodDomain();
        f.setFoodId(7);
        c.setCustId(1);
        s.setFoodByFoodId(f);
        s.setCustomerByCustId(c);
        System.out.println(shopcarService.addFood(s,-1));
    }
    @Test
    void updateFoodQty() throws SQLException{
        ShopcarService shopcarService = new ShopcarService();
    }
    @Test
    void removeFood() throws SQLException{
        ShopcarService shopcarService = new ShopcarService();
        System.out.println(shopcarService.removeFood(1,7));
    }
}