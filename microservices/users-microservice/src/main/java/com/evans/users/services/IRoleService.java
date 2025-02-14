package com.evans.users.services;

import com.evans.users.models.Role;
import com.evans.users.models.UserRole;

import java.util.List;

public interface IRoleService{
    public List<Role>mapToRole(List<UserRole> userRoles);
}
