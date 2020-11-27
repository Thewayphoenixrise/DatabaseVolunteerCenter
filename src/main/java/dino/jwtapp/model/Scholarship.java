package dino.jwtapp.model;

import javax.persistence.*;

@Entity
@Table(name = "scholarships")
public class Scholarship
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
