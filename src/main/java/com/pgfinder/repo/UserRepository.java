package com.pgfinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgfinder.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
