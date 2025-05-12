package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.User;
import exceptions.NotFoundException;

import java.util.UUID;

public class UsersDao {
	private final EntityManager entityManager;

	public UsersDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(User newUser) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(newUser);
		transaction.commit();
		System.out.println("L'utente " + newUser.getSurname() + " è stato creato!");

	}

	public User findById(String userId) {
		User found = entityManager.find(User.class, UUID.fromString(userId));
		if (found == null) throw new NotFoundException(userId);
		return found;
	}
}