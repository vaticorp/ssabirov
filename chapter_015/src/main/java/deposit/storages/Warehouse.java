package deposit.storages;

import deposit.foods.Food;

import java.util.List;

public class Warehouse implements Storage {

    @Override
    public void process(Food food) {
        System.out.println("Специфические действия для склада!");
        listFood.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return listFood;
    }
}
