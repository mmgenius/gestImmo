package GestionAgence;

public class Document {
	public enum filetype {
		html, 
        css,  
        js};
    
	public Document(String contenu, filetype type) {
		super();
		this.contenu = contenu;
		this.type = type;
	}

	private String contenu; //filepath
	private filetype type;
	
	public void enregistrer() {
		
	}
}
