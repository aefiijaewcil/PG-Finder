package com.pgfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgfinder.entities.User;
import com.pgfinder.enums.Role;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") Role role);

    @Query("SELECT u.id, u.role FROM User u WHERE u.username = :username AND u.password = :password")
    List<Object[]> findIdAndRoleByUsernameAndPassword(@Param("username") String username,
            @Param("password") String password);

}
