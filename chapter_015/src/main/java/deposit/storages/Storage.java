package deposit.storages;

import deposit.foods.Food;

import java.util.ArrayList;

public interface Storage {
    public ArrayList<Food> listFood = new ArrayList<>();
    public void process(Food food);
}
