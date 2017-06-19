package com.pizzaplace.services;

import com.pizzaplace.entities.Pizza;

import java.util.List;

public interface PizzaService {

	List<Pizza> getPizzas();

	Pizza getPizza(int id);

	void addPizza(Pizza pizza);

}
