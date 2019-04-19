package fr.eni.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Note {

	@Id
	@GeneratedValue
	private int idNote;
	private String texte;
	private String date;

	/**
	 * @return the idNote
	 */
	public int getIdNote() {
		return idNote;
	}

	/**
	 * @param idNote
	 *            the idNote to set
	 */
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	/**
	 * @return the texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte
	 *            the texte to set
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public Note(int idNote, String texte, String date) {
		super();
		this.idNote = idNote;
		this.texte = texte;
		this.date = date;
	}

	public Note(String texte, String date) {
		super();
		this.texte = texte;
		this.date = date;
	}

	public Note() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Note [idNote=" + idNote + ", texte=" + texte + ", date=" + date + "]";
	}

}