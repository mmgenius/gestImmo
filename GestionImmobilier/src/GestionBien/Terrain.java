package GestionBien;
import java.util.GregorianCalendar;

import Outils.Adresse;

public class Terrain extends Bien{
	private float longeurFacade ; 
	private float surfaceSol ; 

	public Terrain(int iden, float price, Adresse address, String Oriented, GregorianCalendar dispo,
			GregorianCalendar dateVente, float facade, float sol) {
		super(iden, price, address, Oriented, dispo, dateVente);
		longeurFacade = facade ; 
		surfaceSol = sol ; 	
		
	}
	

	public float getLongeurFacade() {
		return longeurFacade;
	}

	public void setLongeurFacade(float longeurFacade) {
		this.longeurFacade = longeurFacade;
	}

	public float getSurfaceSol() {
		return surfaceSol;
	}

	public void setSurfaceSol(float surfaceSol) {
		this.surfaceSol = surfaceSol;
	}
	
	public String toString() {
		return super.toString()+","+longeurFacade+","+surfaceSol; 
	}
	

}
