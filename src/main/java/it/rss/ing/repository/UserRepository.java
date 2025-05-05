package it.rss.ing.repository;

import it.rss.ing.model.User;
import org.springframework.data.jpa.repository.JpaRepository; //contine la maggior parte delle query che faremo

public interface UserRepository extends JpaRepository<User,Long> {

}
