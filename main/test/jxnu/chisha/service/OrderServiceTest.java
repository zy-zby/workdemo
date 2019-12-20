package jxnu.chisha.service;

import jxnu.chisha.domain.CustomerDomain;
import jxnu.chisha.domain.FoodDomain;
import jxnu.chisha.domain.OrderDetailDomain;
import jxnu.chisha.domain.OrderDomain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void getorder() throws SQLException {
        OrderService orderService=new OrderService();
        List<OrderDomain> orderDomains=orderService.getorder(1);
        for(OrderDomain orderDomain:orderDomains){
            System.out.println(orderDomain.getOrderAmt());
        }
    }

    @Test
    void getoderdetail() throws SQLException {
        OrderService orderService=new OrderService();
        List<OrderDetailDomain> orderDetailDomains=orderService.getoderdetail(2);
        for (OrderDetailDomain orderDetailDomain:orderDetailDomains){
            System.out.println(orderDetailDomain.getFoodByFoodId().getFoodName());
        }
    }
    @Test
    void addorder(){
        OrderService orderService=new OrderService();
        OrderDomain order=new OrderDomain();
        CustomerDomain cust=new CustomerDomain();
        cust.setCustId(1);
        List<OrderDetailDomain> items=new ArrayList<OrderDetailDomain>();
        OrderDetailDomain item1=new OrderDetailDomain();
        FoodDomain food1=new FoodDomain();
        food1.setFoodId(4);
        food1.setFoodPrice(new BigDecimal(9));
        item1.setOrderDetailNum(6);
        item1.setOrderDetailAmt("54");
        item1.setFoodByFoodId(food1);
        item1.setOrderByOrderId(order);
        OrderDetailDomain item2=new OrderDetailDomain();
        FoodDomain food2=new FoodDomain();
        food2.setFoodId(3);
        food2.setFoodPrice(new BigDecimal(18));
        item2.setOrderDetailNum(3);
        item2.setOrderDetailAmt("54");
        item2.setFoodByFoodId(food2);
        item2.setOrderByOrderId(order);
        items.add(item1);
        items.add(item2);
        order.setCustomerByCustId(cust);
        order.setOrderDate(new Timestamp(new Date().getTime()));
        order.setOrderAddr("jxnu");
        order.setOrderAmt("108");
        order.setItemList(items);
        order.setOrderPay("1");
        System.out.println(orderService.addorder(order));
    }
}