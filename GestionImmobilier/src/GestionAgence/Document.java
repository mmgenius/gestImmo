package GestionAgence;

public class Document {
	public enum filetype {/** passager assis � l'int�rieur */  html, 
        /** passager debout � l'int�rieur */ css,  
        /** passager � l'ext�rieur */        js};
	private String contenu; //filepath
	private filetype type;
}
