package jxnu.chisha.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: chisha
 * @ClassName CustDietPlanOrderDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "cust_diet_plan_order", schema = "chisha", catalog = "")
public class CustDietPlanOrderDomain {
    private int custPlanOrderId;
    private Timestamp custPlanOrderDate;
    private String custPlanOrderContent;
    private CustDietPlanDomain custDietPlanByCustPlanId;

    @Id
    @Column(name = "cust_plan_order_id")
    public int getCustPlanOrderId() {
        return custPlanOrderId;
    }

    public void setCustPlanOrderId(int custPlanOrderId) {
        this.custPlanOrderId = custPlanOrderId;
    }

    @Basic
    @Column(name = "cust_plan_order_date")
    public Timestamp getCustPlanOrderDate() {
        return custPlanOrderDate;
    }

    public void setCustPlanOrderDate(Timestamp custPlanOrderDate) {
        this.custPlanOrderDate = custPlanOrderDate;
    }

    @Basic
    @Column(name = "cust_plan_order_content")
    public String getCustPlanOrderContent() {
        return custPlanOrderContent;
    }

    public void setCustPlanOrderContent(String custPlanOrderContent) {
        this.custPlanOrderContent = custPlanOrderContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustDietPlanOrderDomain that = (CustDietPlanOrderDomain) o;

        if (custPlanOrderId != that.custPlanOrderId) return false;
        if (custPlanOrderDate != null ? !custPlanOrderDate.equals(that.custPlanOrderDate) : that.custPlanOrderDate != null)
            return false;
        if (custPlanOrderContent != null ? !custPlanOrderContent.equals(that.custPlanOrderContent) : that.custPlanOrderContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custPlanOrderId;
        result = 31 * result + (custPlanOrderDate != null ? custPlanOrderDate.hashCode() : 0);
        result = 31 * result + (custPlanOrderContent != null ? custPlanOrderContent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cust_plan_id", referencedColumnName = "cust_plan_id", nullable = false)
    public CustDietPlanDomain getCustDietPlanByCustPlanId() {
        return custDietPlanByCustPlanId;
    }

    public void setCustDietPlanByCustPlanId(CustDietPlanDomain custDietPlanByCustPlanId) {
        this.custDietPlanByCustPlanId = custDietPlanByCustPlanId;
    }
}
