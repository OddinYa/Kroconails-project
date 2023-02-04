package ru.kroconails.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kroconails.project.entity.registration.User;



@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

User findByPhoneNumbermber(String string);
}
