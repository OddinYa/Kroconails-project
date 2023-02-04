package ru.kroconails.project.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kroconails.project.entity.registration.User;
import ru.kroconails.project.exception.UserException;
import ru.kroconails.project.repo.UserRepo;

@Component
public class UserDAO  {
    @Autowired
    private UserRepo userRepo;

    User user;
    @Transactional
    public void save(User user) throws Exception {
        isCheck(user.getPhoneNumber());
        userRepo.save(user);
    }
    private void isCheck(String number) throws Exception {
       user = userRepo.findByPhoneNumbermber(number);
       if(user!=null){
           throw new UserException();
       }
    }
    public void delete(User user){
        userRepo.delete(user);
    }


}
