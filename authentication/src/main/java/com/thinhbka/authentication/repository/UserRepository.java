package com.thinhbka.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinhbka.authentication.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
