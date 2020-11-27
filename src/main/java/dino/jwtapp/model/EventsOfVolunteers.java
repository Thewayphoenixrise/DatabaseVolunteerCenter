package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "events_of_volunteers")
@Data
public class EventsOfVolunteers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
