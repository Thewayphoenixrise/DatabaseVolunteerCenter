package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "media_skills")
@Data
public class MediaSkill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
