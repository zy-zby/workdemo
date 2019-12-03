package jxnu.chisha.domain;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName DietPlanOrderDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-01 10:32
 * @Version 1.0
 **/
@Entity
@Table(name = "diet_plan_order", schema = "chisha")
public class DietPlanOrderDomain {
    private int planOrderId;
    private int planOrderDate;
    private String planOrderContent;

    @Id
    @Column(name = "plan_order_id")
    public int getPlanOrderId() {
        return planOrderId;
    }

    public void setPlanOrderId(int planOrderId) {
        this.planOrderId = planOrderId;
    }

    @Basic
    @Column(name = "plan_order_date")
    public int getPlanOrderDate() {
        return planOrderDate;
    }

    public void setPlanOrderDate(int planOrderDate) {
        this.planOrderDate = planOrderDate;
    }

    @Basic
    @Column(name = "plan_order_content")
    public String getPlanOrderContent() {
        return planOrderContent;
    }

    public void setPlanOrderContent(String planOrderContent) {
        this.planOrderContent = planOrderContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DietPlanOrderDomain that = (DietPlanOrderDomain) o;

        if (planOrderId != that.planOrderId) return false;
        if (planOrderDate != that.planOrderDate) return false;
        if (planOrderContent != null ? !planOrderContent.equals(that.planOrderContent) : that.planOrderContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = planOrderId;
        result = 31 * result + planOrderDate;
        result = 31 * result + (planOrderContent != null ? planOrderContent.hashCode() : 0);
        return result;
    }
}
