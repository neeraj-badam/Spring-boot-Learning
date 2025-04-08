package com.telusko.WebApp.repository;

import com.telusko.WebApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{

    Users findByUsername(String username);
}