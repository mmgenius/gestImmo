package GestionAgence;

import java.util.GregorianCalendar;

import GestionBien.Bien;
import GestionPersonne.Client;
import GestionPersonne.EmployeeAgence;

public class RendezVous {
	public GregorianCalendar getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	private GregorianCalendar date ;
	private String description;
	private String title;
	private EmployeeAgence e;
	private Client c;
	private Bien b;
	
	public String[] toArray() {
		String s[] = {this.date.getTime().toString(), this.title};
		return s;
	}
	@Override
	public String toString() {
		return this.date.DAY_OF_MONTH+"/"+this.date.MONTH+"/"+this.date.YEAR+ ","+this.date.HOUR+"h"+this.date.MINUTE;
	}

	public RendezVous(GregorianCalendar date, String description, String title, EmployeeAgence e, Client c, Bien b) {
		super();
		this.date = date;
		this.description = description;
		this.title = title;
		this.e = e;
		this.c = c;
		this.b = b;
	}
}
