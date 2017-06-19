package com.pizzaplace.services;

import com.pizzaplace.dao.IngredientsDAO;
import com.pizzaplace.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientsDAO dao;

	@Override
	public void addIngredients(Ingredient... ingredients) {
		dao.addIngredients(ingredients);
	}

	@Override
	public List<Ingredient> getIngredients() {
		return dao.getIngredients();
	}
}
