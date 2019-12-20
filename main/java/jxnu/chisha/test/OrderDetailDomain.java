package jxnu.chisha.test;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName OrderDetailDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "order_detail", schema = "chisha", catalog = "")
public class OrderDetailDomain {
    private int orderDetailId;
    private int orderDetailNum;
    private String orderDetailAmt;
    private OrderDomain orderByOrderId;
    private FoodDomain foodByFoodId;

    @Id
    @Column(name = "order_detail_id")
    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    @Basic
    @Column(name = "order_detail_num")
    public int getOrderDetailNum() {
        return orderDetailNum;
    }

    public void setOrderDetailNum(int orderDetailNum) {
        this.orderDetailNum = orderDetailNum;
    }

    @Basic
    @Column(name = "order_detail_amt")
    public String getOrderDetailAmt() {
        return orderDetailAmt;
    }

    public void setOrderDetailAmt(String orderDetailAmt) {
        this.orderDetailAmt = orderDetailAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailDomain that = (OrderDetailDomain) o;

        if (orderDetailId != that.orderDetailId) return false;
        if (orderDetailNum != that.orderDetailNum) return false;
        if (orderDetailAmt != null ? !orderDetailAmt.equals(that.orderDetailAmt) : that.orderDetailAmt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDetailId;
        result = 31 * result + orderDetailNum;
        result = 31 * result + (orderDetailAmt != null ? orderDetailAmt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    public OrderDomain getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(OrderDomain orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "food_id", nullable = false)
    public FoodDomain getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(FoodDomain foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }
}
