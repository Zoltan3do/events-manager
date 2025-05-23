package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Category;
import exceptions.NotFoundException;

import java.util.UUID;

public class CategoriesDao {
	private final EntityManager em;

	public CategoriesDao(EntityManager em) {
		this.em = em;
	}

	public void save(Category category) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(category);
		transaction.commit();
		System.out.println("La categoria" + category.getName() + " è stato salvata correttamente!");
	}

	public Category findById(String categoryId) {
		Category found = em.find(Category.class, UUID.fromString(categoryId));
		if (found == null) throw new NotFoundException(categoryId);
		return found;
	}
}