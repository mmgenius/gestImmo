package GestionPersonne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import GestionAgence.RendezVous;
import Outils.Adresse;

public class EmployeeAgence extends Personne implements Serializable{
	public ArrayList<RendezVous> getCalendrier() {
		return calendrier;
	}

	public int getMatricule() {
		return matricule;
	}

	private ArrayList<RendezVous> calendrier;
	private int matricule;

	public EmployeeAgence(Adresse adresse, String email, String nom, String prenom, String tel,
			ArrayList<RendezVous> calendrier, int matricule) {
		super(adresse, email, nom, prenom, tel);
		this.calendrier = calendrier;
		this.matricule = matricule;
	}

	public boolean estDisponible(GregorianCalendar date) {
		return true;
	}
}
