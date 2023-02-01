package ru.kroconails.registration.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kroconails.registration.entity.User;
import ru.kroconails.registration.exception.UserException;
import ru.kroconails.registration.repo.UserRepo;
@Component
public class UserDAO  {
    @Autowired
    private UserRepo userRepo;

    User user;
    @Transactional
    public void save(User user) throws Exception {
        isCheck(user.getTelephoneNumber());
        userRepo.save(user);
    }
    private void isCheck(String number) throws Exception {
       user = userRepo.findByTelephoneNumber(number);
       if(user!=null){
           throw new UserException();
       }
    }
    public void delete(User user){
        userRepo.delete(user);
    }


}
