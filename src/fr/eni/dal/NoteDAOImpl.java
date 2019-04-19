package fr.eni.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.eni.bo.Note;

public class NoteDAOImpl implements NoteDAO {

	@Override
	public void insert(Note note) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(note);
		session.getTransaction().commit();

	}

	@Override
	public void delete(int idNote) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Note note = (Note) session.get(Note.class, idNote);
		session.beginTransaction();

		session.delete(note);
		session.getTransaction().commit();

	}

	@Override
	public List<Note> listNote() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Note> liste = new ArrayList<>();
		Query q = session.createQuery("from Note");
		liste = q.getResultList();
		return liste;
	}

	@Override
	public void update(int id, String text) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Note note = (Note) session.get(Note.class, id);
		note.setTexte(text);
		session.beginTransaction();

		session.saveOrUpdate(note);
		session.getTransaction().commit();
	}

}
