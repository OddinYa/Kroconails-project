package ru.kroconails.project.service.registration;

import org.springframework.stereotype.Service;
import ru.kroconails.project.entity.registration.User;
import ru.kroconails.project.model.JsonRegistration;

@Service
public class CreateUser {

    public User create(JsonRegistration jsonRegistration) throws Exception {
       try {
           User user = new User(jsonRegistration.getFirstName(),
                   jsonRegistration.getLastName(),
                   jsonRegistration.getEmail(),
                   jsonRegistration.getPhoneNumber(),
                   jsonRegistration.getPassword());

           return user;

       }catch (Exception e){
           throw new Exception();
       }
    }

}
