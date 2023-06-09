package com.api.tweteroojava.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tweteroojava.models.UsersModel;

public interface UserRepository extends JpaRepository<UsersModel, UUID>{
    
}
