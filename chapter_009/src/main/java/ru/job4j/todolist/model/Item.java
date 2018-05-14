package ru.job4j.todolist.model;

import java.sql.Timestamp;

/**
 * This class represents Item
 * @author Svyatoslav Sabirov.
 * @since 10.05.2018
 * @version 7.
 */
public class Item {

    private long id;
    private String desc;
    private Timestamp created;
    private boolean done;

    public Item() {

    }

    public Item(String desc) {
        this.desc = desc;
        this.created = new Timestamp(System.currentTimeMillis());
        this.done = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return String.format("Item - id: %s desc: %s created: %s done: %1$b", id, desc, created.toString(), done);
    }
}
