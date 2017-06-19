package com.pizzaplace.resources;

import com.pizzaplace.entities.Pizza;
import com.pizzaplace.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pizzas")
public class PizzaResource {

	@Autowired
	private PizzaService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Pizza> getPizzas() {
		return service.getPizzas().stream().map((pizza) -> {
			/* Son relaciones lazy-load, si intentamos devolverlas falla */
			pizza.setComments(Collections.emptyList());
			pizza.setIngredients(Collections.emptyList());
			return pizza;
		}).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Pizza> getPizza(@PathVariable("id") int id) {
		Pizza pizza = service.getPizza(id);
		if (pizza == null) {
			return ResponseEntity.notFound().build();
		}
		pizza.setComments(Collections.emptyList());
		return ResponseEntity.ok(pizza);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Pizza addPizza(@RequestBody Pizza pizza) {
		service.addPizza(pizza);
		return pizza;
	}

	@RequestMapping(value = "{pizzaId}/comments")
	public CommentSubresource getComments() {
		return new CommentSubresource();
	}

}
