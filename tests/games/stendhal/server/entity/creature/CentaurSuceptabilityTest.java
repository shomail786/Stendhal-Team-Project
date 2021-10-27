
package games.stendhal.server.entity.creature;

import games.stendhal.common.constants.Nature;
import games.stendhal.server.core.engine.SingletonRepository;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CentaurSuceptabilityTest {	
	@Test
	public void testSolarCentaurFireSuceptability() {
			double fireSept = SingletonRepository.getEntityManager().getCreature("solar centaur").getSusceptibility(Nature.FIRE);
			assertEquals(fireSept, 0.8, 0.0);
					
	}
	@Test 
	public void testSolarCentaurIceSuceptability() {
		double iceSept = SingletonRepository.getEntityManager().getCreature("solar centaur").getSusceptibility(Nature.ICE);
		assertEquals(iceSept, 1.2, 0.0);
				
}
	
	@Test
	public void testGlacierCentaurFireSuceptability() {
		double fireSept = SingletonRepository.getEntityManager().getCreature("glacier centaur").getSusceptibility(Nature.FIRE);
		assertEquals(fireSept, 1.2, 0.0);
	}
	
	@Test
	public void testGlacierCentaurIceSuceptability() {
		double iceSept = SingletonRepository.getEntityManager().getCreature("glacier centaur").getSusceptibility(Nature.ICE);
		assertEquals(iceSept, 0.8, 0.0);
	}
}
