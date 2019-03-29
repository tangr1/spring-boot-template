package com.github.tangr1.controller;

import com.github.tangr1.model.User;
import com.github.tangr1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping(value = "/users")
    public List<User> list() {
        return userService.list();
    }
}
