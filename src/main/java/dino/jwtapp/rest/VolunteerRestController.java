package dino.jwtapp.rest;

import dino.jwtapp.dto.AddVolunteerRequestDto;
import dino.jwtapp.dto.FindVolunteerRequestDto;
import dino.jwtapp.model.Volunteer;
import dino.jwtapp.model.VolunteerInfo;
import dino.jwtapp.service.VolunteerInfoService;
import dino.jwtapp.service.VolunteerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/admin/volunteers/")
public class VolunteerRestController
{
    private final VolunteerService volunteerService;
    private final VolunteerInfoService volunteerInfoService;

    @Autowired
    public VolunteerRestController(VolunteerService volunteerService, VolunteerInfoService volunteerInfoService)
    {
        this.volunteerService = volunteerService;
        this.volunteerInfoService = volunteerInfoService;
    }

    @PostMapping("adding")
    public Object add(@RequestBody AddVolunteerRequestDto addVolunteerRequestDto)
    {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(addVolunteerRequestDto.getFirstName());
        volunteer.setLastName(addVolunteerRequestDto.getLastName());
        volunteer.setPatronymic(addVolunteerRequestDto.getPatronymic());
        volunteer.setDateOfBirth(addVolunteerRequestDto.getDateOfBirth());
        volunteer.setSex(addVolunteerRequestDto.getSex());
        volunteer.setCitizenship(addVolunteerRequestDto.getCitizenship());
        volunteer.setInstitute(addVolunteerRequestDto.getInstitute());
        volunteer.setCourseOfStudy(addVolunteerRequestDto.getCourseOfStudy());
        volunteer.setFormOfStudy(addVolunteerRequestDto.getFormOfStudy());
        volunteer.setBudgetEducation(addVolunteerRequestDto.getBudgetEducation());
        volunteer.setStudyGroup(addVolunteerRequestDto.getStudyGroup());
        volunteer.setYearOfGraduation(addVolunteerRequestDto.getYearOfGraduation());
        volunteer.setClothingSize(addVolunteerRequestDto.getClothingSize());
        volunteer.setTelephone(addVolunteerRequestDto.getTelephone());
        volunteer.setEmail(addVolunteerRequestDto.getEmail());
        volunteer.setAddress(addVolunteerRequestDto.getAddress());
        volunteer.setEmployment(addVolunteerRequestDto.getEmployment());

        try
        {
            if (volunteerService.add(volunteer) == null)
                return "Already existed";

            return "OK";
        } catch (Exception e)
        {
            log.info("Register - Volunteer: {} is busy", volunteer.getFirstName());
            return "NO";
        }

    }

    @GetMapping("get_all")
    public ResponseEntity<List<Volunteer>> getAllVolunteers()
    {
        log.info("Get all volunteers:");
        List<Volunteer> result = volunteerService.getAll();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("get")
    public ResponseEntity<Volunteer> findById(HttpServletRequest request)
    {
        Long id = Long.parseLong(request.getParameter("id"));
        log.info("Get volunteer by id: " + id);
        Optional<Volunteer> result = volunteerService.findById(id);

        return result.isPresent()
                ? new ResponseEntity<>(result.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("get_views")
    public ResponseEntity<List<VolunteerInfo>> getAllVolunteersView()
    {
        log.info("Get all volunteers:");
        List<VolunteerInfo> result = volunteerInfoService.getAllViews();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "delete/{id}")
    public HttpStatus deleteVolById(@PathVariable(name = "id") String id)
    {
        if (volunteerService.deleteById(Long.valueOf(
                id.replace("{", "")
                        .replace("}", ""))))
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("find")
    public ResponseEntity<List<Volunteer>> findAllVolunteersBySex(@RequestBody FindVolunteerRequestDto dto)
    {
        log.info("Get volunteers by sex: " + dto.getSex());
        List<Volunteer> result = volunteerService.getAll();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
