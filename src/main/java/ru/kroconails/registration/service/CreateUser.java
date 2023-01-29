package ru.kroconails.registration.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kroconails.registration.entity.User;
import ru.kroconails.registration.model.UserModel;

@Service
public class CreateUser {



    public User create(UserModel userModel) throws Exception {
       try {


           User user = new User(userModel.getFirstName(),userModel.getSecondName(),userModel.getTelephoneNumber());
           // TODO: 29.01.2023
           return user;

       }catch (Exception e){

           throw new Exception();

       }
    }

}
