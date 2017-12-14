package GestionAgence;

public class Document {
	public enum filetype {
		html, 
        css,  
        js};
	private String contenu; //filepath
	private filetype type;
}
