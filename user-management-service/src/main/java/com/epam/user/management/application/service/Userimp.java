package com.epam.user.management.application.service;

import com.epam.user.management.application.constants.Role;
import com.epam.user.management.application.dao.UserDAO;
import com.epam.user.management.application.dto.UserDto;
import com.epam.user.management.application.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userimp implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> T register(UserDto userdto){
        if (userDAO.existsByEmail(userdto.getEmail())) {
            throw new IllegalStateException("Email already Exists");
        }
        String encodedPassword = passwordEncoder.encode(userdto.getPassword());
        User user=objectMapper.convertValue(userdto, User.class);
        user.setPassword(encodedPassword);
        userDAO.save(user);
        return (T) "Registration Successfull";
    }

    @Override
    public List<User> getall() {
        return userDAO.findAll();
    }
}
