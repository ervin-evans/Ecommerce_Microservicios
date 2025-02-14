package com.evans.users.services;

import com.evans.users.models.User;
import com.evans.users.requests.UserRequest;
import com.evans.users.responses.UserResponse;

import java.util.List;

public interface IUserService {
    public User createUser(UserRequest userRequest);
    public UserResponse mapToUserResponse(User user);
}
