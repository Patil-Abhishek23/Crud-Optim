package com.example.crud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    public User updateUsername(String oldUsername, String newUsername) {
        User user = userRepository.findByUsername(oldUsername);
        if (user != null) {
            user.setUsername(newUsername);
            return userRepository.save(user);
        }
        return null;
    }

}
