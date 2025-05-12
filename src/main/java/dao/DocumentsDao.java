package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.Document;
import exceptions.NotFoundException;

import java.util.UUID;

public class DocumentsDao {
	private final EntityManager entityManager;

	public DocumentsDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Document newDocument) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(newDocument);
		transaction.commit();
		System.out.println("Il documento " + newDocument.getCode() + " è stato creato!");

	}

	public Document findById(String documentId) {
		Document found = entityManager.find(Document.class, UUID.fromString(documentId));
		if (found == null) throw new NotFoundException(documentId);
		return found;
	}
}