package com.pizzaplace.dao;

import com.pizzaplace.entities.Pizza;

import java.util.List;

public interface PizzasDAO {

	List<Pizza> getPizzas();

	Pizza getPizza(int id);

	void addPizza(Pizza pizza);

}
