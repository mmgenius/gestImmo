package GestionPersonne;

import Outils.Adresse;

public class Client extends Personne {
	private int id;
	private Role role;
	
	public Client(Adresse adresse, String email, String nom, String prenom, String tel, int id) {
		super(adresse, email, nom, prenom, tel);
		this.id = id;
	}
	public void debiter() {
		
	}
	public void enregistrer() {
		
	}
	public void crediter() {
		
	}
}
