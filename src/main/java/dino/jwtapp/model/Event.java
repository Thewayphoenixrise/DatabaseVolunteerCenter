package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "events")
@Data
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "date_begin")
    private Timestamp dateBegin;

    @Column(name = "date_end")
    private Timestamp dateEnd;

    @ManyToOne
    @JoinColumn(name = "organizer")
    private Organization org;
}
