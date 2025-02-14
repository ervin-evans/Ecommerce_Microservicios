package com.evans.users.controllers;

import com.evans.users.models.User;
import com.evans.users.requests.UserRequest;
import com.evans.users.responses.UserResponse;
import com.evans.users.services.IUserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserResponse> createNewUser(@Valid @RequestBody UserRequest userRequest) {
        LOGGER.info("Iniciando SOLICITUD para crear un usuario...");
        User user = iUserService.createUser(userRequest);
        var userResponse = iUserService.mapToUserResponse(user);
        LOGGER.info("Terminando SOLICITUD para crear un usuario con exito");
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
