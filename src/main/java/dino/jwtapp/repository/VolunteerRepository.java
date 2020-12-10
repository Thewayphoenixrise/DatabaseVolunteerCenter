package dino.jwtapp.repository;

import dino.jwtapp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>
{
    List<Volunteer> findByFirstName(String volunteerFirstName);
    List<Volunteer> findByLastName(String volunteerLastName);
    List<Volunteer> findBySex(String sex);
    Volunteer findByFirstNameAndLastNameAndPatronymicAndEmail(
            String firstName, String lastName, String Patronymic, String email);
}
