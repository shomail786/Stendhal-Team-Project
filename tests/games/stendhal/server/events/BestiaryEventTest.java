package games.stendhal.server.events;

import static org.junit.Assert.*;

import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.rule.EntityManager;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.server.game.db.DatabaseFactory;
import utilities.PlayerTestHelper;

public class BestiaryEventTest extends PlayerTestHelper {
	
	private static EntityManager entitymanager;
	
	@Test
	public void testExecute() {
		
		new DatabaseFactory().initializeDatabase();
		MockStendlRPWorld.get();
		entitymanager = SingletonRepository.getEntityManager();
		entitymanager.populateCreatureList();
		
		// set up a test player and create a new bestiary event for that player
		Player testPlayer = createPlayer("TestPlayer");
		BestiaryEvent event = new BestiaryEvent(testPlayer);
		
		// get the list of enemies for the test player
		String listOfEnemies = event.get("enemies");
		
		// list of enemies shouldn't contain any ??? entries
		assertFalse(listOfEnemies.contains("???"));
		
	}

}