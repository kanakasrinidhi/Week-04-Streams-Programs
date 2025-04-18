import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanName();
}

class VegetarianMeal implements MealPlan {
    public String getPlanName() {
        return "Vegetarian Meal Plan";
    }
}

class VeganMeal implements MealPlan {
    public String getPlanName() {
        return "Vegan Meal Plan";
    }
}

class KetoMeal implements MealPlan {
    public String getPlanName() {
        return "Keto Meal Plan";
    }
}

class HighProteinMeal implements MealPlan {
    public String getPlanName() {
        return "High Protein Meal Plan";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    void addMeal(T meal) {
        meals.add(meal);
    }

    List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        for (T m : meal.getMeals()) {
            System.out.println("Generated: " + m.getPlanName());
        }
    }
}

public class MealPlanGeneratorApp {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>();
        Meal<VeganMeal> veganMeal = new Meal<>();
        Meal<KetoMeal> ketoMeal = new Meal<>();
        Meal<HighProteinMeal> highProteinMeal = new Meal<>();

        vegetarianMeal.addMeal(new VegetarianMeal());
        veganMeal.addMeal(new VeganMeal());
        ketoMeal.addMeal(new KetoMeal());
        highProteinMeal.addMeal(new HighProteinMeal());

        MealPlanGenerator.generatePlan(vegetarianMeal);
        MealPlanGenerator.generatePlan(veganMeal);
        MealPlanGenerator.generatePlan(ketoMeal);
        MealPlanGenerator.generatePlan(highProteinMeal);
    }
}
