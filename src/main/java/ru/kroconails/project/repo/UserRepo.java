package ru.kroconails.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.kroconails.project.entity.registration.User;
@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {

User findByPhoneNumber(String string);

}
