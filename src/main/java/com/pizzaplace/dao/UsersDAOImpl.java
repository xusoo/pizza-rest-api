package com.pizzaplace.dao;

import com.pizzaplace.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public User findUserByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void addUser(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} finally {
			entityManager.close();
		}
	}
}
