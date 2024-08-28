package com.epam.user.management.application.service;

import com.epam.user.management.application.constants.Role;
import com.epam.user.management.application.dao.UserDAO;
import com.epam.user.management.application.dto.UserDto;
import com.epam.user.management.application.entity.User;
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

    @Override
    public User register(UserDto user){
        if (userDAO.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println(encodedPassword);

        // Determine role
        Role role = Role.USER;
        if ("ADMIN".equals(user.getRole())) {
            role = Role.ADMIN;
        }

        User user1 = new User();
        user1.setFirst_name(user.getFirst_name());
        user1.setLast_name(user.getLast_name());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setGender(user.getGender());
        user1.setPhone_number(user.getPhone_number());
        user1.setPassword(encodedPassword);
        user1.setRole(role);

        return userDAO.save(user1);
    }

    @Override
    public List<User> getall() {
        return userDAO.findAll();
    }
}
