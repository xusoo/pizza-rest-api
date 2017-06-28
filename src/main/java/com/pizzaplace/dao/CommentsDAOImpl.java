package com.pizzaplace.dao;

import com.pizzaplace.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentsDAOImpl implements CommentsDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Comment> getCommentsByPizza(int pizzaId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c WHERE c.pizza.id = :pizzaId", Comment.class);
			query.setParameter("pizzaId", pizzaId);
			return query.getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void addComment(Comment comment) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(comment);
			transaction.commit();
		} finally {
			entityManager.close();
		}
	}
}
