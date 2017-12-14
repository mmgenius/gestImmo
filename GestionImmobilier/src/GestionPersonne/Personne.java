package GestionPersonne;

import Outils.Adresse;

public class Personne {
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
