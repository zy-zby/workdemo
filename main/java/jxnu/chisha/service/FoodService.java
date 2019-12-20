package jxnu.chisha.service;

import jxnu.chisha.dao.FoodDao;
import jxnu.chisha.dao.Impl.ImplFoodDao;
import jxnu.chisha.domain.FoodDomain;

import java.util.List;

/**
 * @program: chisha
 * @ClassName FoodService
 * @description: TODO
 * @author: zy
 * @create: 2019-12-01 11:09
 * @Version 1.0
 **/
public class FoodService {
    private FoodDao foodDao= new ImplFoodDao();

    public List<FoodDomain> getType(){
        return foodDao.queryFoodType();
    }
    public List<FoodDomain> getFoodByType(String type){
        return foodDao.queryFooodByType(type);
    }
}
