package dino.jwtapp.dto;

import lombok.Data;

@Data
public class RegistrationRequestDto
{
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String password;
}