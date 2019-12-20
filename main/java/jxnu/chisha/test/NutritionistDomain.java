package jxnu.chisha.test;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName NutritionistDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "nutritionist", schema = "chisha", catalog = "")
public class NutritionistDomain {
    private int nutritionistId;
    private String nutritionistName;
    private String nutritionistLevel;
    private String nutritionistCategory;

    @Id
    @Column(name = "nutritionist_id")
    public int getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(int nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    @Basic
    @Column(name = "nutritionist_name")
    public String getNutritionistName() {
        return nutritionistName;
    }

    public void setNutritionistName(String nutritionistName) {
        this.nutritionistName = nutritionistName;
    }

    @Basic
    @Column(name = "nutritionist_level")
    public String getNutritionistLevel() {
        return nutritionistLevel;
    }

    public void setNutritionistLevel(String nutritionistLevel) {
        this.nutritionistLevel = nutritionistLevel;
    }

    @Basic
    @Column(name = "nutritionist_category")
    public String getNutritionistCategory() {
        return nutritionistCategory;
    }

    public void setNutritionistCategory(String nutritionistCategory) {
        this.nutritionistCategory = nutritionistCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NutritionistDomain that = (NutritionistDomain) o;

        if (nutritionistId != that.nutritionistId) return false;
        if (nutritionistName != null ? !nutritionistName.equals(that.nutritionistName) : that.nutritionistName != null)
            return false;
        if (nutritionistLevel != null ? !nutritionistLevel.equals(that.nutritionistLevel) : that.nutritionistLevel != null)
            return false;
        if (nutritionistCategory != null ? !nutritionistCategory.equals(that.nutritionistCategory) : that.nutritionistCategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nutritionistId;
        result = 31 * result + (nutritionistName != null ? nutritionistName.hashCode() : 0);
        result = 31 * result + (nutritionistLevel != null ? nutritionistLevel.hashCode() : 0);
        result = 31 * result + (nutritionistCategory != null ? nutritionistCategory.hashCode() : 0);
        return result;
    }
}
