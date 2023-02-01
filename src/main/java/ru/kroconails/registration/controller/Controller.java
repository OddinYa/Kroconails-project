package ru.kroconails.registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kroconails.registration.DAO.UserDAO;
import ru.kroconails.registration.entity.User;
import ru.kroconails.registration.exception.UserException;
import ru.kroconails.registration.model.UserModel;
import ru.kroconails.registration.service.CreateUser;

@RestController("/user")
public class Controller {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CreateUser createUser;

    @PostMapping("/registration")
    public ResponseEntity saveEntity(@RequestBody UserModel userModel){
        try {

            User user = createUser.create(userModel);
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
