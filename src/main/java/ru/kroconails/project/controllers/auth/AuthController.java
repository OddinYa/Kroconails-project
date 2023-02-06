package ru.kroconails.project.controllers.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kroconails.project.DAO.UserDAO;
import ru.kroconails.project.entity.registration.User;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDAO userDAO;

    @PostMapping(path = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getAuthUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth==null){
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;
        return Objects.nonNull(user) ? userDAO.getByPhoneNumber(user.getPhoneNumber()) : null;

    }

}
