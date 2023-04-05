package com.api.tweteroojava.services;

import org.springframework.stereotype.Service;

import com.api.tweteroojava.models.UsersModel;
import com.api.tweteroojava.repositories.UserRepository;

@Service
public class UserService {
    
    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UsersModel save( UsersModel usersModel) {
        try {
            return userRepository.save(usersModel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

}
