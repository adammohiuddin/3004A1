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
		
		assertEquals("D2", deck.getCard(0).toString());
		assertEquals("HA", deck.getCard(51).toString());
		
		assertEquals("D5", deck.getCard(3).toString());
		assertEquals("D10", deck.getCard(8).toString());
		assertEquals("DK", deck.getCard(11).toString());
		
		assertEquals("S2", deck.getCard(13).toString());
		assertEquals("S8", deck.getCard(19).toString());
		assertEquals("S6", deck.getCard(17).toString());
		
		assertEquals("CK", deck.getCard(37).toString());
		assertEquals("CQ", deck.getCard(36).toString());
		assertEquals("CJ", deck.getCard(35).toString());
		
		assertEquals("H7", deck.getCard(44).toString());
		assertEquals("HJ", deck.getCard(48).toString());
		assertEquals("HA", deck.getCard(51).toString());
	
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
		
		assertEquals("H2", deck.getCard(0).toString());
		assertEquals("C6", deck.getCard(1).toString());
		
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
		assertEquals("S9", hand.getCard(0).toString());
		hand.drawCard(deck);
		assertEquals("H2", hand.getCard(1).toString());
		hand.drawCard(deck);
		assertEquals("DK", hand.getCard(2).toString());
		hand.drawCard(deck);
		assertEquals("C6", hand.getCard(3).toString());
		
	}
	
	public void testShowingHand() {
		DeckOrHand hand = new DeckOrHand();
		Card card1 = new Card("H", "7");
		Card card2 = new Card("C", "Q");
		Card card3 = new Card("S", "2");
		Card card4 = new Card("D", "10");
		
		hand.addCard(card1);
		hand.addCard(card2);
		hand.addCard(card3);
		hand.addCard(card4);
		
		assertEquals("H7 CQ S2 D10 ", hand.showHand());
		
		hand.removeCard(1);
		hand.removeCard(1);
		
		assertEquals("H7 D10 ", hand.showHand());
		
	}
	
	public void testValueOfHand() {
		DeckOrHand hand1 = new DeckOrHand();
		DeckOrHand hand2 = new DeckOrHand();
		DeckOrHand hand3 = new DeckOrHand();
		DeckOrHand hand4 = new DeckOrHand();
		DeckOrHand hand5 = new DeckOrHand();
		
		// no aces
		hand1.addCard(new Card("H", "2"));
		assertEquals(2, hand1.getHandValue());
		hand1.addCard(new Card("S", "3"));
		assertEquals(5, hand1.getHandValue());
		hand1.addCard(new Card("C", "4"));
		assertEquals(9, hand1.getHandValue());
		hand1.addCard(new Card("D", "5"));
		assertEquals(14, hand1.getHandValue());
		hand1.addCard(new Card("H", "6"));
		assertEquals(20, hand1.getHandValue());
		hand1.addCard(new Card("S", "7"));
		assertEquals(27, hand1.getHandValue());
		hand1.addCard(new Card("C", "8"));
		assertEquals(35, hand1.getHandValue());
		hand1.addCard(new Card("D", "9"));
		assertEquals(44, hand1.getHandValue());
		hand1.addCard(new Card("H", "10"));
		assertEquals(54, hand1.getHandValue());
		hand1.addCard(new Card("S", "J"));
		assertEquals(64, hand1.getHandValue());
		hand1.addCard(new Card("C", "Q"));
		assertEquals(74, hand1.getHandValue());
		hand1.addCard(new Card("D", "K"));
		assertEquals(84, hand1.getHandValue());
		
		// one ace
		// here the ace will count as 11
		hand2.addCard(new Card("H", "Q"));
		hand2.addCard(new Card("C", "A"));
		assertEquals(21, hand2.getHandValue());
		// here the ace will count as 1
		hand2.addCard(new Card("D", "2"));
		assertEquals(13, hand2.getHandValue());
		
		// two aces
		// here one ace will count as 11 and one will count as 1
		hand3.addCard(new Card("C", "A"));
		hand3.addCard(new Card("D", "A"));
		assertEquals(12, hand3.getHandValue());
		// here both aces will count as 1
		hand3.addCard(new Card("S", "5"));
		hand3.addCard(new Card("S", "10"));
		assertEquals(17, hand3.getHandValue());
		
		// three aces
		// here one ace will count as 11 and the other two will count as 1
		hand4.addCard(new Card("C", "A"));
		hand4.addCard(new Card("D", "A"));
		hand4.addCard(new Card("S", "A"));
		assertEquals(13, hand4.getHandValue());
		// here all three aces will count as 1
		hand4.addCard(new Card("D", "7"));
		hand4.addCard(new Card("D", "4"));
		assertEquals(14, hand4.getHandValue());
		
		// four aces
		// here one ace will count as 11 and the other three will count as 1
		hand5.addCard(new Card("C", "A"));
		hand5.addCard(new Card("D", "A"));
		hand5.addCard(new Card("S", "A"));
		hand5.addCard(new Card("H", "A"));
		assertEquals(14, hand5.getHandValue());
		// here both aces will count as 1
		hand5.addCard(new Card("H", "K"));
		hand5.addCard(new Card("H", "2"));
		assertEquals(16, hand5.getHandValue());
		
	}
	
	public void testIsAce11() {
		DeckOrHand hand1 = new DeckOrHand();
		hand1.addCard(new Card("H", "Q"));
		hand1.addCard(new Card("C", "A"));
		assertEquals(21, hand1.getHandValue());
		assertEquals(true, hand1.isAce11());
		hand1.addCard(new Card("D", "2"));
		assertEquals(13, hand1.getHandValue());
		assertEquals(false, hand1.isAce11());
	
	}
	
}
