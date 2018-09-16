package blackjack;

//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;

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
	
//	public void testShuffledDeck() {
//		
//		DeckOrHand deck = new DeckOrHand();
//		deck.makeDeck();
//		deck.shuffleDeck();
//		
//		assertThat("D8", not(equalTo(String.valueOf(deck.getCard(6)))));
//		assertThat("D9", not(equalTo(String.valueOf(deck.getCard(7)))));
//		
//		assertThat("S8", not(equalTo(String.valueOf(deck.getCard(19)))));
//		assertThat("S9", not(equalTo(String.valueOf(deck.getCard(20)))));
//		
//		assertThat("C8", not(equalTo(String.valueOf(deck.getCard(32)))));
//		assertThat("C9", not(equalTo(String.valueOf(deck.getCard(33)))));
//		
//		assertThat("H8", not(equalTo(String.valueOf(deck.getCard(45)))));
//		assertThat("H9", not(equalTo(String.valueOf(deck.getCard(46)))));
//		
//	}
	
	public void testDeckAddAndRemove() {
		
		DeckOrHand deck = new DeckOrHand();
		Card card1 = new Card("S", "9");
		Card card2 = new Card("H", "2");
		Card card3 = new Card("D", "K");
		Card card4 = new Card("C", "6");
		Card card5 = new Card("S", "2");
		Card card6 = new Card("D", "J");
		
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		deck.addCard(card4);
		deck.addCard(card5);
		deck.addCard(card6);
		
		deck.removeCard(5);
		deck.removeCard(4);
		deck.removeCard(2);
		deck.removeCard(0);
		
		assertEquals("H2", deck.getCard(0));
		assertEquals("C6", deck.getCard(1));
		
	}
	
	public void testDeckSize() {
		
		DeckOrHand deck = new DeckOrHand();
		Card card1 = new Card("S", "9");
		Card card2 = new Card("H", "2");
		Card card3 = new Card("D", "K");
		Card card4 = new Card("C", "6");
		Card card5 = new Card("S", "2");
		Card card6 = new Card("D", "J");
		Card card7 = new Card("H", "7");
		Card card8 = new Card("D", "A");
		Card card9 = new Card("C", "A");
		
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		deck.addCard(card4);
		deck.addCard(card5);
		deck.addCard(card6);
		deck.addCard(card7);
		deck.addCard(card8);
		deck.addCard(card9);
		
		assertEquals(9, deck.size());
			
		deck.removeCard(6);
		deck.removeCard(5);
		deck.removeCard(3);
		deck.removeCard(1);
		
		assertEquals(5, deck.size());
		
	}
	
	public void testDeckDraw() {
		
		DeckOrHand deck = new DeckOrHand();
		Card card1 = new Card("S", "9");
		Card card2 = new Card("H", "2");
		Card card3 = new Card("D", "K");
		Card card4 = new Card("C", "6");
		
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		deck.addCard(card4);
		
		DeckOrHand hand = new DeckOrHand();
		hand.drawCard(deck);
		assertEquals("C6", hand.getCard(0));
		hand.drawCard(deck);
		assertEquals("DK", deck.getCard(1));
		hand.drawCard(deck);
		assertEquals("H2", deck.getCard(1));
		hand.drawCard(deck);
		assertEquals("S9", deck.getCard(1));
		
	}
	
}
