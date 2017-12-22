package GestionAgence;

import java.io.Serializable;

public class Document implements Serializable{    
	public Document(String contenu, String type) {
		super();
		this.contenu = contenu;
		this.type = type;
	}

	private String contenu; //filepath
	public String getContenu() {
		return contenu;
	}

	private String type;
	
	public void enregistrer() {
		
	}
	@Override
	public String toString() {
		if(contenu.length()>10)
			return contenu.substring(contenu.length()-10);
		else 
			return contenu;
	}
}
