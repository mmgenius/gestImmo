package GestionBien;

import java.util.GregorianCalendar;

import Outils.Adresse;

public class Appartement extends Bien {
	
	private float chargeMensuelle ; 
	private int nombreEtage, nombrePiece ;  
	
	public Appartement(int iden, float price, Adresse address, String Oriented, GregorianCalendar dispo,
			GregorianCalendar dateVente, float charge, int nbEtage, int nbPiece) {
		super(iden, price, address, Oriented, dispo, dateVente);
		chargeMensuelle = charge ; 
		nombreEtage = nbEtage ; 
		nombrePiece = nbPiece ; 	
	}

	public float getChargeMensuelle() {
		return chargeMensuelle;
	}

	public void setChargeMensuelle(float chargeMensuelle) {
		this.chargeMensuelle = chargeMensuelle;
	}
	
	public int getNombrePiece() {
		return nombrePiece;
	}

	public void setNombrePiece(int nombrePiece) {
		this.nombrePiece = nombrePiece;
	}

	public int getNombreEtage() {
		return nombreEtage;
	}

	public void setNombreEtage(int nombreEtage) {
		this.nombreEtage = nombreEtage;
	}
	
	public String toString() {
		return super.toString()+","+chargeMensuelle+","+nombreEtage+","+nombrePiece; 
	}
	

	
	

}
