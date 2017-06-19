package com.pizzaplace.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PIZZAS")
public class Pizza {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String name;

	@NotNull
	private String imagePath;

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Ingredient> ingredients = Collections.emptyList();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pizza", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Comment> comments = Collections.emptyList();

	@Transient
	@JsonInclude
	private float price;

	public Pizza() {
	}

	public Pizza(String name, String imagePath) {
		this.name = name;
		this.imagePath = imagePath;
	}

	//<editor-fold desc="Getters/Setters">
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	//</editor-fold>


}
