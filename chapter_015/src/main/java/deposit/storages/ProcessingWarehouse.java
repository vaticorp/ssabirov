package deposit.storages;

import deposit.foods.Food;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents class for processing foods.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 9.
 */
public class ProcessingWarehouse implements Storage {

    private Trash trashHouse;

    public ProcessingWarehouse(Trash trashHouse) {
        this.trashHouse = trashHouse;
    }

    @Override
    public void process(Food food) {
        this.trashHouse.process(food);
        if (food.isCanReproduct()) {
            listFood.add(food);
            System.out.println("Какая-то логика для переработки!");
        }
    }

    @Override
    public List<Food> getFoods() {
        return listFood;
    }
}
