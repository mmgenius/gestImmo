package GestionAgence;

import java.util.GregorianCalendar;

public class RendezVous {
	private GregorianCalendar date ;
	private String description;
	private int idBien;
	private String title;
	public String[] toArray() {
		String s[] = {this.date.getTime().toString(), this.title};
		return s;
	}
}
