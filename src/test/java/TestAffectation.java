
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.umfds.agl.terproject.Groupe;
import fr.umfds.agl.terproject.Sujet;

class TestAffectation {
	
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

}
