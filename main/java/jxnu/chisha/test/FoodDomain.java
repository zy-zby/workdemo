package jxnu.chisha.test;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @program: chisha
 * @ClassName FoodDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "food", schema = "chisha", catalog = "")
public class FoodDomain {
    private int foodId;
    private String foodName;
    private String foodImg;
    private BigDecimal foodPrice;
    private String foodIngredients;
    private String foodWater;
    private String foodSalt;
    private String foodVita;
    private String foodProteins;
    private String foodSugar;
    private String foodFats;
    private String foodCategory;

    @Id
    @Column(name = "food_id")
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "food_name")
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Basic
    @Column(name = "food_img")
    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    @Basic
    @Column(name = "food_price")
    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Basic
    @Column(name = "food_ingredients")
    public String getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(String foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    @Basic
    @Column(name = "food_water")
    public String getFoodWater() {
        return foodWater;
    }

    public void setFoodWater(String foodWater) {
        this.foodWater = foodWater;
    }

    @Basic
    @Column(name = "food_salt")
    public String getFoodSalt() {
        return foodSalt;
    }

    public void setFoodSalt(String foodSalt) {
        this.foodSalt = foodSalt;
    }

    @Basic
    @Column(name = "food_vita")
    public String getFoodVita() {
        return foodVita;
    }

    public void setFoodVita(String foodVita) {
        this.foodVita = foodVita;
    }

    @Basic
    @Column(name = "food_proteins")
    public String getFoodProteins() {
        return foodProteins;
    }

    public void setFoodProteins(String foodProteins) {
        this.foodProteins = foodProteins;
    }

    @Basic
    @Column(name = "food_sugar")
    public String getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(String foodSugar) {
        this.foodSugar = foodSugar;
    }

    @Basic
    @Column(name = "food_fats")
    public String getFoodFats() {
        return foodFats;
    }

    public void setFoodFats(String foodFats) {
        this.foodFats = foodFats;
    }

    @Basic
    @Column(name = "food_category")
    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodDomain that = (FoodDomain) o;

        if (foodId != that.foodId) return false;
        if (foodName != null ? !foodName.equals(that.foodName) : that.foodName != null) return false;
        if (foodImg != null ? !foodImg.equals(that.foodImg) : that.foodImg != null) return false;
        if (foodPrice != null ? !foodPrice.equals(that.foodPrice) : that.foodPrice != null) return false;
        if (foodIngredients != null ? !foodIngredients.equals(that.foodIngredients) : that.foodIngredients != null)
            return false;
        if (foodWater != null ? !foodWater.equals(that.foodWater) : that.foodWater != null) return false;
        if (foodSalt != null ? !foodSalt.equals(that.foodSalt) : that.foodSalt != null) return false;
        if (foodVita != null ? !foodVita.equals(that.foodVita) : that.foodVita != null) return false;
        if (foodProteins != null ? !foodProteins.equals(that.foodProteins) : that.foodProteins != null) return false;
        if (foodSugar != null ? !foodSugar.equals(that.foodSugar) : that.foodSugar != null) return false;
        if (foodFats != null ? !foodFats.equals(that.foodFats) : that.foodFats != null) return false;
        if (foodCategory != null ? !foodCategory.equals(that.foodCategory) : that.foodCategory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodId;
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodImg != null ? foodImg.hashCode() : 0);
        result = 31 * result + (foodPrice != null ? foodPrice.hashCode() : 0);
        result = 31 * result + (foodIngredients != null ? foodIngredients.hashCode() : 0);
        result = 31 * result + (foodWater != null ? foodWater.hashCode() : 0);
        result = 31 * result + (foodSalt != null ? foodSalt.hashCode() : 0);
        result = 31 * result + (foodVita != null ? foodVita.hashCode() : 0);
        result = 31 * result + (foodProteins != null ? foodProteins.hashCode() : 0);
        result = 31 * result + (foodSugar != null ? foodSugar.hashCode() : 0);
        result = 31 * result + (foodFats != null ? foodFats.hashCode() : 0);
        result = 31 * result + (foodCategory != null ? foodCategory.hashCode() : 0);
        return result;
    }
}
