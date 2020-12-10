package dino.jwtapp.service;

import dino.jwtapp.model.User;
import dino.jwtapp.model.Volunteer;

import java.util.List;
import java.util.Optional;

public interface VolunteerService
{
    Volunteer add(Volunteer volunteer);

    List<Volunteer> getAll();

    Optional<Volunteer> findById(Long id);

    boolean deleteById(Long id);

    List<Volunteer> findByFirstName(String volunteerFirstName);

    List<Volunteer> findByLastName(String volunteerLastName);
}
