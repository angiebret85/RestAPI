package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Note;
import fr.eni.dal.NoteDAO;

public class NoteManager {
	private NoteDAO noteDao;

	public NoteManager() {
		this.noteDao = fr.eni.dal.DAOFactory.getNoteDAO();
	}

	public Note ajoutNote(Note note) {
		this.noteDao.insert(note);
		return note;
	}

	public List<Note> listNote() {
		List<Note> liste = new ArrayList<>();
		liste = this.noteDao.listNote();
		return liste;

	}

	public void delete(int idNote) {
		this.noteDao.delete(idNote);
	}

	public void modifNote(int id, String text) {
		this.noteDao.update(id, text);
	}
}
