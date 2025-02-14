package com.evans.users.repositories;

import com.evans.users.models.Role;
import com.evans.users.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IRoleRepository extends CrudRepository<Role, UUID> {
    Role findByName(String name);
}
