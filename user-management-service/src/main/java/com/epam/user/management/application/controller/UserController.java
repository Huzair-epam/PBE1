package com.epam.user.management.application.controller;

import com.epam.user.management.application.dto.UserDto;
import com.epam.user.management.application.entity.User;
import com.epam.user.management.application.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "register" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody UserDto request){
        try {
            String message  = userService.register(request);
            return ResponseEntity.ok(message);
        }
        catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.SC_CONFLICT).body("User already exists");
        }
    }

    @GetMapping("viewall")
    public ResponseEntity<?> getall(){
        List<User>res=userService.getall();
        return ResponseEntity.ok(res);
    }

}
