package fr.umfds.agl.terproject;

public class Groupe {
	private Sujet sujetAffecté;
	private String nom;
	private String idGroupe;

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
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Groupe(String nom) {
		this.sujetAffecté = null;
		this.nom = nom;
	}

	public Groupe() {
	
	}
	
	
}
