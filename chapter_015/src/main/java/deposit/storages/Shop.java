package deposit.storages;

import deposit.foods.Food;
import java.util.List;

public class Shop implements Storage {

    @Override
    public void process(Food food) {
        double surplus = food.percentExpaireDate();
        if (surplus < 75.0) {
           food.setDiscount(15);
        }
        listFood.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return listFood;
    }
}
