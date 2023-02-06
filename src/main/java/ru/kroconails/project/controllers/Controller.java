package ru.kroconails.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kroconails.project.DAO.UserDAO;
import ru.kroconails.project.entity.registration.User;
import ru.kroconails.project.exception.UserException;
import ru.kroconails.project.model.JsonRegistration;
import ru.kroconails.project.service.registration.CreateUser;

@RestController
public class Controller {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CreateUser createUser;

    @PostMapping("/registration")
    public ResponseEntity saveEntity(@RequestBody JsonRegistration jsonRegistration){
        try {

            User user = createUser.create(jsonRegistration);
            userDAO.save(user);

        }catch (UserException e){
           return ResponseEntity.badRequest().body("Пользователь с таким телефоном уже существует");
        }catch (Exception e){
           return ResponseEntity.badRequest().body(e.fillInStackTrace());
        }

        return ResponseEntity.ok("");
    }

    @DeleteMapping("/admin/delete")
    public ResponseEntity deleteUser(@RequestBody User user){
        try {
            userDAO.delete(user);
        }catch (Exception e){
            ResponseEntity.badRequest().body("Неизвестная ошибка!");
        }
        return (ResponseEntity) ResponseEntity.ok();
    }



}
