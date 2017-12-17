package GestionPersonne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import Outils.Adresse;

public class EmployeeAgence extends Personne implements Serializable{
	private ArrayList<GregorianCalendar> calendrier;
	private int matricule;

	public EmployeeAgence(Adresse adresse, String email, String nom, String prenom, String tel,
			ArrayList<GregorianCalendar> calendrier, int matricule) {
		super(adresse, email, nom, prenom, tel);
		this.calendrier = calendrier;
		this.matricule = matricule;
	}

	public boolean estDisponible(GregorianCalendar date) {
		return true;
	}
}
