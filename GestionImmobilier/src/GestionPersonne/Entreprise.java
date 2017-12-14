package GestionPersonne;

import Outils.Adresse;

public class Entreprise extends Client {
	private String numeroSiren;

	public Entreprise(Adresse adresse, String email, String nom, String prenom, String tel, int id,
			String numeroSiren) {
		super(adresse, email, nom, prenom, tel, id);
		this.numeroSiren = numeroSiren;
	}
}	
