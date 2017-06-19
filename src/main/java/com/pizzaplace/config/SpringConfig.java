package com.pizzaplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class SpringConfig {

	private static final String PERSISTENCE_UNIT = "com.pizzaplace.persistenceunit";

	@Bean
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}

	@Bean
	@Autowired
	@Scope(value = "prototype")
	public EntityManager getEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
