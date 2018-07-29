package deposit.storages;

import deposit.foods.Food;

import java.util.List;

/**
 * This class represents trash-food.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 9.
 */
public class Trash implements Storage {

    @Override
    public void process(Food food) {
        System.out.println("Специфические действия для мусора!");
        listFood.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return listFood;
    }
}
