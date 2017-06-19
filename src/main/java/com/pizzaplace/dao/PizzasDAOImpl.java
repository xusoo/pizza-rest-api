package com.pizzaplace.dao;

import com.pizzaplace.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class PizzasDAOImpl implements PizzasDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<Pizza> getPizzas() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			return entityManager.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Pizza getPizza(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			try {
				return entityManager.createQuery("SELECT p FROM Pizza p LEFT JOIN FETCH p.ingredients WHERE p.id = " + id, Pizza.class).getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void addPizza(Pizza pizza) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(pizza);
			transaction.commit();
		} finally {
			entityManager.close();
		}
	}
}
