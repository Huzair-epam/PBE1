package com.epam.user.management.application.controller;

import com.epam.user.management.application.dto.UserDto;
import com.epam.user.management.application.entity.User;
import com.epam.user.management.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto request) {
        System.out.println("here");
        User user = userService.register(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("viewall")
    public ResponseEntity<?> getall(){
        List<User>res=userService.getall();
        return ResponseEntity.ok(res);
    }
}
