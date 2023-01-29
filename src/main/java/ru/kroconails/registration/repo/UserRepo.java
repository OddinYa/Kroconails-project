package ru.kroconails.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kroconails.registration.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


}
