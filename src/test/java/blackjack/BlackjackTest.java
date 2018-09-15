package blackjack;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase {

	public void testCardGets() {
		
		Card card = new Card("S", "7");
		assertEquals("S", card.getSuit());
		assertEquals("7", card.getRank());
		
		Card card2 = new Card("D", "3");
		assertEquals("D", card2.getSuit());
		assertEquals("3", card2.getRank());
		
		Card card3 = new Card("H", "Q");
		assertEquals("H", card3.getSuit());
		assertEquals("Q", card3.getRank());
		
		Card card4 = new Card("C", "A");
		assertEquals("C", card4.getSuit());
		assertEquals("A", card4.getRank());
		
	}
	
	
	public void testCardtoString() {
		
		Card card1 = new Card("S", "2");
		assertEquals("S2", card1.toString());
		
		Card card2 = new Card("D", "9");
		assertEquals("D9", card2.toString());
		
		Card card3 = new Card("H", "A");
		assertEquals("HA", card3.toString());
		
		Card card4 = new Card("C", "K");
		assertEquals("CK", card4.toString());
		
	}
	
	public void testFullDeck() {
		
		DeckOrHand deck = new DeckOrHand();
		deck.makeDeck();
		
		assertEquals("D2", deck.getCard(0));
		assertEquals("HA", deck.getCard(51));
		
		assertEquals("D5", deck.getCard(3));
		assertEquals("D10", deck.getCard(8));
		assertEquals("DK", deck.getCard(11));
		
		assertEquals("S2", deck.getCard(13));
		assertEquals("S8", deck.getCard(19));
		assertEquals("S6", deck.getCard(17));
		
		assertEquals("CK", deck.getCard(37));
		assertEquals("CQ", deck.getCard(36));
		assertEquals("CJ", deck.getCard(35));
		
		assertEquals("H7", deck.getCard(44));
		assertEquals("HJ", deck.getCard(48));
		assertEquals("HA", deck.getCard(51));
	
	}
	
	
}
