package com.pizzaplace.resources;

import com.pizzaplace.entities.User;
import com.pizzaplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
/**
 * Controlador de autenticación dummy para pruebas
 */
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
		try {
			User user = service.authenticateUser(email, password);
			return ResponseEntity.ok(user);
		} catch (IllegalAccessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user) {
		try {
			service.registerUser(user);
			return ResponseEntity.ok(user);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
