package deposit.storages;

import deposit.foods.Food;

/**
 * This class represents warehouse for vegetables.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 9.
 */
public class FreezeWarehouse implements Storage {

    private Warehouse warehouse;

    public FreezeWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * Реализация мне не очень нравится. Я бы лучше завел enum с типами продуктов и проверял бы его.
     * @param food - продукт.
     */
    @Override
    public void process(Food food) {
        if (food.getName().equals("vegetable")) {
            listFood.add(food);
            return;
        }
        warehouse.process(food);
    }
}
