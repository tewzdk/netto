package netto.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Transient
    private String dayOfWeek;

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

    public String getDayOfWeek() {
        return dayOfWeek;
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

    @PostLoad
    public void setDayOfWeek(){
        String day = this.date.getDayOfWeek().name();
        switch (day.toLowerCase()) {
            case "monday": this.dayOfWeek = "Mandag";
                break;
            case "tuesday": this.dayOfWeek = "Tirsdag";
                break;
            case "wednesday": this.dayOfWeek = "Onsdag";
                break;
            case "thursday": this.dayOfWeek = "Torsdag";
                break;
            case "friday": this.dayOfWeek = "Fredag";
                break;
            case "saturday": this.dayOfWeek = "Lørdag";
                break;
            case "sunday": this.dayOfWeek = "Søndag";
                break;
        }


    }
}
