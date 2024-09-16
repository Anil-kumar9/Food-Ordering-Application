package com.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
