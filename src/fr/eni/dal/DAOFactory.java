package fr.eni.dal;

public class DAOFactory {
	public static NoteDAO getNoteDAO() {
		return new NoteDAOImpl();
	}
}
