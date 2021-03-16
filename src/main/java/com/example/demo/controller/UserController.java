package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repo;

    @PostMapping("/saveEmployee")
    public String saveUSer(@RequestBody User user ){
      repo.save(user);
      return "Employee Saved";

    }
    @GetMapping("/getAllUsers")
    public List<User> getAll(){
     return (List<User>) repo.findAll();
    }

}
