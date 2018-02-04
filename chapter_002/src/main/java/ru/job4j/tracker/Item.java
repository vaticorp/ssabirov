package ru.job4j.tracker;

/**
 * This class for bid.
 * @author Svyatoslav Sabirov.
 * @since 03.02.2018.
 * @version 01.
 */
public class Item {

    private String name;
    private String description;
    private long created;
    private String id;

    /**
     * Constructor.
     * @param name - name item.
     * @param description - item info.
     * @param created - time of created.
     */
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    /**
     * Overloaded constructor.
     * @param name - name item.
     * @param description - item info.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreated() {
        return created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", created=" + created + ", id='" + id + '\'' + '}';
    }
}
