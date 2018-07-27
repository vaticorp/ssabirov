package deposit;

import deposit.foods.Food;
import deposit.storages.*;

/**
 * This class represents class for food-control.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 7.
 */
public class ControlQuality {

    private Storage storage;

    public ControlQuality(Storage storage) {
        this.storage = storage;
    }

    public ControlQuality() {
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Метод распределяет товары по складам. Определенная логика в условии не определена,
     * поэтому оставлена упрощенная реализация.
     * @param food - товар.
     */
    public void checkStorageByFood(Food food) {
        double surplus = food.percentExpaireDate();
        if (surplus >= 75.0) {
            setStorage(new FreezeWarehouse(new Warehouse()));
        } else if (surplus < 75 && surplus > 0) {
            setStorage(new Shop());
        } else if (surplus <= 0) {
            setStorage(new ProcessingWarehouse(new Trash()));
        }
    }

    public void redistribute(Food food) {
        checkStorageByFood(food);
        storage.process(food);
    }
}
