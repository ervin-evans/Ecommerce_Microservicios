package com.evans.users.repositories;

import com.evans.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
