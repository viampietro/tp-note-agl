package fr.umfds.agl.terproject;

public class Sujet {
	private Groupe groupeAffecté;
	private String idSujet;
	
	private void setGroupeAffecté(Groupe g) {
		groupeAffecté=g;
		if (g!=null &&g.getSujetAffecté()!=this) {
			
		}
	}

	public String getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(String idSujet) {
		this.idSujet = idSujet;
	}

	public Groupe getGroupeAffecté() {
		return groupeAffecté;
	}

	public Sujet(Groupe groupeAffecté, String idSujet) {
		super();
		this.groupeAffecté = groupeAffecté;
		this.idSujet = idSujet;
	}
	
	public Sujet() {
		
	}
}
