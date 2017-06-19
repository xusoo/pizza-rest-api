package com.pizzaplace.dao;

import com.pizzaplace.entities.Ingredient;

import java.util.List;

public interface IngredientsDAO {

	void addIngredients(Ingredient... ingredients);

	List<Ingredient> getIngredients();
}
