package fr.umfds.agl.terproject;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class GroupeDeserializer  extends StdDeserializer<Groupe> {
	    
	    public GroupeDeserializer() {
	        this(null);
	    }

	    public GroupeDeserializer(Class<?> vc) {
	        super(vc);
	    }

	    @Override
	    public Groupe deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
	        Groupe g = new Groupe();
	        ObjectCodec codec = parser.getCodec();
	        JsonNode node = codec.readTree(parser);
	        
	        
	        
	        JsonNode idGroupeNode = node.get("idGroupe");
	        String idGroupe = idGroupeNode.asText();
	        g.setIdGroupe(idGroupe);
	        
	        
	        JsonNode idSujetNode = node.get("idSujet");
	        String idSujet = idSujetNode.asText();
	        if (!idSujet.equals("none")) {
	        	g.setSujetAffecté(GestionTER.getInstance().getSujet(idSujet));
	        }
	        
	        JsonNode nomGroupeNode = node.get("nomGroupe");
	        String nomGroupe = nomGroupeNode.asText();
	        g.setNom(nomGroupe);
	        
	        return g;
	    }
	}