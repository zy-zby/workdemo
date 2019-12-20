package jxnu.chisha.test;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: chisha
 * @ClassName PerformanceDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "performance", schema = "chisha", catalog = "")
public class PerformanceDomain {
    private int performanceId;
    private Timestamp performanceDate;
    private double performanceWeight;
    private String performanceBmi;
    private String performanceBloodsugar;

    @Id
    @Column(name = "performance_id")
    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    @Basic
    @Column(name = "performance_date")
    public Timestamp getPerformanceDate() {
        return performanceDate;
    }

    public void setPerformanceDate(Timestamp performanceDate) {
        this.performanceDate = performanceDate;
    }

    @Basic
    @Column(name = "performance_weight")
    public double getPerformanceWeight() {
        return performanceWeight;
    }

    public void setPerformanceWeight(double performanceWeight) {
        this.performanceWeight = performanceWeight;
    }

    @Basic
    @Column(name = "performance_BMI")
    public String getPerformanceBmi() {
        return performanceBmi;
    }

    public void setPerformanceBmi(String performanceBmi) {
        this.performanceBmi = performanceBmi;
    }

    @Basic
    @Column(name = "performance_bloodsugar")
    public String getPerformanceBloodsugar() {
        return performanceBloodsugar;
    }

    public void setPerformanceBloodsugar(String performanceBloodsugar) {
        this.performanceBloodsugar = performanceBloodsugar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerformanceDomain that = (PerformanceDomain) o;

        if (performanceId != that.performanceId) return false;
        if (Double.compare(that.performanceWeight, performanceWeight) != 0) return false;
        if (performanceDate != null ? !performanceDate.equals(that.performanceDate) : that.performanceDate != null)
            return false;
        if (performanceBmi != null ? !performanceBmi.equals(that.performanceBmi) : that.performanceBmi != null)
            return false;
        if (performanceBloodsugar != null ? !performanceBloodsugar.equals(that.performanceBloodsugar) : that.performanceBloodsugar != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = performanceId;
        result = 31 * result + (performanceDate != null ? performanceDate.hashCode() : 0);
        temp = Double.doubleToLongBits(performanceWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (performanceBmi != null ? performanceBmi.hashCode() : 0);
        result = 31 * result + (performanceBloodsugar != null ? performanceBloodsugar.hashCode() : 0);
        return result;
    }
}
