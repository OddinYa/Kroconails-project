package ru.kroconails.project.DAO;


import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kroconails.project.entity.registration.User;
import ru.kroconails.project.exception.UserException;
import ru.kroconails.project.repo.UserRepo;

import java.util.*;

@Component
public class UserDAO implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    private User user;

    public User getByPhoneNumber(String phoneNumber){
        return userRepo.findByPhoneNumber(phoneNumber);
    }
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


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepo.findByPhoneNumber(phoneNumber);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException(String.format("Phone Number %s is not found", phoneNumber));
        }
        return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(),user.getPassword(),true
                ,true,true,true,new HashSet<>());
    }
    public void delete(User user){
        userRepo.delete(user);
    }
}
