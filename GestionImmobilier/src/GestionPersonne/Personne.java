package GestionPersonne;

import java.io.Serializable;

import Outils.Adresse;

public class Personne implements Serializable{
	public Adresse getAdresse() {
		return adresse;
	}

	public String getEmail() {
		return email;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTel() {
		return tel;
	}

	private Adresse adresse;
	private String email;
	private String nom;
	private String prenom;
	private String tel;
	public Personne(Adresse adresse, String email, String nom, String prenom, String tel) {
		super();
		this.adresse = adresse;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	
	public String genererID() {
		return "mamamia";
	}
}
