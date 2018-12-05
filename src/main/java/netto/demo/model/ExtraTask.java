package netto.demo.model;

import javax.persistence.*;

@Table (name = "extratasks")
@Entity
public class ExtraTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "description")
    private String description;

    @Column (name = "responsible")
    private String responsible;

    @Column (name = "done")
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "fk_schedules")
    private Schedule schedule;
}
