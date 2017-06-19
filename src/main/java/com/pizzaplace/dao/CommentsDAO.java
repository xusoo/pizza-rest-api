package com.pizzaplace.dao;

import com.pizzaplace.entities.Comment;

import java.util.List;

public interface CommentsDAO {

	List<Comment> getCommentsByPizza(int pizzaId);

	void addComment(Comment comment);

}
