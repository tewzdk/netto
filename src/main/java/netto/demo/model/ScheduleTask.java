package netto.demo.model;

import javax.persistence.*;

@Entity
@Table (name = "scheduletasks")
public class ScheduleTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "responsible")
    private String responsible;

    @Column (name = "done")
    private boolean done;

    @ManyToOne
    @JoinColumn(name = "fk_tasks")
    private Task task;

    @ManyToOne
    @JoinColumn (name = "fk_schedules")
    private Schedule schedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
