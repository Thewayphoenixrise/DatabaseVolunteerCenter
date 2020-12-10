package dino.jwtapp.service.impl;

import dino.jwtapp.model.Volunteer;
import dino.jwtapp.repository.VolunteerRepository;
import dino.jwtapp.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        log.info("IN add - volunteer: {} adding", volunteer);

        Volunteer found = volunteerRepository.findByFirstNameAndLastNameAndPatronymicAndEmail(
                volunteer.getFirstName(), volunteer.getLastName(), volunteer.getPatronymic(), volunteer.getEmail()
        );

        if (found != null)
            return null;
        else
            return volunteerRepository.save(volunteer);
    }

    @Override
    public List<Volunteer> getAll()
    {
        List<Volunteer> result = volunteerRepository.findAll();
        log.info("IN getAll - {} volunteers found", result.size());
        return result;
    }

    @Override
    public Optional<Volunteer> findById(Long id)
    {
        log.info("IN findById - volunteer, id: {}", id);
        return volunteerRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id)
    {
        log.info("DELETING {}", volunteerRepository.findById(id));
        log.info("IN deleteById - volunteer, id: {}", id);
        if (volunteerRepository.findById(id).isEmpty())
            return false;
        volunteerRepository.deleteById(id);
        return true;
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
}
