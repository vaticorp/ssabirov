package ru.job4j.generic;

public abstract class AbstractStore<T> implements Store {

    private SimpleArray<T> innerArray;

    public AbstractStore(SimpleArray<T> innerArray) {
        this.innerArray = innerArray;
    }

    @Override
    public void add(Base model) {
        this.innerArray.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        //класс для демонстрации,поэтому,полагаю,можно без блока try обойтись
        return this.innerArray.set(Integer.parseInt(id), (T) model);
    }

    @Override
    public boolean delete(String id) {
        //класс для демонстрации,поэтому,полагаю,можно без блока try обойтись
        return this.innerArray.delete(Integer.parseInt(id));
    }

    @Override
    public Base findById(String id) {
        //класс для демонстрации,поэтому,полагаю,можно без блока try обойтись
        return (Base) this.innerArray.get(Integer.parseInt(id));
    }

}
