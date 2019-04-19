package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Note;

public interface NoteDAO {
	public void insert(Note note);

	public void delete(int idNote);

	public List<Note> listNote();

	public void update(int id, String text);

}
