package deposit.storages;

import deposit.foods.Food;

public class Warehouse implements Storage {

    @Override
    public void process(Food food) {
        System.out.println("Специфические действия для склада!");
        listFood.add(food);
    }
}
