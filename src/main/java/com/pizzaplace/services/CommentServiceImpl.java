package com.pizzaplace.services;

import com.pizzaplace.dao.CommentsDAO;
import com.pizzaplace.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsDAO dao;

	@Override
	public List<Comment> getCommentsByPizza(int pizzaId) {
		return dao.getCommentsByPizza(pizzaId);
	}

	@Override
	public void addComment(Comment comment) {
		dao.addComment(comment);
	}
}
