package games.stendhal.server.entity.item.scroll;

import static org.junit.Assert.*;

import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.item.ConsumableItem;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.entity.status.PoisonAttacker;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;

public class MarkedScrollTest {

	@Test
	public void MarkedScrollTest() {
		//make a player
		Player player = PlayerTestHelper.createPlayer("tom");
		//make the player be poisoned
		String poisontype = "greater poison";
		ConsumableItem poison = (ConsumableItem) SingletonRepository.getEntityManager().getItem(poisontype);
		PoisonAttacker poisoner = new PoisonAttacker(100,poison);
		poisoner.onAttackAttempt(player,SingletonRepository.getEntityManager().getCreature("snake"));
		//make the world, the zone, and the scroll
		StendhalRPWorld world = MockStendlRPWorld.get();
		StendhalRPZone zone = new StendhalRPZone("0_semos_city", 100,100);
		MarkedScroll scroll = new MarkedScroll("marked scroll", "", "", null);
		world.addRPZone(zone);
		PlayerTestHelper.registerPlayer(player,zone);
		assertFalse(scroll.useScroll(player));
	}

}

