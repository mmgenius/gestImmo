package GestionAgence;

import java.util.ArrayList;

public class Publicite {
	public enum TypePub {Journal, Tele, Annonce};
	private TypePub type;
	private ArrayList<Document> docs;
	
	public void modifier(Document doc) {
		
	}

	public Publicite(TypePub type, ArrayList<Document> docs) {
		super();
		this.type = type;
		this.docs = docs;
	}

	public void publier() {
		//
		
	}
	public void supprimer(Document doc) {
		
	}
}
