package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "activities")
public class Activity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
