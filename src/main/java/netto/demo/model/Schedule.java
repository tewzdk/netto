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

    @OneToMany(mappedBy = "tasks")
    private List<Task> tasks;
    private List<ExtraTask> extraTasks;
    private List<Cashier> cashiers;
}
