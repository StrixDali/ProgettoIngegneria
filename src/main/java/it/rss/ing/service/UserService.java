package it.rss.ing.service;


import it.rss.ing.model.User;
import it.rss.ing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insertUser(User user) {

        //inserto into ......
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }
}
