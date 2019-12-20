package jxnu.chisha.test;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: chisha
 * @ClassName CustDietPlanDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "cust_diet_plan", schema = "chisha", catalog = "")
public class CustDietPlanDomain {
    private int custPlanId;
    private String custPlanName;
    private Timestamp custPlanStart;
    private Timestamp custPlanEnd;

    @Id
    @Column(name = "cust_plan_id")
    public int getCustPlanId() {
        return custPlanId;
    }

    public void setCustPlanId(int custPlanId) {
        this.custPlanId = custPlanId;
    }

    @Basic
    @Column(name = "cust_plan_name")
    public String getCustPlanName() {
        return custPlanName;
    }

    public void setCustPlanName(String custPlanName) {
        this.custPlanName = custPlanName;
    }

    @Basic
    @Column(name = "cust_plan_start")
    public Timestamp getCustPlanStart() {
        return custPlanStart;
    }

    public void setCustPlanStart(Timestamp custPlanStart) {
        this.custPlanStart = custPlanStart;
    }

    @Basic
    @Column(name = "cust_plan_end")
    public Timestamp getCustPlanEnd() {
        return custPlanEnd;
    }

    public void setCustPlanEnd(Timestamp custPlanEnd) {
        this.custPlanEnd = custPlanEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustDietPlanDomain that = (CustDietPlanDomain) o;

        if (custPlanId != that.custPlanId) return false;
        if (custPlanName != null ? !custPlanName.equals(that.custPlanName) : that.custPlanName != null) return false;
        if (custPlanStart != null ? !custPlanStart.equals(that.custPlanStart) : that.custPlanStart != null)
            return false;
        if (custPlanEnd != null ? !custPlanEnd.equals(that.custPlanEnd) : that.custPlanEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custPlanId;
        result = 31 * result + (custPlanName != null ? custPlanName.hashCode() : 0);
        result = 31 * result + (custPlanStart != null ? custPlanStart.hashCode() : 0);
        result = 31 * result + (custPlanEnd != null ? custPlanEnd.hashCode() : 0);
        return result;
    }
}
