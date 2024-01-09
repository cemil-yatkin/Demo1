package com.SpringProjectOne.Demo1.controller;

import com.SpringProjectOne.Demo1.dto.UserDTO;
import com.SpringProjectOne.Demo1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value= "/api")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping(value = "/saveUserAll")
    public List<UserDTO> saveUser(@RequestBody List<UserDTO> userDTO) {
        System.out.print("User Saved!");
        userService.saveAllUsers(userDTO);
        return userDTO;
    }

    @GetMapping(path = "/getUser")
    public UserDTO getUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @GetMapping(path = "/users/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping(path = "/deneme")
    public String deneme () {
        return "Hello";
    }

}


