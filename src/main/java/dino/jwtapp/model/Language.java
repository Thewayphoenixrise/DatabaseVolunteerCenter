package dino.jwtapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@Data
public class Language
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
