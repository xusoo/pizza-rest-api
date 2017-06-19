package com.pizzaplace.services;


import com.pizzaplace.entities.User;

public interface UserService {

	/**
	 * Busca un usuario con el email proporcionado y comprueba si la contraseña coincide.
	 *
	 * @param email    Correo electrónico
	 * @param password Contraseña
	 * @return Usuario encontrado
	 * @throws IllegalAccessException Si el usuario no se ha encontrado o el password es incorrecto
	 */
	User authenticateUser(String email, String password) throws IllegalAccessException;

	/**
	 * Registra un nuevo usuario en el sistema
	 *
	 * @param user Usuario
	 * @throws IllegalStateException Si ya existe un usuario con ese email
	 */
	void registerUser(User user);
}
