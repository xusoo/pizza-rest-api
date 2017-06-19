package com.pizzaplace.config;

import com.pizzaplace.entities.Comment;
import com.pizzaplace.entities.Ingredient;
import com.pizzaplace.entities.Pizza;
import com.pizzaplace.entities.User;
import com.pizzaplace.services.CommentService;
import com.pizzaplace.services.IngredientService;
import com.pizzaplace.services.PizzaService;
import com.pizzaplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Cargamos datos de prueba en el arranque
 */
@Component
public class BootstrapSampleData {

	@Autowired
	@EventListener(ContextStartedEvent.class)
	void contextInitialized(ApplicationContext context) {

		//<editor-fold desc="Usuarios">
		User user = new User("Josep", "Marí", "josepmc90@gmail.com", "12345678");
		context.getBean(UserService.class).registerUser(user);
		//</editor-fold>

		//<editor-fold desc="Ingredientes">
		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient carne = new Ingredient("Carne", 4);
		ingredients.add(carne);
		Ingredient salsaBarbacoa = new Ingredient("Salsa barbacoa", 1);
		ingredients.add(salsaBarbacoa);
		Ingredient cebolla = new Ingredient("Cebolla", 1);
		ingredients.add(cebolla);
		Ingredient champinyones = new Ingredient("Champiñones", 2);
		ingredients.add(champinyones);
		Ingredient nata = new Ingredient("Nata", 1);
		ingredients.add(nata);
		Ingredient bacon = new Ingredient("Bacon", 3);
		ingredients.add(bacon);
		Ingredient queso = new Ingredient("Queso", 1);
		ingredients.add(queso);
		Ingredient pinya = new Ingredient("Piña", 3);
		ingredients.add(pinya);
		Ingredient jamon = new Ingredient("Jamón", 3);
		ingredients.add(jamon);
		Ingredient pimiento = new Ingredient("Pimiento", 2);
		ingredients.add(pimiento);
		Ingredient anchoas = new Ingredient("Anchoas", 3);
		ingredients.add(anchoas);
		Ingredient pepperoni = new Ingredient("Pepperoni", 2);
		ingredients.add(pepperoni);
		context.getBean(IngredientService.class).addIngredients(ingredients.toArray(new Ingredient[ingredients.size()]));
		//</editor-fold>

		//<editor-fold desc="Pizzas">
		Pizza bbq = new Pizza("Barbacoa", "http://recetasdecocina.elmundo.es/wp-content/uploads/2015/05/barbacoa-telepizza-receta-casera.jpg");
		bbq.setIngredients(Arrays.asList(carne, salsaBarbacoa, cebolla));
		context.getBean(PizzaService.class).addPizza(bbq);
		Pizza carbonara = new Pizza("Carbonara", "http://dhmagazine.es/wp-content/uploads/2016/01/pizza.jpg");
		carbonara.setIngredients(Arrays.asList(cebolla, champinyones, nata, bacon));
		context.getBean(PizzaService.class).addPizza(carbonara);

		Pizza hawaiana = new Pizza("Hawaiana", "https://www.recetin.com/wp-content/uploads/2015/05/pizza_hawaiana.jpg");
		hawaiana.setIngredients(Arrays.asList(jamon, pinya));
		context.getBean(PizzaService.class).addPizza(hawaiana);

		Pizza margarita = new Pizza("Margarita", "https://img.difoosion.com/wp-content/blogs.dir/32/files/2015/06/pizza-Margarita.jpg");
		context.getBean(PizzaService.class).addPizza(margarita);

		Pizza pepperoniPizza = new Pizza("Pepperoni", "https://cdn4.ruled.me/wp-content/uploads/2014/08/pepperonipizza.jpg");
		pepperoniPizza.setIngredients(Arrays.asList(pepperoni, queso));
		context.getBean(PizzaService.class).addPizza(pepperoniPizza);
		//</editor-fold>

		//<editor-fold desc="Comentarios">
		Arrays.asList(
				new Comment("¡Muy buena!", 7, new Date(), user, bbq),
				new Comment("Buenísima 😁", 8, new Date(), user, bbq),
				new Comment("La mejor carbonara que he probado nunca 😋", 9, new Date(), user, carbonara),
				new Comment("¿A quién se le ocurre poner piña a una pizza? 😖", 1, new Date(), user, hawaiana),
				new Comment("Sencilla pero deliciosa 👌", 7, new Date(), user, margarita)
		).forEach((comment) -> context.getBean(CommentService.class).addComment(comment));
		//</editor-fold>

	}

}
