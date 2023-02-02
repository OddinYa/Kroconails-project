package ru.kroconails.registration.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserModel {

    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String password;

}
