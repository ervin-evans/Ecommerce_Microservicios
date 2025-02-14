package com.evans.users.services;

import com.evans.users.models.Role;
import com.evans.users.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Override
    public List<Role> mapToRole(List<UserRole> userRoles) {
        List<Role> roles = new ArrayList<>();
        userRoles.forEach(userRole -> {
            roles.add(userRole.getRole());
        });
        return roles;
    }
}
