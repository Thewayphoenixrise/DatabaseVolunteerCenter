package dino.jwtapp.repository;

import dino.jwtapp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>
{
    List<Volunteer> findByFirstName(String volunteerFirstName);
    List<Volunteer> findByLastName(String volunteerLastName);
    List<Volunteer> findBySex(String sex);
    //List<Volunteer> findByFullName(String volunteerLastName);
    //void deleteByFullName(String volunteerFullName);
}
