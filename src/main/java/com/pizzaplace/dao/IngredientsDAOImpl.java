package com.pizzaplace.dao;

import com.pizzaplace.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.List;

@Repository
public class IngredientsDAOImpl implements IngredientsDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void addIngredients(Ingredient... ingredients) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Arrays.stream(ingredients).forEach(entityManager::persist);
			transaction.commit();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Ingredient> getIngredients() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			return entityManager.createQuery("SELECT i FROM Ingredient i", Ingredient.class).getResultList();
		} finally {
			entityManager.close();
		}
	}
}
