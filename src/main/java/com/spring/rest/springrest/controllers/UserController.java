package com.spring.rest.springrest.controllers;


import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.exceptions.UserNotFoundException;
import com.spring.rest.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/")
    String helloWorld(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id){
        User user = userService.getUser(id);
        if(user==null){
            throw new UserNotFoundException("User not found!!");
        }
        return user;
    }

    @PostMapping("/users")
    ResponseEntity<Object> saveUser(@RequestBody @Valid User user){
        userService.saveUser(user);
        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        User user=userService.getUser(id);

        if(user==null) {
            throw new UserNotFoundException("User not found");
        }
        userService.deleteUser(user);

    }
}
