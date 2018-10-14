package ru.job4j.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Set;

/**
 * This class represents class for news-model.
 * @author Svyatoslav Sabirov.
 * @since 03.10.2018
 * @version 7.
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    @Size(
            max = 255,
            message = "Описание новости не может превышать 255 символов."
    )
    private String text;

    private Timestamp date = new Timestamp(System.currentTimeMillis());
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "commentsattachment",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id")
    )
    private Set<Comment> comments;

    public News() {
    }

    public News(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public News(Long id, String title, String text, Timestamp date, Set<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", comments=" + comments +
                '}';
    }
}
