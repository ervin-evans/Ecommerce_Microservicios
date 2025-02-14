package com.evans.users.loaders;

import com.evans.users.models.Role;
import com.evans.users.repositories.IRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RoleDataLoader implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDataLoader.class);
    private final IRoleRepository roleRepository;

    public RoleDataLoader(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (roleRepository.count() == 0) {
            LOGGER.info("Table de ROLES vacia");
            LOGGER.info("Insertando ROLES en la base de datos...");
            roleRepository.saveAll(List.of(
                    new Role(null, "ROLE_ADMIN"),
                    new Role(null, "ROLE_SECURITY_MANAGER"),
                    new Role(null, "ROLE_CUSTOMER"),
                    new Role(null, "ROLE_SELLER"),
                    new Role(null, "ROLE_INVENTORY_MANAGER"),
                    new Role(null, "ROLE_MARKETING_MANAGER"),
                    new Role(null, "ROLE_DATA_ANALYST"),
                    new Role(null, "ROLE_CUSTOMER_SUPPORT")
            ));
            LOGGER.info("ROLES insertados en la base de datos");
        } else {
            LOGGER.info("Los ROLES ya existen, no se insertaran nuevamente");
        }
    }
}
