package ru.kroconails.project.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class JsonRegistration {

    private String firstName;
    private String lastName;
    private String PhoneNumber;
    private String password;
    private String email;

}
