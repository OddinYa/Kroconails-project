package ru.kroconails.project.controllers.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kroconails.project.DAO.UserDAO;
import ru.kroconails.project.entity.registration.User;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping(path = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getAllUsers(){
        return userDAO.getAllUsers();

    }
}
