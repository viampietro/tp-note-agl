package fr.umfds.agl.terproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class GestionTER {
	private static GestionTER instance;
	private HashMap<String,Groupe> groupes = new HashMap();
	private ObjectMapper mapper = new ObjectMapper();
	private HashMap<String, Sujet> sujets = new HashMap<String, Sujet>();
	private Hongrois gestionnaireAffectation;
	
	
	private GestionTER() {
		if (instance==null) {
			
			initMapper();
			instance=this;
		}
		
	}
	
	public static GestionTER getInstance() {
		if (instance!=null) {
			return instance;
		} else {
			return new GestionTER();
		}
	}

	public Sujet getSujet(String idSujet) {
		return sujets.get(idSujet);
	}
	
	public void setHongrois(Hongrois h) {
		gestionnaireAffectation = h;
	}
	
	public void affectation(int passe) {
		
		gestionnaireAffectation.setHauteur(groupes.size());
		gestionnaireAffectation.setLargeur(sujets.size());
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		List<Integer> choices = new ArrayList<Integer>();
		
		for (Groupe g : groupes.values()) {
			for (Sujet s : sujets.values()) {
				if (g.getChoixSujets().containsKey(s.getIdSujet())) 
					choices.add(g.getChoixSujets().get(s.getIdSujet()));
				else choices.add(0);
			}
		}
		
		gestionnaireAffectation.setAdjacenceList(adjList);
		for (List<Integer> coupleGrSujet : gestionnaireAffectation.affectation(passe)) {
			Groupe g = groupes.get(coupleGrSujet.get(0).toString());
			Sujet s = sujets.get(coupleGrSujet.get(1).toString());
			
			g.setSujetAffecté(s);
		}
		
	}
	
	private void initMapper() {
		SimpleModule module = 
		    	  new SimpleModule("GroupeSerializer", new Version(1, 0, 0, null, null, null));
		    	module.addSerializer(Groupe.class, new GroupeSerializer());
		    	module.addDeserializer(Groupe.class, new GroupeDeserializer());
		    	mapper.registerModule(module);
	}
	
	void init() {
		Sujet s=new Sujet();
		s.setIdSujet("Sujet1");
		sujets.put(s.getIdSujet(), s);
		Groupe g=new Groupe("Groupe1-list");
		g.setIdGroupe("g1");
		g.setSujetAffecté(s);
		groupes.put(g.getIdGroupe(), g);
		Groupe g2=new Groupe("Groupe 2 tralala");
		g2.setIdGroupe("g2");
		groupes.put(g2.getIdGroupe(), g2);
	}
	public void serializeGroupes() throws JsonGenerationException, JsonMappingException, IOException {
		// avec serialiseur ad hoc
    	
    	mapper.writeValue(new File("src/main/resources/groupes.json"), groupes.values());
    	
	}
	public void importGroupes() throws JsonGenerationException, JsonMappingException, IOException {
		List<Groupe> gliste=mapper.readValue(new File("src/main/resources/groupes.json"), new TypeReference<List<Groupe>>(){});
    	for (Groupe g:gliste) {
    		groupes.put(g.getIdGroupe(), g);
    	}
	}

	@Override
	public String toString() {
		return "GestionTER [groupes=" + groupes + ", sujets=" + sujets + "]";
	}
	
}
