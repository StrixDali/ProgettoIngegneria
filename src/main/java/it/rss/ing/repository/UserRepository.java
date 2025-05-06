package it.rss.ing.repository;

import it.rss.ing.model.User;
import org.springframework.data.jpa.repository.JpaRepository; //contine la maggior parte delle query che faremo
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);


}
