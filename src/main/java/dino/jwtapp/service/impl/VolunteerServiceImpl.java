package dino.jwtapp.service.impl;

import dino.jwtapp.model.Volunteer;
import dino.jwtapp.repository.VolunteerRepository;
import dino.jwtapp.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class VolunteerServiceImpl implements VolunteerService
{
    private final VolunteerRepository volunteerRepository;

    public VolunteerServiceImpl(VolunteerRepository volunteerRepository)
    {
        this.volunteerRepository = volunteerRepository;
    }

    @Override
    public Volunteer add(Volunteer volunteer)
    {
        Volunteer added = volunteerRepository.save(volunteer);
        log.info("IN add - volunteer: {} successfully registered", added);
        return added;
    }

    @Override
    public List<Volunteer> getAll()
    {
        List<Volunteer> result = volunteerRepository.findAll();
        log.info("IN getAll - {} volunteers found", result.size());
        return result;
    }

    @Override
    public List<Volunteer> findBySex(String sex)
    {
        List<Volunteer> result = volunteerRepository.findBySex(sex);
        log.info("IN findByFirstName - volunteer: {} found by firstName: {}", result, sex);
        return result;
    }

    @Override
    public List<Volunteer> findByFirstName(String volunteerFirstName)
    {
        List<Volunteer> result = volunteerRepository.findByFirstName(volunteerFirstName);
        log.info("IN findByFirstName - volunteer: {} found by firstName: {}", result, volunteerFirstName);
        return result;
    }

    @Override
    public List<Volunteer> findByLastName(String volunteerLastName)
    {
        List<Volunteer> result = volunteerRepository.findByLastName(volunteerLastName);
        log.info("IN findByFirstName - volunteer: {} found by lastName: {}", result, volunteerLastName);
        return result;
    }

    @Override
    public void deleteByFullName(String volunteerFullName)
    {
        /*if (volunteerFullName.findByFullName(volunteerFullName) == null)
            return false;
        volunteerRepository.deleteByFullName(volunteerFullName);
        return true;*/
    }
}
