package com.evans.users.services;

import com.evans.users.models.Role;
import com.evans.users.models.User;
import com.evans.users.models.UserRole;
import com.evans.users.repositories.IUserRepository;
import com.evans.users.repositories.IUserRoleRepository;
import com.evans.users.requests.UserRequest;
import com.evans.users.responses.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Autowired
    private IRoleService iRoleService;

    @Transactional
    @Override
    public User createUser(UserRequest userRequest) {
        LOGGER.info("Guardando usuario " + userRequest.getUsername() + " ...");
        User user = User.builder()
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .lastname(userRequest.getLastname())
                .username(userRequest.getUsername())
                .password(encoder.encode(userRequest.getPassword()))
                .isActive(false)
                .email(userRequest.getEmail())
                .build();
        var userSaved = iUserRepository.save(user);
        LOGGER.info("El USUARIO " + userSaved.getUsername() + "ha sido guardado.");
        return userSaved;
    }

    @Override
    public UserResponse mapToUserResponse(User user) {
        LOGGER.info("Buscando ROLES del usuario...");
        List<UserRole> userRoles = iUserRoleRepository.findByUser(user);
        LOGGER.info("Mapeando ROLES del usuario...");
        List<Role> roles = iRoleService.mapToRole(userRoles);
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .username(user.getUsername())
                .isActive(user.getIsActive())
                .imageProfile(user.getImageProfile())
                .roles(roles)
                .build();

    }

}
