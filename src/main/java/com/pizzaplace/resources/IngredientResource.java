package com.pizzaplace.resources;

import com.pizzaplace.entities.Ingredient;
import com.pizzaplace.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ingredients")
public class IngredientResource {

	@Autowired
	private IngredientService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredient> getIngredients() {
		return service.getIngredients();
	}

}
