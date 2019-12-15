package jxnu.chisha.domain;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName DietPlanDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "diet_plan", schema = "chisha", catalog = "")
public class DietPlanDomain {
    private int planId;
    private String planName;
    private String planCircle;
    private String planSuit;

    @Id
    @Column(name = "plan_id")
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "plan_name")
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Basic
    @Column(name = "plan_circle")
    public String getPlanCircle() {
        return planCircle;
    }

    public void setPlanCircle(String planCircle) {
        this.planCircle = planCircle;
    }

    @Basic
    @Column(name = "plan_suit")
    public String getPlanSuit() {
        return planSuit;
    }

    public void setPlanSuit(String planSuit) {
        this.planSuit = planSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DietPlanDomain that = (DietPlanDomain) o;

        if (planId != that.planId) return false;
        if (planName != null ? !planName.equals(that.planName) : that.planName != null) return false;
        if (planCircle != null ? !planCircle.equals(that.planCircle) : that.planCircle != null) return false;
        if (planSuit != null ? !planSuit.equals(that.planSuit) : that.planSuit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planId;
        result = 31 * result + (planName != null ? planName.hashCode() : 0);
        result = 31 * result + (planCircle != null ? planCircle.hashCode() : 0);
        result = 31 * result + (planSuit != null ? planSuit.hashCode() : 0);
        return result;
    }
}
