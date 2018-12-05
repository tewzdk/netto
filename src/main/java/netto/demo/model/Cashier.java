package netto.demo.model;

import javax.persistence.*;

@Table (name = "cashiers")
@Entity
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @ManyToOne
    @JoinColumn (name = "fk_schedules")
    private Schedule schedule;
}
