package com.pizzaplace.services;


import com.pizzaplace.entities.Comment;

import java.util.List;

public interface CommentService {
	List<Comment> getCommentsByPizza(int pizzaId);

	void addComment(Comment comment);
}
