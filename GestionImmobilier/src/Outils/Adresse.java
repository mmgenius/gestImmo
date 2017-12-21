package Outils;

import java.io.Serializable;

public class Adresse implements Serializable{
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	private String num;
	private String rue;
	private String codePostale;
	private String pays;
	public Adresse(String num, String rue, String codePostale, String pays) {
		this.num = num;
		this.rue = rue;
		this.codePostale = codePostale;
		this.pays = pays;
		
	}
	public Adresse(String[] ar) throws Exception {
		//Format: num rue codePostale pays
		this(ar[0], ar[1], ar[2], ar[3]);
	}
	
	public String toString() {
		return this.num+"|"+this.rue+ "|"+this.codePostale+ "|"+this.pays;
	}
	
}
