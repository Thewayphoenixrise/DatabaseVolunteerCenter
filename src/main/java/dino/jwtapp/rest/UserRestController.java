package dino.jwtapp.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dino.jwtapp.model.User;
import dino.jwtapp.service.UserService;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "/api/user/")
public class UserRestController
{
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("info")
    public ResponseEntity<User> getUserInfo(Principal principal) {
        String userName = principal.getName();
        log.info("Get info about user name: {}", userName);
        User result = userService.findByUsername(userName);

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
