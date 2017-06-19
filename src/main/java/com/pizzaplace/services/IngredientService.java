package com.pizzaplace.services;

import com.pizzaplace.entities.Ingredient;

import java.util.List;

public interface IngredientService {

	void addIngredients(Ingredient... ingredients);

	/**
	 * @return Lista con todos los ingredientes disponibles en el sistema
	 */
	List<Ingredient> getIngredients();

}
