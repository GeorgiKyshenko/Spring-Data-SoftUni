package com.example.springdata_lab.services;

import com.example.springdata_lab.models.User;
import com.example.springdata_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        User userFound = userRepository.findByUsername(user.getUsername());

        if (userFound == null) {
            this.userRepository.save(user);
        }
//        else {
//            throw new IllegalArgumentException("User Already Exists");
//        }
    }
}
