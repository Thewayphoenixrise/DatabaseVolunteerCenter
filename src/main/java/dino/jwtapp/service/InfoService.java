package dino.jwtapp.service;

import dino.jwtapp.model.Event;
import dino.jwtapp.model.Organization;
import dino.jwtapp.model.Role;

import java.util.List;
import java.util.Optional;

public interface InfoService
{
    Event addEvent(Event event);
    List<Event> getAllEvents();
    boolean deleteEventById(Long id);
    Optional<Event> findEventById(Long id);
    List<Event> findEventsByOrg(Organization org);

    Organization addOrg(Organization org);
    Optional<Organization> findOrgById(Long id);
    List<Organization> getAllOrgs();
    boolean deleteOrgById(Long id);

    Role findRoleByName(String name);
}
