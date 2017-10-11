package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	 @Test
	 public void ROYALFLUSH() {
	 HandPoker hp = new HandPoker();
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
	
	 HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();
	 assertEquals("Royal Flush",HSP.geteHandStrength().toString());
	 }
	 
	 @Test
	 public void STRAIGHTFLUSH() {
	 HandPoker hp = new HandPoker();
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.SEVEN));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
	 hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
	
	 HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();
	 assertEquals("Straight Flush",HSP.geteHandStrength().toString());
	 }
	 
	@Test
	public void FOUROFAKIND1() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Four of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(0).geteRank());
	}

	@Test
	public void FOUROFAKIND2() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Four of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.JACK, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(0).geteRank());
	}

	@Test
	public void PAIR1() {

		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("One Pair", HSP.geteHandStrength().toString());

		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.FOUR).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(2).geteRank());

	}
	@Test
	public void PAIR2() {

		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("One Pair", HSP.geteHandStrength().toString());

		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FOUR).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.TWO).geteRank(), HSP.getKickers().get(2).geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.KING).geteRank(), HSP.getKickers().get(0).geteRank());

	}

	@Test
	public void TWOPAIR1() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		if (HSP.geteHandStrength() == null) {
			System.out.println("NULL");
		}

		if (hp.getCRC() != null) {
			System.out.println("NOT NULL");
		}
		assertEquals("Two Pairs", HSP.geteHandStrength().toString());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(eRank.TWO, HSP.getLoCard().geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());

	}
	@Test
	public void TWOPAIR2() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Two Pairs", HSP.geteHandStrength().toString());
		assertEquals(eRank.FIVE, HSP.getHiCard().geteRank());
		assertEquals(eRank.THREE, HSP.getLoCard().geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.TWO).geteRank(), HSP.getKickers().get(0).geteRank());

	}
	

	@Test
	public void THREEOFAKIND1() {

		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Three of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
		assertEquals(new Card(eSuit.CLUBS, eRank.THREE).geteRank(), HSP.getKickers().get(1).geteRank());
	}

	
	
	@Test
	public void THREEOFAKIND2() {

		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Three of a Kind", HSP.geteHandStrength().toString());
		assertEquals(eRank.KING, HSP.getHiCard().geteRank());

		assertEquals(new Card(eSuit.CLUBS, eRank.TWO).geteRank(), HSP.getKickers().get(1).geteRank());
		assertEquals(new Card(eSuit.SPADES, eRank.FIVE).geteRank(), HSP.getKickers().get(0).geteRank());
	}
	@Test
	public void FULLHOUSE1() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Full House", HSP.geteHandStrength().toString());
		assertEquals(eRank.TWO, HSP.getHiCard().geteRank());
		assertEquals(eRank.THREE, HSP.getLoCard().geteRank());
	}
	
	@Test
	public void FULLHOUSE2() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Full House", HSP.geteHandStrength().toString());
		assertEquals(eRank.THREE, HSP.getHiCard().geteRank());
		assertEquals(eRank.TWO, HSP.getLoCard().geteRank());
	}
	
	@Test
	public void FLUSH() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Flush", HSP.geteHandStrength().toString());
		
	}
	@Test
	public void STRAIGHT() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		
		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("Straight", HSP.geteHandStrength().toString());
	}
	@Test
	public void HIGHCARD() {
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));

		HandScorePoker HSP = (HandScorePoker) hp.ScoreHand();

		assertEquals("High Card", HSP.geteHandStrength().toString());
		
	}
}
