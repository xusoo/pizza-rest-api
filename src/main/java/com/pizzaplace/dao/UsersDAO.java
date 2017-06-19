package com.pizzaplace.dao;

import com.pizzaplace.entities.User;

public interface UsersDAO {

	User findUserByEmail(String email);

	void addUser(User user);

}
