package com.example.actvitymatcher.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.management.relation.Role;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(Integer id);

    Optional<User> findByUsername(String username);
    Optional<User> findByPassword(String password);

    Optional<User> findByEmail(String email);

}
