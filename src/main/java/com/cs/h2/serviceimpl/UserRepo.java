package com.cs.h2.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.h2.jpa.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
