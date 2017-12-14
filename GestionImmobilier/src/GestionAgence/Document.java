package GestionAgence;

public class Document {    
	public Document(String contenu, Filetype type) {
		super();
		this.contenu = contenu;
		this.type = type;
	}

	private String contenu; //filepath
	private Filetype type;
	
	public void enregistrer() {
		
	}
}
