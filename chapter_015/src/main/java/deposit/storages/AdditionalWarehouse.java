package deposit.storages;

import deposit.foods.Food;

/**
 * This class represents advance storage for warehouse
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 9.
 */
public class AdditionalWarehouse implements Storage {

    private Warehouse warehouse;

    public AdditionalWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * Метод будет нести новую логику для дополнительного склада
     * @param food - продукт.
     */
    @Override
    public void process(Food food) {
        this.warehouse.process(food);
        System.out.println("Специфические действия для склада!");
        listFood.add(food);
    }
}
