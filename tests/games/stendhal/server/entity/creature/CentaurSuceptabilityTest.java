
package games.stendhal.server.entity.creature;



import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


import games.stendhal.common.constants.Nature;
import games.stendhal.server.core.engine.SingletonRepository;

import games.stendhal.server.maps.MockStendlRPWorld;



public class CentaurSuceptabilityTest {
		
	/**
	 * initialisation
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		MockStendlRPWorld.get();
	}

	@Test
	public void testSolarCentaurSuceptability(){

			assertTrue(SingletonRepository.getEntityManager().getCreature("solar centaur").getSusceptibility(Nature.FIRE) <= 1);
			assertTrue(SingletonRepository.getEntityManager().getCreature("solar centaur").getSusceptibility(Nature.ICE) > 1);
			
			
	}
	public void testGlacierCentaurSuceptability(){

		assertTrue(SingletonRepository.getEntityManager().getCreature("glacier centaur").getSusceptibility(Nature.ICE)<= 1);
		assertTrue(SingletonRepository.getEntityManager().getCreature("glacier centaur").getSusceptibility(Nature.FIRE)> 1);
		
		
	}
}
