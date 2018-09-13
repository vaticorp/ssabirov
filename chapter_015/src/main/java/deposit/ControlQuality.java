package deposit;

import deposit.foods.Food;
import deposit.storages.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * This class represents class for food-control.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 7.
 */
public class ControlQuality {

    private Storage storage;
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

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
        /*if (surplus >= 75.0) {
            setStorage(new FreezeWarehouse(new Warehouse()));
        } else if (surplus < 75 && surplus > 0) {
            setStorage(new Shop());
        } else if (surplus <= 0) {
            setStorage(new ProcessingWarehouse(new Trash()));
        }*/
        predicateStorage(n -> (n >= 75), new FreezeWarehouse(new Warehouse()), surplus);
        predicateStorage(n -> (n < 75 && n > 0), new Shop(), surplus);
        predicateStorage(n -> (n < 0), new ProcessingWarehouse(new Trash()), surplus);
    }

    public void predicateStorage(Predicate<Double> predicate, Storage storage, double surplus) {
        if (predicate.test(surplus)) {
            setStorage(storage);
        }
    }

    public void redistribute(Food food) {
        checkStorageByFood(food);
        storage.process(food);
    }

    public void startResort() {
        Runnable task = new Runnable() {
            public void run() {
                resort();
            }
        };
        service.scheduleWithFixedDelay(task, 0, 1, TimeUnit.DAYS);
        service.execute(task);
    }

    private void resort() {
        List<Food> list = storage.getFoods();
        list.forEach(food -> redistribute(food));
    }
}
