package dao;

import entities.Evento;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDao {
	
	private final EntityManager em;
	
	public EventDao(EntityManager em) {
		this.em = em;
	}
	
	public void save(Evento newEvent) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(newEvent);
		transaction.commit();
		System.out.println("L'evento "+ newEvent.getTitolo()+" è stato salvato correttamente nel db");
	}
	
	public Evento findById(long idEvento) {
		Evento found = em.find(Evento.class, idEvento);
		return found;
	}
	
	public void findByIdAndDelete(long idEvento) {
		Evento found = this.findById(idEvento);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(found);
		transaction.commit();
		System.out.println("L'evento "+found.getTitolo()+ " è stato rimosso dal DB!");
	}

}