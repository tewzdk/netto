package netto.demo.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @OneToMany (mappedBy = "task")
    List<ScheduleTask> scheduleTasks;

    public List<ScheduleTask> getScheduleTasks() {
        return scheduleTasks;
    }

    public void setScheduleTasks(List<ScheduleTask> scheduleTasks) {
        this.scheduleTasks = scheduleTasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
