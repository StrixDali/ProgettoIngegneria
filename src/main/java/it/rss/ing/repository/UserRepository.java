package it.rss.ing.repository;

import it.rss.ing.model.User;
import org.springframework.data.jpa.repository.JpaRepository; //contine la maggior parte delle query che faremo
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
