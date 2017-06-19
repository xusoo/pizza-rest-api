package com.pizzaplace.dao;

import com.pizzaplace.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public User findUserByEmail(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			try {
				return entityManager.createQuery("SELECT u FROM User u WHERE u.email = \'" + email + "\'", User.class).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
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
