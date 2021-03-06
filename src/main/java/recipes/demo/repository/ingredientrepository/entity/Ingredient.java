package recipes.demo.repository.ingredientrepository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import recipes.demo.repository.dishrepository.entity.DishIngredient;
import recipes.demo.repository.foodtyperepository.entity.FoodType;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@Entity(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ingredientName;
    private String measureUnit;//g, piece
    @ManyToOne
    private FoodType foodType;
    @JsonManagedReference
    @OneToMany(mappedBy = "ingredient", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<DishIngredient> dishIngredientSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Set<DishIngredient> getDishIngredientSet() {
        return dishIngredientSet;
    }

    public void setDishIngredientSet(Set<DishIngredient> dishIngredientSet) {
        this.dishIngredientSet = dishIngredientSet;
    }

    public Ingredient() {
    }
}



