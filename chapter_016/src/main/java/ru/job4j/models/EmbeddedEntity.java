package ru.job4j.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class represents entity for embedded file|directory.
 * @author Svyatoslav Sabirov.
 * @since 18.08.2018
 * @version 9.
 */
@Entity
@Table(name = "embedded")
public class EmbeddedEntity implements Serializable, Comparable<EmbeddedEntity> {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private long size;
    @Column(name = "folder")
    private boolean isFolder;

    public EmbeddedEntity() {
    }

    public EmbeddedEntity(String name, long size, boolean isFolder) {
        this.name = name;
        this.size = size;
        this.isFolder = isFolder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    @Override
    public String toString() {
        return "EmbeddedEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", isFolder=" + isFolder +
                '}';
    }

    @Override
    public int compareTo(EmbeddedEntity o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    public static void main(String[] args) {
        EmbeddedEntity e1 = new EmbeddedEntity();
        e1.setName("apple.txt");
        EmbeddedEntity e2 = new EmbeddedEntity();
        e2.setName("palace.txt");
        EmbeddedEntity e3 = new EmbeddedEntity();
        e3.setName("kettle.txt");
        EmbeddedEntity e4 = new EmbeddedEntity();
        e4.setName("war.txt");
        EmbeddedEntity e5 = new EmbeddedEntity();
        e5.setName("zombie.txt");
        EmbeddedEntity e6 = new EmbeddedEntity();
        e6.setName("barbie.txt");
        EmbeddedEntity e7 = new EmbeddedEntity();
        e7.setName("corvin.txt");
        EmbeddedEntity e8 = new EmbeddedEntity();
        e8.setName("baby");
        EmbeddedEntity e9 = new EmbeddedEntity();
        e9.setName("lom");
        Set<EmbeddedEntity> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);
        set.add(e8);
        set.add(e9);
        set.forEach(s -> System.out.println(s.name));
    }
}
