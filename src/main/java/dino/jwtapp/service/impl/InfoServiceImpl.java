package dino.jwtapp.service.impl;

import dino.jwtapp.model.Event;
import dino.jwtapp.model.Organization;
import dino.jwtapp.model.Role;
import dino.jwtapp.repository.EventsRepository;
import dino.jwtapp.repository.OrganizationRepository;
import dino.jwtapp.repository.RoleRepository;
import dino.jwtapp.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InfoServiceImpl implements InfoService
{
    private final EventsRepository eventsRepository;
    private final OrganizationRepository organizationRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public InfoServiceImpl(EventsRepository eventsRepository, OrganizationRepository organizationRepository, RoleRepository roleRepository)
    {
        this.eventsRepository = eventsRepository;
        this.organizationRepository = organizationRepository;
        this.roleRepository = roleRepository;
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
    public boolean deleteEventById(Long id)
    {
        if (eventsRepository.findById(id).isPresent())
            return false;
        eventsRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Event> findEventById(Long id)
    {
        Optional<Event> founded = eventsRepository.findById(id);
        log.info("IN findEventById - event: {} found", founded);

        return founded;
    }

    @Override
    public List<Event> findEventsByOrg(Organization org)
    {
        List<Event> events = eventsRepository.findByOrg(org);
        log.info("IN findByOrg - found {} events by org_id: {}", events.size(), org.getId());

        return events;
    }

    @Override
    public Organization addOrg(Organization org)
    {
        Organization addedOrg = organizationRepository.save(org);
        log.info("IN addOrg - org: {} successfully added", addedOrg);

        return addedOrg;
    }

    @Override
    public Optional<Organization> findOrgById(Long id)
    {
        Optional<Organization> founded = organizationRepository.findById(id);
        log.info("IN findOrgById - org: {} found", founded);

        return founded;
    }

    @Override
    public List<Organization> getAllOrgs()
    {
        return organizationRepository.findAll();
    }

    @Override
    public boolean deleteOrgById(Long id)
    {
        if (organizationRepository.findById(id).isPresent())
            return false;
        organizationRepository.deleteById(id);
        return true;
    }

    @Override
    public Role findRoleByName(String name)
    {
        Role founded = roleRepository.findByName(name);
        log.info("IN findOrgById - org: {} found", founded);

        return founded;
    }
}
