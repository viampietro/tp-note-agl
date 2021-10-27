package fr.umfds.agl.terproject;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class GroupeSerializer extends StdSerializer<Groupe>{

	public GroupeSerializer() {
		this(null);
	}

	public GroupeSerializer(Class<Groupe> t) {
		super(t);
	}

	@Override
	public void serialize(
			Groupe g, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("idGroupe", g.getIdGroupe());
		jsonGenerator.writeStringField("nomGroupe", g.getNom());
		if (g.getSujetAffecté()!=null) {
		jsonGenerator.writeStringField("idSujet", g.getSujetAffecté().getIdSujet());
		}else {
			jsonGenerator.writeStringField("idSujet", "none");
		}
		jsonGenerator.writeEndObject();
	}
}
