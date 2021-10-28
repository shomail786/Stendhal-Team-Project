package games.stendhal.server.maps.deniran.cityinterior.tannery;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.mapstuff.sign.ShopSign;
import games.stendhal.server.maps.deniran.cityinterior.potionsshop.PotionsDealerNPC;
import utilities.ZonePlayerAndNPCTestImpl;


public class blackboardcheck extends ZonePlayerAndNPCTestImpl{
	private static final String ZONE_NAME = "int_denerian_potionsshop";
	
	
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
		ShopSign bb1 =zoneconfig.sign1;
		ShopSign bb2 =zoneconfig.sign2;
		Point signa = bb1.getOrigin();
		Point signb = bb2.getOrigin();
		Assert.assertNotNull(signa);
		Assert.assertNotNull(signb);

		
		
		
		
	}
	
}