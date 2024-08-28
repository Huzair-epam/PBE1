package com.epam.user.management.application.dao;

import com.epam.user.management.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {
    public boolean existsByEmail(String email);
}
