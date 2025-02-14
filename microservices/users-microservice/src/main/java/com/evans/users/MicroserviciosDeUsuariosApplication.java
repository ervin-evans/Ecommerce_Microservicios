package com.evans.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableDiscoveryClient
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MicroserviciosDeUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosDeUsuariosApplication.class, args);
	}

}
