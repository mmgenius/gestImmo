package GestionAgence;

import java.io.Serializable;
import java.util.ArrayList;

public class Publicite implements Serializable{
	public enum TypePub {Journal, Tele, Annonce};
	private TypePub type;
	private ArrayList<Document> docs;
	private int idBien;
	private boolean publie;
	private String titre;
	
	public void modifier(Document doc) {
		
	}

	public Publicite(TypePub type, ArrayList<Document> docs, String titre) {
		super();
		this.type = type;
		this.docs = docs;
		this.publie = false;
		this.titre = titre;
	}

	public TypePub getType() {
		return type;
	}

	public ArrayList<Document> getDocs() {
		return docs;
	}

	public boolean isPublie() {
		return publie;
	}

	public String getTitre() {
		return titre;
	}

	public void publier() {
		publie = true;
		
	}
	public void supprimer(Document doc) {
		
	}
}
