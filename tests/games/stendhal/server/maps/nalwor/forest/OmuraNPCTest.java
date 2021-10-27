package games.stendhal.server.maps.nalwor.forest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;

/**
 * Test for Omura Sumitada's quest dialogue 
 */
public class OmuraNPCTest extends ZonePlayerAndNPCTestImpl {

	private static final String ZONE_NAME = "0_nalwor_forest_n";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();

		setupZone(ZONE_NAME);
	}

	public OmuraNPCTest() {
		setNpcNames("Omura Sumitada");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new Dojo(), ZONE_NAME);
	}

	/**
	 * NPC communication check
	 */
	@Test
	public void testCommunication() {
		final SpeakerNPC npc = getNPC("Omura Sumitada");
		assertNotNull(npc);
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi"));
		String reply = getReply(npc);
		assertNotNull(reply);
		assertEquals("This is the assassins' dojo.", reply);

		assertTrue(en.step(player, "bye"));
		assertEquals("Bye.", getReply(npc));
	}

	/**
	 * Tests for train phrases when ATK too high 
	 */
	@Test
	public void testTrainPhrasesHighATKTrue() {
		final SpeakerNPC npc = getNPC("Omura Sumitada");
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi"));
		assertEquals("This is the assassins' dojo.", getReply(npc));

		assertTrue(en.step(player, "train"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));

		assertTrue(en.step(player, "training"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));

		assertTrue(en.step(player, "enter"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));

		assertTrue(en.step(player, "start"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));
	}
	
	/**
	 * Tests for fee phrases when ATK too high 
	 */
	@Test
	public void testFeePhrasesHighATKTrue() {
		final SpeakerNPC npc = getNPC("Omura Sumitada");
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi"));
		assertEquals("This is the assassins' dojo.", getReply(npc));
		
		assertTrue(en.step(player, "fee"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));

		assertTrue(en.step(player, "cost"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));

		assertTrue(en.step(player, "charge"));
		assertEquals("At your level of experience, your attack strength is too high to train here at this time.", getReply(npc));
	}
	
	/**
	 * Tests for fee phrases when ATK not too high for level cap
	 */
	@Test
	public void testTrainPhrasesHighATKFalse() {
		final SpeakerNPC npc = getNPC("Omura Sumitada");
		final Engine en = npc.getEngine();
		
		player.setLevel(20);

		assertTrue(en.step(player, "hi"));
		assertEquals("This is the assassins' dojo.", getReply(npc));
		
		assertTrue(en.step(player, "fee"));
		assertEquals("The fee to #train for your skill level is 625 money.", getReply(npc));

		assertTrue(en.step(player, "cost"));
		assertEquals("The fee to #train for your skill level is 625 money.", getReply(npc));

		assertTrue(en.step(player, "charge"));
		assertEquals("The fee to #train for your skill level is 625 money.", getReply(npc));
	}

}

