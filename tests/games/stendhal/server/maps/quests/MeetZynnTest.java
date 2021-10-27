package games.stendhal.server.maps.quests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.semos.library.HistorianGeographerNPC;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;

public class MeetZynnTest {
	// Initialize all variables needed
	private Player player = null;
	private SpeakerNPC npc = null;
	private Engine en = null;
	// The array of all questions that the player can ask Zynn
	private final String[] chats = {"history", "news", "geography", "places", "Faiumoni", "Semos", "Ados", "Or'ril", "Nalwor", "Deniran", "use", "levels", "naming", "positioning", "get", "SPS", "Io"};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
	}
	
	@Before
	public void setUp() {
		// Initialize NPC instance
		final StendhalRPZone zone = new StendhalRPZone("admin_test");
		new HistorianGeographerNPC().configureZone(zone, null);
		npc = SingletonRepository.getNPCList().get("Zynn Iwuhos");

		en = npc.getEngine();

		final AbstractQuest quest = new MeetZynn();
		quest.addToWorld();
		// Initialize the player's instance with the name "player"
		player = PlayerTestHelper.createPlayer("player");
	}
	
	@Test
	public void test() {
		// Simulating first interaction
		en.step(player, "hi");
		en.step(player,  "bye");
		
		// -----
		
		// Simulating next interaction
		// Ask all questions, compare previous XP with current one
		// Current XP has to be greater than the old XP
		en.step(player, "hi");
		int player_xp;
		int i;
		for(i=0; i<chats.length; i++) {
			player_xp = player.getXP();
			en.step(player, chats[i]);
			assertTrue("Check XP values", player_xp == player.getXP()-5);
		}
	}
}
