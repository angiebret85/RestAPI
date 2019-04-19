package fr.eni.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class runner {
	@Test
	public void main() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Note note = new Note("une nouvelle note", "18-12-2015");

		session.beginTransaction();
		session.saveOrUpdate(note);
		session.getTransaction().commit();
	}
}
