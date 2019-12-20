package jxnu.chisha.service;

import jxnu.chisha.domain.FoodDomain;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodServiceTest {

    @Test
    void getType() {
        FoodService foodService=new FoodService();
        List<FoodDomain> foodDomainList = foodService.getType();
        System.out.println(foodDomainList);
        for(FoodDomain foodDomain:foodDomainList){
            System.out.println(foodDomain.getFoodCategory());
        }
    }
    @Test
    void getFoodByType(){
        FoodService foodService=new FoodService();
        List<FoodDomain> foodDomainList = foodService.getFoodByType("主食");
        System.out.println(foodDomainList);
        for(FoodDomain foodDomain:foodDomainList){
            System.out.println(foodDomain.getFoodName());
        }
    }
}