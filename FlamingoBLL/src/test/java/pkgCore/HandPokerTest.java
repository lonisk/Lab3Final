package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	 @Test
	 public void ROYALFLUSH() {
	 HandPoker pokerHand = new HandPoker();
	 pokerHand.AddCard(new Card(eSuit.HEARTS,eRank.TEN));
	 pokerHand.AddCard(new Card(eSuit.HEARTS,eRank.JACK));
	 pokerHand.AddCard(new Card(eSuit.HEARTS,eRank.QUEEN));
	 pokerHand.AddCard(new Card(eSuit.HEARTS,eRank.KING));
	 pokerHand.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
	
	 HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();
	 assertEquals("Royal Flush",HSP.geteHandStrength().toString());
	 }
	 
	 @Test
	 public void STRAIGHTFLUSH() {
	 HandPoker pokerHand = new HandPoker();
	 pokerHand.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
	 pokerHand.AddCard(new Card(eSuit.DIAMONDS,eRank.SEVEN));
	 pokerHand.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
	 pokerHand.AddCard(new Card(eSuit.DIAMONDS,eRank.FOUR));
	 pokerHand.AddCard(new Card(eSuit.DIAMONDS,eRank.SIX));
	
	 HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();
	 assertEquals("Straight Flush",HSP.geteHandStrength().toString());
	 }
	 
	@Test
	public void FOUROFAKIND1() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Four of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(0).geteRank());
	}

	@Test
	public void FOUROFAKIND2() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Four of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.JACK, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(0).geteRank());
	}

	@Test
	public void PAIR1() {

		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.TWO));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("One Pair", HSP.geteHandStrength().toString());

		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.FOUR).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(2).geteRank());

	}
	@Test
	public void PAIR2() {

		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.KING));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("One Pair", HSP.geteHandStrength().toString());

		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FOUR).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.TWO).geteRank(), HSP.getKickers().get(2).geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.KING).geteRank(), HSP.getKickers().get(0).geteRank());

	}

	@Test
	public void TWOPAIR1() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		if (HSP.geteHandStrength() == null) {
			System.out.println("NULL");
		}

		if (pokerHand.getCRC() != null) {
			System.out.println("NOT NULL");
		}
		assertEquals("Two Pairs", HSP.geteHandStrength().toString());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(eRank.TWO, HSP.getLoCard().geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());

	}
	@Test
	public void TWOPAIR2() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Two Pairs", HSP.geteHandStrength().toString());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(eRank.THREE, HSP.getLoCard().geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.TWO).geteRank(), HSP.getKickers().get(0).geteRank());

	}
	

	@Test
	public void THREEOFAKIND1() {

		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Three of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(1).geteRank());
	}

	
	
	@Test
	public void THREEOFAKIND2() {

		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.KING));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Three of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.KING, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.TWO).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
	}
	@Test
	public void FULLHOUSE1() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Full House", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(eRank.THREE, HSP.getLoCard().geteRank());
	}
	
	@Test
	public void FULLHOUSE2() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Full House", HSP.geteHandStrength().toString());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(eRank.TWO, HSP.getLoCard().geteRank());
	}
	
	@Test
	public void FLUSH() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Flush", HSP.geteHandStrength().toString());
		
	}
	@Test
	public void STRAIGHT() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		pokerHand.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		
		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("Straight", HSP.geteHandStrength().toString());
	}
	@Test
	public void HIGHCARD() {
		HandPoker pokerHand = new HandPoker();
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		pokerHand.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		pokerHand.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		pokerHand.AddCard(new Card(eSuit.HEARTS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) pokerHand.ScoreHand();

		assertEquals("High Card", HSP.geteHandStrength().toString());
		
	}
}
