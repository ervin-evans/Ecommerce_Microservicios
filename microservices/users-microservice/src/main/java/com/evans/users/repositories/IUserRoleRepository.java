package com.evans.users.repositories;

import com.evans.users.models.User;
import com.evans.users.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(User user);
}
