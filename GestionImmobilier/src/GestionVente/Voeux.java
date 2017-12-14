package GestionVente;
import GestionBien.Bien; 
import java.util.ArrayList;
import java.util.List;


public class Voeux {
	private int id ; 
	private List<Bien> mesVoeux = new ArrayList<>(3); 
	public Voeux(int iden) {
		setId(iden) ; 
	}
	
	public void ajouterVoeux(Bien leBien) {
		this.mesVoeux.add(leBien);
	}
	
	public void supprimerVoeux(Bien leBien) {
		mesVoeux.remove(leBien);		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
