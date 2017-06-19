package com.pizzaplace.services;

import com.pizzaplace.dao.PizzasDAO;
import com.pizzaplace.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

	private static final int PROFIT_MARGIN = 5;

	@Autowired
	private PizzasDAO dao;

	@Override
	public List<Pizza> getPizzas() {
		return dao.getPizzas();
	}

	@Override
	public Pizza getPizza(int id) {
		Pizza pizza = dao.getPizza(id);
		if (pizza != null) {
			pizza.setPrice(getPizzaPrice(pizza));
		}
		return pizza;
	}

	@Override
	public void addPizza(Pizza pizza) {
		dao.addPizza(pizza);
	}

	/**
	 * Devuelve la suma del precio de todos los ingredientes más nuestro margen de beneficio
	 */
	private static float getPizzaPrice(Pizza pizza) {
		return PROFIT_MARGIN + pizza.getIngredients().stream().map(ingredient -> ingredient.getPrice()).reduce(0f, (v1, v2) -> v1 + v2);
	}

}
