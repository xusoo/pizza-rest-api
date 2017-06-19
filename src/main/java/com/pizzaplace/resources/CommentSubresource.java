package com.pizzaplace.resources;

import com.pizzaplace.entities.Comment;
import com.pizzaplace.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class CommentSubresource {

	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET, value = "{pizzaId}/comments")
	public List<Comment> getCommentsByPizza(@PathVariable("pizzaId") int pizzaId) {
		return service.getCommentsByPizza(pizzaId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "{pizzaId}/comments")
	public Comment addComment(@RequestBody Comment comment) {
		service.addComment(comment);
		return comment;
	}
}
