package jxnu.chisha.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @program: chisha
 * @ClassName OrderDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "ordert", schema = "chisha", catalog = "")
public class OrderDomain {
    private int orderId;
    private Timestamp orderDate;
    private String orderAddr;
    private String orderPay;
    private String orderAmt;
    private CustomerDomain customerByCustId;
    /**
     * 一对多关联
     */
    private List<OrderDetailDomain> itemList;

    @JoinColumn(name = "order_detail_id")
    @OneToMany(cascade={CascadeType.REMOVE})
    public List<OrderDetailDomain> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderDetailDomain> itemList) {
        this.itemList = itemList;
    }

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_date")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "order_addr")
    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    @Basic
    @Column(name = "order_pay")
    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    @Basic
    @Column(name = "order_amt")
    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDomain that = (OrderDomain) o;

        if (orderId != that.orderId) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (orderAddr != null ? !orderAddr.equals(that.orderAddr) : that.orderAddr != null) return false;
        if (orderPay != null ? !orderPay.equals(that.orderPay) : that.orderPay != null) return false;
        if (orderAmt != null ? !orderAmt.equals(that.orderAmt) : that.orderAmt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderAddr != null ? orderAddr.hashCode() : 0);
        result = 31 * result + (orderPay != null ? orderPay.hashCode() : 0);
        result = 31 * result + (orderAmt != null ? orderAmt.hashCode() : 0);
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
}
