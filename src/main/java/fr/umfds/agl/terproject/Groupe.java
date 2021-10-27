package fr.umfds.agl.terproject;

import java.util.HashMap;

public class Groupe {
	
	private Sujet sujetAffecté;
	private String nom;
	private String idGroupe;
	private HashMap<String, Integer> choixSujets;
	
	public String getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(String idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Sujet getSujetAffecté() {
		return sujetAffecté;
	}

	public void setSujetAffecté(Sujet sujetAffecté) {
		this.sujetAffecté = sujetAffecté;
		sujetAffecté.setGroupeAffecté(this);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public HashMap<String, Integer> getChoixSujets() {
		return choixSujets;
	}
	
	public void setChoixSujets(HashMap<String, Integer> choixS) {
		this.choixSujets = choixS;
	}

	public Groupe(String nom) {
		this.sujetAffecté = null;
		this.nom = nom;
	}

	public Groupe() {
	
	}
	
	
}
