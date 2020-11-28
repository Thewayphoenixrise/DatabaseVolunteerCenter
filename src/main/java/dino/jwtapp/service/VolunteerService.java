package dino.jwtapp.service;

import dino.jwtapp.model.User;
import dino.jwtapp.model.Volunteer;

import java.util.List;

public interface VolunteerService
{
    Volunteer add(Volunteer volunteer);

    List<Volunteer> getAll();

    List<Volunteer> findBySex(String sex);

    List<Volunteer> findByFirstName(String volunteerFirstName);

    List<Volunteer> findByLastName(String volunteerLastName);

    void deleteByFullName(String volunteerFullName);
}
