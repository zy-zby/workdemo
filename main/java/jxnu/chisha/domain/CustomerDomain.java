package jxnu.chisha.domain;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName CustomerDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-01 10:32
 * @Version 1.0
 **/
@Entity
@Table(name = "customer", schema = "chisha")
public class CustomerDomain {
    private int custId;
    private String custHealth;
    private String custAccount;
    private String custName;
    private double custWeight;
    private String custSex;
    private String custTel;

    @Id
    @Column(name = "cust_id")
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "cust_health")
    public String getCustHealth() {
        return custHealth;
    }

    public void setCustHealth(String custHealth) {
        this.custHealth = custHealth;
    }

    @Basic
    @Column(name = "cust_account")
    public String getCustAccount() {
        return custAccount;
    }

    public void setCustAccount(String custAccount) {
        this.custAccount = custAccount;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cust_weight")
    public double getCustWeight() {
        return custWeight;
    }

    public void setCustWeight(double custWeight) {
        this.custWeight = custWeight;
    }

    @Basic
    @Column(name = "cust_sex")
    public String getCustSex() {
        return custSex;
    }

    public void setCustSex(String custSex) {
        this.custSex = custSex;
    }

    @Basic
    @Column(name = "cust_tel")
    public String getCustTel() {
        return custTel;
    }

    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDomain that = (CustomerDomain) o;

        if (custId != that.custId) return false;
        if (Double.compare(that.custWeight, custWeight) != 0) return false;
        if (custHealth != null ? !custHealth.equals(that.custHealth) : that.custHealth != null) return false;
        if (custAccount != null ? !custAccount.equals(that.custAccount) : that.custAccount != null) return false;
        if (custName != null ? !custName.equals(that.custName) : that.custName != null) return false;
        if (custSex != null ? !custSex.equals(that.custSex) : that.custSex != null) return false;
        if (custTel != null ? !custTel.equals(that.custTel) : that.custTel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = custId;
        result = 31 * result + (custHealth != null ? custHealth.hashCode() : 0);
        result = 31 * result + (custAccount != null ? custAccount.hashCode() : 0);
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        temp = Double.doubleToLongBits(custWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (custSex != null ? custSex.hashCode() : 0);
        result = 31 * result + (custTel != null ? custTel.hashCode() : 0);
        return result;
    }
}
