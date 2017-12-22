package GestionAgence;

import java.io.Serializable;
import java.util.GregorianCalendar;

import GestionBien.Bien;
import GestionPersonne.Client;


public class Mandat implements Serializable{
	public GregorianCalendar getDateSignature() {
		return dateSignature;
	}
	public int getDureeJours() {
		return dureeJours;
	}
	public boolean isSigne() {
		return signe;
	}
	public int getIdBien() {
		return idBien;
	}
	private GregorianCalendar dateSignature;
	private int dureeJours;
	private boolean signe;
	private int idBien;
	private Bien b;
	private Client c;
	public Mandat(GregorianCalendar dateSignature, int dureeJours, boolean signe, int idBien, Bien b, Client c) {
		super();
		this.dateSignature = dateSignature;
		this.dureeJours = dureeJours;
		this.signe = signe;
		this.idBien = idBien;
		this.b = b;
		this.c = c;
	}
	public Bien getBien() {
		return b;
	}
	public Client getClient() {
		return c;
	}
}
