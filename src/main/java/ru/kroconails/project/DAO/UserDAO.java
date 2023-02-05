package ru.kroconails.project.DAO;


import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kroconails.project.entity.registration.User;
import ru.kroconails.project.exception.UserException;
import ru.kroconails.project.repo.UserRepo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class UserDAO  {
    @Autowired
    private UserRepo userRepo;

    User user;
    @Transactional
    public void save(User user) throws Exception {
        isCheck(user.getPhoneNumber());
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }
    private void isCheck(String number) throws Exception {
       user = userRepo.findByPhoneNumber(number);
       if(user!=null){
           throw new UserException();
       }
    }
    public void delete(User user){
        userRepo.delete(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }


}
