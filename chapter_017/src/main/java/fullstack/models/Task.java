package fullstack.models;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * This class represents simple model for task.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 9.
 */
@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @Size(
            max = 50,
            message = "Название задания не может превышать 50 символов."
    )
    private String name;
    @Column(name = "category")
    @Size(
            max = 50,
            message = "Категория задания не может превышать 50 символов."
    )
    private String category;
    @Column(name = "datestart")
    private Timestamp dateStart;
    @Column(name = "dateend")
    private Timestamp dateEnd;
    @Column(name = "status")
    private String status;

    public Task() {
    }

    public Task(long id, String name, String category, Timestamp dateStart, Timestamp dateEnd, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", status='" + status + '\'' +
                '}';
    }
}
