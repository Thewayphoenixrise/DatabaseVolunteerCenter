package dino.jwtapp.rest;

import dino.jwtapp.dto.EventRequestDto;
import dino.jwtapp.dto.OrganizationDto;
import dino.jwtapp.model.Event;
import dino.jwtapp.model.Organization;
import dino.jwtapp.model.User;
import dino.jwtapp.security.jwt.JwtTokenProvider;
import dino.jwtapp.service.InfoService;
import dino.jwtapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController
{
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final InfoService infoService;

    @Autowired
    public AdminRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, InfoService infoService)
    {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.infoService = infoService;
    }

    @GetMapping("users/get")
    public ResponseEntity<List<User>> getAllUsers()
    {
        log.info("Get all users:");
        List<User> result = userService.getAll();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "delete/{login}")
    public HttpStatus deleteByUsername(@PathVariable(name = "login") String username)
    {
        if (userService.deleteByUsername(username))
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("events/get")
    public ResponseEntity<List<Event>> getAllEvents()
    {
        log.info("Get all events:");
        List<Event> result = infoService.getAllEvents();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("events/adding")
    public Object addEvent(@RequestBody EventRequestDto eventRequestDto)
    {
        Event event = new Event();
        event.setName(eventRequestDto.getName());
        event.setShortName(eventRequestDto.getShortName());
        event.setDateBegin(eventRequestDto.getDateBegin());
        event.setDateEnd(eventRequestDto.getDateEnd());
        event.setOrg(eventRequestDto.getOrg());

        try
        {
            infoService.addEvent(event);
            return "OK";
        } catch (Exception e)
        {
            log.info("Added - Event: {} is busy", event.getName());
            return "NO";
        }
    }

    @RequestMapping(value = "events/delete/{id}")
    public HttpStatus deleteEventById(@PathVariable(name = "id") Long id)
    {
        if (infoService.deleteEventById(id))
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("orgs/get")
    public ResponseEntity<List<Organization>> getAllOrgs()
    {
        log.info("Get all events:");
        List<Organization> result = infoService.getAllOrgs();

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("orgs/adding")
    public Object addOrg(@RequestBody OrganizationDto orgDto)
    {
        Organization org = new Organization();
        org.setName(orgDto.getName());
        org.setContactPerson(orgDto.getContactPerson());
        org.setEmail(orgDto.getEmail());
        org.setTelephone(orgDto.getTelephone());

        try
        {
            infoService.addOrg(org);
            return "OK";
        } catch (Exception e)
        {
            log.info("Added - Event: {} is busy", org.getName());
            return "NO";
        }
    }

    @RequestMapping(value = "orgs/delete/{id}")
    public HttpStatus deleteOrgById(@PathVariable(name = "id") Long id)
    {
        if (infoService.deleteOrgById(id))
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }
}