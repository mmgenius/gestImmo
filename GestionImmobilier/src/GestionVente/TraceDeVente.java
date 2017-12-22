package GestionVente;

import java.util.ArrayList;
import java.util.List;

public class TraceDeVente {
	
	private List<PromesseVente> archives ; 
	public TraceDeVente() {
		//setArchives(new ArrayList<>()); 	
	}
	
	public void ajouterPromesse(PromesseVente pro) {
		archives.add(pro);
	}
	
	public void supprimerPromesse(PromesseVente pro) {
		archives.remove(pro); 
	}
	
	public List<PromesseVente> getArchives() {
		return archives;
	}
	public void setArchives(List<PromesseVente> archives) {
		this.archives = archives;
	}
	
	

}
