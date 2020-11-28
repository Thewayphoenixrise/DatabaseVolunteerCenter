package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "volunteers")
@Data
public class Volunteer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "sex")
    private String sex;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "institute")
    private String institute;

    @Column(name = "course_of_study")
    private Integer courseOfStudy;

    @Column(name = "form_of_study")
    private String formOfStudy;

    @Column(name = "budget_education")
    private Boolean budgetEducation;

    @Column(name = "study_group")
    private String studyGroup;

    @Column(name = "year_of_graduation")
    private Integer yearOfGraduation;

    @Column(name = "clothing_size")
    private String clothingSize;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "employment")
    private Boolean employment;

    @ManyToOne
    @JoinColumn(name = "loyalty_level")
    private LoyaltyCard loyaltyCard;

    @ManyToMany
    @JoinTable(
            name = "activities_of_volunteers",
            joinColumns = {@JoinColumn(name = "volunteer_id")},
            inverseJoinColumns = {@JoinColumn(name = "activity_id")})
    private List<Activity> activities;

    @ManyToMany
    @JoinTable(
            name = "events_of_volunteers",
            joinColumns = {@JoinColumn(name = "volunteer_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private List<Event> events;

    @ManyToMany
    @JoinTable(
            name = "langs_of_volunteers",
            joinColumns = {@JoinColumn(name = "volunteer_id")},
            inverseJoinColumns = {@JoinColumn(name = "language_id")})
    private List<Language> languages;

    @ManyToMany
    @JoinTable(
            name = "media_skills_of_volunteers",
            joinColumns = {@JoinColumn(name = "volunteer_id")},
            inverseJoinColumns = {@JoinColumn(name = "media_skill_id")})
    private List<MediaSkill> mediaSkills;

    @ManyToMany
    @JoinTable(
            name = "scholarships_of_volunteers",
            joinColumns = {@JoinColumn(name = "volunteer_id")},
            inverseJoinColumns = {@JoinColumn(name = "scholarship_id")})
    private List<Scholarship> scholarships;
}
