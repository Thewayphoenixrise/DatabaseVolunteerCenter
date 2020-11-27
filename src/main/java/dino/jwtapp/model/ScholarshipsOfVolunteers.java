package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "scholarships_of_volunteers")
@Data
public class ScholarshipsOfVolunteers
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "scholarship_id")
    private Scholarship event;
}
