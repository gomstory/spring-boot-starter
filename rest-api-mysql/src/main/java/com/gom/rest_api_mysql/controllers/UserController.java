package com.gom.rest_api_mysql.controllers;

import com.gom.rest_api_mysql.entity.User;
import com.gom.rest_api_mysql.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class UserController {
    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return this.service.find(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.service.save(user);
    }

    @GetMapping("/users")
    public  List<User> getUsers() {
        return  this.service.getUsers();
    }

    // Update
    @PatchMapping("/user")
    public User updateUser(@RequestBody User user) {
        var selectedUser = this.service.find(user.id);
        selectedUser.setFirstname(user.firstname);
        selectedUser.setLastname(user.lastname);

        return this.service.save(selectedUser);
    }

    // Delete
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        var selectedUser = this.service.find(id);
        this.service.delete(selectedUser);

        return true;
    }
}
