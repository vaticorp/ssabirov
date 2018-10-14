package ru.job4j.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This class represents model-class for comment.
 * @author Svyatoslav Sabirov.
 * @since 04.10.2018
 * @version 7.
 */
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "created")
    private Timestamp created = new Timestamp(System.currentTimeMillis());

    public Comment() {
    }

    public Comment(String description, String author, Timestamp created) {
        this.description = description;
        this.author = author;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", created=" + created +
                '}';
    }
}
