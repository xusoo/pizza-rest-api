package com.pizzaplace.services;

import com.pizzaplace.dao.UsersDAO;
import com.pizzaplace.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDAO dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User authenticateUser(String email, String password) throws IllegalAccessException {
		User user = dao.findUserByEmail(email);
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		throw new IllegalAccessException("Usuario o password incorrectos");
	}

	@Override
	public void registerUser(User user) {
		if (dao.findUserByEmail(user.getEmail()) != null) {
			throw new IllegalStateException("Ya existe un usuario con ese email");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.addUser(user);
	}
}
