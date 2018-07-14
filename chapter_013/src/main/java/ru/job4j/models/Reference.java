package ru.job4j.models;

import javax.persistence.*;

/**
 * This class represents link-class.
 * @author Svyatoslav Sabirov.
 * @since 08.07.2018
 * @version 7.
 */
@Entity
@Table(name = "references")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "longUrl")
    private String longUrl;
    @Column(name = "shortUrl")
    private String shortUrl;
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Reference() {
    }

    public Reference(int id, String longName, String shortName, User user, String type) {
        this.id = id;
        this.longUrl = longName;
        this.shortUrl = shortName;
        this.user = user;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод просто преобразует идентификатор объекта,который мы получаем из БД
     */
    public void shortingUrl() {
        char[] digits="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        double value = getId();
        String result = "http://infobip/";
        do {
            int dig = (int)(value % 62);
            result += digits[dig];
            value=Math.floor(value / 62);
        } while (value!=0);
        this.setShortUrl(result);
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", user=" + user +
                '}';
    }
}
