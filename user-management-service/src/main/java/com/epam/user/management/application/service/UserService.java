package com.epam.user.management.application.service;

import com.epam.user.management.application.dto.UserDto;
import com.epam.user.management.application.entity.User;

import java.util.List;

public interface UserService {
    public <T> T register(UserDto user);
    public List<User> getall();
}
