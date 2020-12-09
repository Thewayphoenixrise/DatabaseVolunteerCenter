package dino.jwtapp.service.impl;

import dino.jwtapp.model.Event;
import dino.jwtapp.model.Organization;
import dino.jwtapp.repository.EventsRepository;
import dino.jwtapp.repository.OrganizationRepository;
import dino.jwtapp.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InfoServiceImpl implements InfoService
{
    private final EventsRepository eventsRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public InfoServiceImpl(EventsRepository eventsRepository, OrganizationRepository organizationRepository)
    {
        this.eventsRepository = eventsRepository;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Event addEvent(Event event)
    {
        Event addedEvent = eventsRepository.save(event);
        log.info("IN addEvent - event: {} successfully added", addedEvent);

        return addedEvent;
    }

    @Override
    public List<Event> getAllEvents()
    {
        return eventsRepository.findAll();
    }

    @Override
    public Organization addOrg(Organization org)
    {
        Organization addedOrg = organizationRepository.save(org);
        log.info("IN addOrg - org: {} successfully added", addedOrg);

        return addedOrg;
    }

    @Override
    public List<Organization> getAllOrgs()
    {
        return organizationRepository.findAll();
    }
}
