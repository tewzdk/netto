package netto.demo.model;

import javax.persistence.*;

@Table(name = "tasks")
@SecondaryTable(name = "scheduletasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(table = "tasks", name = "id")
    private int id;

    @Column(table = "tasks", name = "description")
    private String description;

    @Column(table = "tasks", name = "category")
    private String category;

    @JoinColumn(table = "scheduletasks", name = "responsible")
    private String responsible;

    @JoinColumn(table = "scheduletasks", name = "done")
    private boolean done;

    @ManyToOne
    @JoinColumn(table = "scheduletasks", name = "fk_schedules")
    private Schedule schedule;
}
