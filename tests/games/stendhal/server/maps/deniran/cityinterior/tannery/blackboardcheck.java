package games.stendhal.server.maps.deniran.cityinterior.tannery;

import org.junit.Assert;
import org.junit.Test;

import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.maps.deniran.cityinterior.potionsshop.PotionsDealerNPC;
import utilities.ZonePlayerAndNPCTestImpl;


public class blackboardcheck extends ZonePlayerAndNPCTestImpl{
	private static final String ZONE_NAME = "test zone";
	
	
	public blackboardcheck() {
		setNpcNames("Wanda");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new PotionsDealerNPC(), ZONE_NAME);
	}
	
	@Test
	public void testBlackboard() throws Exception {
		PotionsDealerNPC zoneconfig = new PotionsDealerNPC();
		StendhalRPZone testzone = new StendhalRPZone(ZONE_NAME);
		zoneconfig.configureZone(testzone,null);
		Entity signa = testzone.getEntityAt(10.0,6.0);
		Entity signb = testzone.getEntityAt(5.0,6.0);
		Assert.assertEquals("blackboards",signa);
		Assert.assertEquals("blackboards",signb);
	}
	
}