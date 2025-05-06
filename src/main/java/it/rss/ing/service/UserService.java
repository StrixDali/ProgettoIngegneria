package it.rss.ing.service;


import it.rss.ing.model.User;
import it.rss.ing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // Cifriamo la password
        userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void insertUser(User user) {

        //inserto into ......
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }
}
