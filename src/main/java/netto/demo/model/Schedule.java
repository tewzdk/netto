package netto.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "feedbackmorning")
    private String feedbackMorning;

    @Column(name = "feedbackevening")
    private String feedbackEvening;

    @Column(name = "shiftresponsibility")
    private String shiftResponsibility;

    @OneToMany(mappedBy = "schedule")
    private List<ExtraTask> extraTasks;

    @OneToMany(mappedBy = "schedule")
    private List<Cashier> cashiers;

    @OneToMany (mappedBy = "schedule")
    private List<ScheduleTask> scheduleTasks;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFeedbackMorning() {
        return feedbackMorning;
    }

    public void setFeedbackMorning(String feedbackMorning) {
        this.feedbackMorning = feedbackMorning;
    }

    public String getFeedbackEvening() {
        return feedbackEvening;
    }

    public void setFeedbackEvening(String feedbackEvening) {
        this.feedbackEvening = feedbackEvening;
    }

    public String getShiftResponsibility() {
        return shiftResponsibility;
    }

    public void setShiftResponsibility(String shiftResponsibility) {
        this.shiftResponsibility = shiftResponsibility;
    }

    public List<ExtraTask> getExtraTasks() {
        return extraTasks;
    }

    public void setExtraTasks(List<ExtraTask> extraTasks) {
        this.extraTasks = extraTasks;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public void setCashiers(List<Cashier> cashiers) {
        this.cashiers = cashiers;
    }
}
