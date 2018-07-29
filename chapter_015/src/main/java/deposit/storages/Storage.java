package deposit.storages;

import deposit.foods.Food;

import java.util.ArrayList;
import java.util.List;

public interface Storage {
    public ArrayList<Food> listFood = new ArrayList<>();
    public void process(Food food);
    public List<Food> getFoods();
}
