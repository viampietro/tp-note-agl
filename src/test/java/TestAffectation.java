
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import fr.umfds.agl.terproject.GestionTER;
import fr.umfds.agl.terproject.Groupe;
import fr.umfds.agl.terproject.Hongrois;
import fr.umfds.agl.terproject.Sujet;

class TestAffectation {
	
	@Mock
	Hongrois h;
	
	@BeforeEach
	void init() {
		GestionTER.getInstance().setHongrois(h);
	}
	
	@Test
	void testAffectationSujetGroupe() {
		// given groupe g et sujet s
		Groupe g = new Groupe("G");
		Sujet s = new Sujet(null, "Sujet1");
		
		// when 
		g.setSujetAffecté(s);
		
		// then
		assertEquals(g.getSujetAffecté(), s);
		assertEquals(s.getGroupeAffecté(), g);
	}
	
	@Test
	void testAffectationHongrois() {
		
		// given
		
		// GestionTER.getInstance().setGroupes(maListeDeGroupes);
		// GestionTER.getInstance().setGroupes(maListeDeSujets);
		when(h.affectation(1)).thenReturn(List.of(List.of(1,1), List.of(2,3)));
		
		// when
		GestionTER.getInstance().affectation(1);
		
		// then
		// faire des asserts qui vont bien		
	}
	
}
