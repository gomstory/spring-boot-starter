package com.gom.rest_api_mysql.service;

import com.gom.rest_api_mysql.entity.User;
import com.gom.rest_api_mysql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public  void delete(User user) {
        this.userRepository.delete(user);
    }

    public User find(Integer id) {
        return this.userRepository
                .findById(id)
                .orElse(null);
    }

    public  User save(User user) {
        return  this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return  this.userRepository.findAll();
    }
}
