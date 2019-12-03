package jxnu.chisha.dao.Impl;

import jxnu.chisha.dao.FoodDao;
import jxnu.chisha.domain.FoodDomain;
import org.junit.jupiter.api.Test;

import java.util.List;

class ImplFoodDaoTest {

    @Test
    void queryFoodType() {
        FoodDao foodDao=new ImplFoodDao();
        try {
            List<FoodDomain> foodDomainList= foodDao.queryFoodType();
            for(FoodDomain foodDomain:foodDomainList){
                System.out.println(foodDomain.getFoodCategory()+",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}