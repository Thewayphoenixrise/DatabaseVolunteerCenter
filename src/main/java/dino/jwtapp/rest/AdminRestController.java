package dino.jwtapp.rest;

import dino.jwtapp.security.jwt.JwtTokenProvider;
import dino.jwtapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController
{
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AdminRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService)
    {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @RequestMapping(value = "delete/{login}")
    public HttpStatus deleteByUsername(@PathVariable(name = "login") String username)
    {
        if (userService.deleteByUsername(username))
            return HttpStatus.OK;
        return HttpStatus.BAD_REQUEST;
    }

}