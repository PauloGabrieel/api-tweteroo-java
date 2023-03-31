package com.api.tweteroojava.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroojava.dtos.UserDto;
import com.api.tweteroojava.models.UsersModel;
import com.api.tweteroojava.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600 )
@RestController
@RequestMapping("/sign-up")
public class UserController {

    final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        UsersModel usernModel = new UsersModel();
        BeanUtils.copyProperties(userDto, usernModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usernModel));
    }
}