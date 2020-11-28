package dino.jwtapp.dto;

import dino.jwtapp.model.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class AddVolunteerRequestDto
{
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private String sex;
    private String citizenship;
    private String institute;
    private Integer courseOfStudy;
    private String formOfStudy;
    private Boolean budgetEducation;
    private String studyGroup;
    private Integer yearOfGraduation;
    private String clothingSize;
    private String telephone;
    private String email;
    private String address;
    private Boolean employment;
    private LoyaltyCard loyaltyCard;
    private List<Activity> activities;
    private List<Event> events;
    private List<Language> languages;
    private List<MediaSkill> mediaSkills;
    private List<Scholarship> scholarships;
}
