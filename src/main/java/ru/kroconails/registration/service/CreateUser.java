package ru.kroconails.registration.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kroconails.registration.entity.User;
import ru.kroconails.registration.model.UserModel;

@Service
public class CreateUser {



    public User create(UserModel userModel) throws Exception {
       try {


           User user = new User(userModel.getFirstName(),
                   userModel.getLastName(),
                   userModel.getTelephoneNumber(),
                   userModel.getPassword());

           return user;

       }catch (Exception e){

           throw new Exception();

       }
    }

}
