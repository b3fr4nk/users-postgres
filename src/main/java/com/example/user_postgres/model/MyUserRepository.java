package com.example.user_postgres.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long>{

    Optional<MyUser> findByUsername(String username);

    @Query("SELECT u From MyUser u")
    List<MyUser> findAllUsers();

}