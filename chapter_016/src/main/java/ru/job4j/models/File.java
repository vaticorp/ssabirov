package ru.job4j.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

/**
 * This class represents model-class for files.
 * @author Svyatoslav Sabirov.
 * @since 16.08.2018
 * @version 7.
 */
@Entity
@Table(name = "catalogs")
public class File implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "path")
    @NotNull
    @Size(
        max = 255,
        message = "Путь к файлу не может превышать 255 символов."
    )
    private String path;
    @Column(name = "created")
    private Timestamp created = new Timestamp(System.currentTimeMillis());
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "" +
                    "",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "embedded_id")
    )
    private Set<EmbeddedEntity> list = new TreeSet<EmbeddedEntity>(new Comparator<EmbeddedEntity>() {
        @Override
        public int compare(EmbeddedEntity o1, EmbeddedEntity o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    });

    public File() {
    }

    public File(@Size(
            max = 255,
            message = "Путь к файлу не может превышать 255 символов."
    ) String path) {
        this.path = path;
        java.io.File dir = new java.io.File(path); //path указывает на директорию
        java.io.File[] arrFiles = dir.listFiles();
        List<java.io.File> lst = Arrays.asList(arrFiles);
        lst.forEach(s -> {
            EmbeddedEntity embeddedEntity = new EmbeddedEntity();
            embeddedEntity.setFolder(s.isDirectory());
            embeddedEntity.setSize(s.length());
            embeddedEntity.setName(s.getName());
            list.add(embeddedEntity);
        });
    }

    public long getId() {
        return id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<EmbeddedEntity> getList() {
        return list;
    }

    public void setList(Set<EmbeddedEntity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", list=" + list +
                '}';
    }
}
