package com.example.backend.controllers;

import com.example.backend.data.entities.User;
import com.example.backend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private UserRepository dao;

    @RequestMapping("/login")
    public boolean login(@RequestBody Map user) {
        User usr = dao.findByUsername((String) user.get("userName"));
        return usr != null && usr.getPassword().equals(user.get("password"));
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
        return user;
    }
}
