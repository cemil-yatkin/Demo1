package com.SpringProjectOne.Demo1.controller;

import com.SpringProjectOne.Demo1.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //RestAPI olduğu için
@RequestMapping(path = "/apiHello")
public class HelloController {

    //@RequestMapping(path = "/hello",method = RequestMethod.GET)
    @GetMapping(path = "/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostMapping(path = "/save")  //PATH yazmadan da oluyor.
    public String save() {
        return "Data Saved";
    }

    @DeleteMapping(path = "/delete")
    public String delete() {
        return "Data Deteled";
    }

   @GetMapping(path = "/message/{m}")
    public String getMyMessage(@PathVariable("m") String message) {
        return "Your message is : " + message;
    }

    @GetMapping(path= "/message2")
    public String getMyMessage2(@RequestParam String message) {
        return "Your 2nMessage is : " + message;
    }
    @GetMapping(path="/header")
    public String getMyHeader(@RequestHeader(name = "my-header", defaultValue = "default-header") String header) {
        return "Your header is : " + header;
    }

    @PostMapping("/saveUsers")
    public UserDTO saveUser(@RequestBody UserDTO user) {
        user.setPassword("");
        System.out.println("User Saved!");
        return user;
    }
    @PostMapping("/saveAllUsers")
    public List<UserDTO> saveAllUsers(@RequestBody List<UserDTO> users) {
        users.forEach(user -> user.setPassword(""));
        System.out.println("All users saved!");
        return users;
    }
}
