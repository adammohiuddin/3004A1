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
		
		Deck deck = new deck();
		deck.makeFullDeck();
		
		assertEquals("D2", deck.get(0));
		assertEquals("HA", deck.get(51));
	
	}
	
	
}
