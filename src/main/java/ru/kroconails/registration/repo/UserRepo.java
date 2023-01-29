package ru.kroconails.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kroconails.registration.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

User findByTelephoneNumber(String string);
}
