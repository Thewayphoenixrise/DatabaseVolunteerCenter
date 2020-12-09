package dino.jwtapp.service;

import dino.jwtapp.model.Event;
import dino.jwtapp.model.Organization;

import java.util.List;

public interface InfoService
{
    Event addEvent(Event event);
    List<Event> getAllEvents();

    Organization addOrg(Organization org);
    List<Organization> getAllOrgs();
}
