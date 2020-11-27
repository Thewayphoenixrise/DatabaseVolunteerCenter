package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "activities_of_volunteers")
public class ActivitiesOfVolunteers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
}
