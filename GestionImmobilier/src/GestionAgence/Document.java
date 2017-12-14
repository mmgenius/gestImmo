package GestionAgence;

public class Document {
	public enum filetype {/** passager assis à l'intérieur */  html, 
        /** passager debout à l'intérieur */ css,  
        /** passager à l'extérieur */        js};
	private String contenu; //filepath
	private filetype type;
}
