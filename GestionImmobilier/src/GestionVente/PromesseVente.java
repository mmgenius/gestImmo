package GestionVente;

import java.util.GregorianCalendar;

import GestionPersonne.Client;
import Outils.Adresse;

public class PromesseVente {
	
	private Adresse adresseNotaire ;
	private float fraisDeVente, commissionAgence ; 
	private GregorianCalendar dateDeVente ; 
	private boolean etatVente, promessePaye ; 
	private Client acheteur, vendeur ; 
	
	public PromesseVente(Client achteur, Client vend, float frais, float commAgence, GregorianCalendar dVente, Adresse addNotaire ) {
		
		acheteur = achteur ;
		vendeur = vend ; 
		fraisDeVente = frais ; 
		commissionAgence = commAgence ; 
		dateDeVente = dVente ; 
		adresseNotaire = addNotaire ; 
	}

	public Adresse getAdresseNotaire() {
		return adresseNotaire;
	}

	public void setAdresseNotaire(Adresse adresseNotaire) {
		this.adresseNotaire = adresseNotaire;
	}

	public float getCommissionAgence() {
		return commissionAgence;
	}

	public void setCommissionAgence(float commissionAgence) {
		this.commissionAgence = commissionAgence;
	}

	public GregorianCalendar getDateDeVente() {
		return dateDeVente;
	}

	public void setDateDeVente(GregorianCalendar dateDeVente) {
		this.dateDeVente = dateDeVente;
	}

	public float getFraisDeVente() {
		return fraisDeVente;
	}

	public void setFraisDeVente(float fraisDeVente) {
		this.fraisDeVente = fraisDeVente;
	}

	public boolean isPromessePaye() {
		return promessePaye;
	}

	public void setPromessePaye(boolean promessePaye) {
		this.promessePaye = promessePaye;
	}

	public boolean isEtatVente() {
		return etatVente;
	}

	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}

	public Client getVendeur() {
		return vendeur;
	}

	public void setVendeur(Client vendeur) {
		this.vendeur = vendeur;
	}

	public Client getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Client acheteur) {
		this.acheteur = acheteur;
	}
	
	public String toString() {
		return "Promesse de Vente_ :"+acheteur+","+vendeur+","+fraisDeVente+","+commissionAgence+","+dateDeVente+","+adresseNotaire+" STATUS_"+etatVente; 
	}
	

}
