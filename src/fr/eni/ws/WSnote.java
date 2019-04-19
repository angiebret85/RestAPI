package fr.eni.ws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.eni.bll.NoteManager;
import fr.eni.bo.Note;

@Path("/notes")
public class WSnote {
	NoteManager mgr = new NoteManager();

	private static List<Note> listeNotes = new ArrayList<>();

	@GET
	public List<Note> getNote() {
		listeNotes = mgr.listNote();
		return listeNotes;
	}

	@POST
	public Note ajouterNote(@FormParam("paramContenu") String nom) {
		String dateJour;
		dateJour = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Note note = new Note();
		note.setTexte(nom);
		note.setDate(dateJour);
		mgr.ajoutNote(note);
		listeNotes.add(note);
		return note;
	}

	@DELETE
	@Path("/{id:\\d+}")
	public void supprimerNote(@PathParam("id") int id) {

		mgr.delete(id);
	}

	@PUT
	@Path("/{id:\\d+}")
	public void updateNote(@PathParam("id") int id, @FormParam("paramContenu") String nom) {
		mgr.modifNote(id, nom);
	}
}
