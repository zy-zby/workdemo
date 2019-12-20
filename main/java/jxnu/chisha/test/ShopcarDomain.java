package jxnu.chisha.test;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName ShopcarDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "shopcar", schema = "chisha", catalog = "")
public class ShopcarDomain {
    private int shopcarId;
    private int qty;
    private CustomerDomain customerByCustId;
    private FoodDomain foodByFoodId;

    @Id
    @Column(name = "shopcar_id")
    public int getShopcarId() {
        return shopcarId;
    }

    public void setShopcarId(int shopcarId) {
        this.shopcarId = shopcarId;
    }

    @Basic
    @Column(name = "qty")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopcarDomain that = (ShopcarDomain) o;

        if (shopcarId != that.shopcarId) return false;
        if (qty != that.qty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopcarId;
        result = 31 * result + qty;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable = false)
    public CustomerDomain getCustomerByCustId() {
        return customerByCustId;
    }

    public void setCustomerByCustId(CustomerDomain customerByCustId) {
        this.customerByCustId = customerByCustId;
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
