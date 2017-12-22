package GestionBien;

import java.io.Serializable;
import java.util.GregorianCalendar;

import Outils.Adresse;

public class Maison extends Bien implements Serializable{

	private float surfaceHabitable ; 
	private int nombreEtage, nombrePiece ; 
	private String moyenChauffage ; 
	private String titre;
	
	public Maison(int iden, float price, Adresse address, String Oriented, GregorianCalendar dispo,
			GregorianCalendar dateVente, float surface, int nbEt, int nbP, String chauf, String titre) {
		super(iden, price, address, Oriented, dispo, dateVente);
		surfaceHabitable = surface ; 
		nombreEtage = nbEt ; 
		nombrePiece = nbP ; 
		moyenChauffage = chauf ;
		this.titre = titre;
		
	}

	public float getSurfaceHabitable() {
		return surfaceHabitable;
	}

	public void setSurfaceHabitable(float surfaceHabitable) {
		this.surfaceHabitable = surfaceHabitable;
	}

	public int getNombrePiece() {
		return nombrePiece;
	}

	public void setNombrePiece(int nombrePiece) {
		this.nombrePiece = nombrePiece;
	}

	public String getMoyenChauffage() {
		return moyenChauffage;
	}

	public void setMoyenChauffage(String moyenChauffage) {
		this.moyenChauffage = moyenChauffage;
	}

	public int getNombreEtage() {
		return nombreEtage;
	}

	public void setNombreEtage(int nombreEtage) {
		this.nombreEtage = nombreEtage;
	}
	
	public String toString() {
		return super.getOrientation()+","+surfaceHabitable+","+nombreEtage+","+nombrePiece+","+moyenChauffage ; 
	}

	public String getTitre() {
		return this.titre;
	}

}
