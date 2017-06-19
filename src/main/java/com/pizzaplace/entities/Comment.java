package com.pizzaplace.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "COMMENTS")
public class Comment {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(max = 500)
	private String text;

	@Min(0)
	@Max(10)
	private int rating;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	private User user;

	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Pizza pizza;

	public Comment() {
	}

	public Comment(String text, int rating, Date date, User user, Pizza pizza) {
		this.text = text;
		this.rating = rating;
		this.date = date;
		this.user = user;
		this.pizza = pizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
}
