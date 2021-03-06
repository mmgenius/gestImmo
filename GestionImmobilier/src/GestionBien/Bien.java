package GestionBien;

import java.io.Serializable;
import java.util.GregorianCalendar;

import Outils.Adresse;

public class Bien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Bien(int id, float prix, Adresse adresse, String orientation, GregorianCalendar dateDeDisponibilite,
			GregorianCalendar dateDeVente) {
		super();
		this.id = id;
		this.prix = prix;
		this.adresse = adresse;
		this.orientation = orientation;
		this.dateDeDisponibilite = dateDeDisponibilite;
		this.dateDeVente = dateDeVente;
	}

	private int id ; 
	private float prix ; 
	private Adresse adresse ; 
	private String orientation ; 
	private GregorianCalendar dateDeDisponibilite ; 
	private GregorianCalendar dateDeVente ;
	
	//This's the Constructor of this class
	//public Bien(int iden , float price, Adresse address, String Oriented, GregorianCalendar dispo, GregorianCalendar dateVente) {
		//merci de rien avoir foutu dedans Mamadou -.-
		//for christs sake
		
	//}
	
	//This method give you the part of company in sale business 
	public float calculerCommission() {
		return (this.prix * 7 / 100); 
	}
	
	//This method give you the first part of seller in sale business 
	public float calculerPromesse() {
		return (this.prix/10); 
	}
		
	
	
	//You can get or update the Id with this: 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//You can get or update the price with: 
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	//You can get or update the address with:
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	//You already can get or make change the orientation from: 
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	//You can get or update the Permission date
	public GregorianCalendar getDateDeDisponibilite() {
		return dateDeDisponibilite;
	}
	public void setDateDeDisponibilite(GregorianCalendar dateDeDisponibilite) {
		this.dateDeDisponibilite = dateDeDisponibilite;
	}
	
	//You can get or update the sale date
	public GregorianCalendar getDateDeVente() {
		return dateDeVente;
	}
	public void setDateDeVente(GregorianCalendar dateDeVente) {
		this.dateDeVente = dateDeVente;
	} 
	
	public String toString() {
		return "Bien_"+id+","+adresse+","+prix+","+orientation+","+dateDeDisponibilite+","+dateDeVente ; 
	}
	
	
	

}
