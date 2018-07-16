package com.spring.rest.springrest.controllers;


import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    String helloWorld(){
        return "Hello World";
    }
    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getAllUsers();
    }

}
