package blackjack;


import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase {

	public void testCardGets() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testCardGets() (test 1)");
		System.out.println("-------------------------------");
		
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
		
		System.out.println("-------------------------------");
		System.out.println("Running testCardtoString() (test 2)");
		System.out.println("-------------------------------");
		
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
		
		System.out.println("-------------------------------");
		System.out.println("Running testFullDeck() (test 3)");
		System.out.println("-------------------------------");
		
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
	
	public void testShuffledDeck() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testShuffledDeck() (test 4)");
		System.out.println("-------------------------------");
		
		DeckOrHand deck = new DeckOrHand();
		deck.makeDeck();
		deck.shuffleDeck();
		
		assertThat("D8", not(equalTo(String.valueOf(deck.getCard(6)))));
		assertThat("D9", not(equalTo(String.valueOf(deck.getCard(7)))));
		
		assertThat("C8", not(equalTo(String.valueOf(deck.getCard(32)))));
		assertThat("C9", not(equalTo(String.valueOf(deck.getCard(33)))));
		
	}

	
	public void testDeckAddAndRemove() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testDeckAddAndRemove() (test 5)");
		System.out.println("-------------------------------");
		
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
		
		System.out.println("-------------------------------");
		System.out.println("Running testDeckSize() (test 6)");
		System.out.println("-------------------------------");
		
		DeckOrHand deck1 = new DeckOrHand();
		DeckOrHand deck2 = new DeckOrHand();
		Card card1 = new Card("S", "9");
		Card card2 = new Card("H", "2");
		Card card3 = new Card("D", "K");
		Card card4 = new Card("C", "6");
		Card card5 = new Card("S", "2");
		Card card6 = new Card("D", "J");
		Card card7 = new Card("H", "7");
		Card card8 = new Card("D", "A");
		Card card9 = new Card("C", "A");
		
		deck1.addCard(card1);
		deck1.addCard(card2);
		deck1.addCard(card3);
		deck1.addCard(card4);
		deck1.addCard(card5);
		deck1.addCard(card6);
		deck1.addCard(card7);
		deck1.addCard(card8);
		deck1.addCard(card9);
		
		assertEquals(9, deck1.size());
			
		deck1.removeCard(6);
		deck1.removeCard(5);
		deck1.removeCard(3);
		deck1.removeCard(1);
		
		assertEquals(5, deck1.size());
		
		deck2.makeDeck();
		assertEquals(52, deck2.size());
		
	}
	
	public void testDeckDraw() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testDeckDraw() (test 7)");
		System.out.println("-------------------------------");
		
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
		
		System.out.println("-------------------------------");
		System.out.println("Running testShowingHand() (test 8)");
		System.out.println("-------------------------------");
		
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
	
		System.out.println("-------------------------------");
		System.out.println("Running testValueOfHand() (test 9)");
		System.out.println("-------------------------------");
		
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
		
		System.out.println("-------------------------------");
		System.out.println("Running testIsAce11() (test 10)");
		System.out.println("-------------------------------");
		
		DeckOrHand hand1 = new DeckOrHand();
		hand1.addCard(new Card("H", "Q"));
		hand1.addCard(new Card("C", "A"));
		assertEquals(21, hand1.getHandValue());
		assertEquals(true, hand1.isAce11());
		hand1.addCard(new Card("D", "2"));
		assertEquals(13, hand1.getHandValue());
		assertEquals(false, hand1.isAce11());
	
	}
	
	public void testMakeDeckFromFile() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testMakeDeckFromFile() (test 11)");
		System.out.println("-------------------------------");
		
		ArrayList<String> fileInput = new ArrayList<String>();
		fileInput.add("HQ");
		fileInput.add("C4");
		fileInput.add("D10");
		DeckOrHand deck = new DeckOrHand();
		deck.makeDeckFromFile(fileInput);
		
		assertEquals("HQ", deck.getCard(0).toString());
		assertEquals("C4", deck.getCard(1).toString());
		assertEquals("D10", deck.getCard(2).toString());

	}
	
	public void testDidBlackjackHappen() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testDidBlackjackHappen() (test 12)");
		System.out.println("-------------------------------");
		
		DeckOrHand pHand1 = new DeckOrHand();
		DeckOrHand dHand1 = new DeckOrHand();
		DeckOrHand pHand2 = new DeckOrHand();
		DeckOrHand dHand2 = new DeckOrHand();
		DeckOrHand pHand3 = new DeckOrHand();
		DeckOrHand dHand3 = new DeckOrHand();
		
		// both have blackjack
		pHand1.addCard(new Card("C", "A"));
		pHand1.addCard(new Card("C", "J"));
		dHand1.addCard(new Card("H", "A"));
		dHand1.addCard(new Card("H", "K"));
		assertEquals(dHand1, Blackjack.didBlackjackHappen(pHand1, dHand1));
		
		// dealer has blackjack		
		pHand2.addCard(new Card("C", "3"));
		pHand2.addCard(new Card("C", "4"));
		pHand2.addCard(new Card("D", "4"));
		pHand2.addCard(new Card("D", "K"));
		dHand2.addCard(new Card("H", "A"));
		dHand2.addCard(new Card("H", "K"));
		assertEquals(dHand2, Blackjack.didBlackjackHappen(pHand2, dHand2));

		
		// player has blackjack		
		pHand3.addCard(new Card("C", "A"));
		pHand3.addCard(new Card("C", "J"));
		dHand3.addCard(new Card("H", "10"));
		dHand3.addCard(new Card("H", "J"));
		assertEquals(pHand3, Blackjack.didBlackjackHappen(pHand3, dHand3));
		
	}
	
	public void testCreateDeckAndPickUI() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testCreateDeckAndPickUI() (test 13)");
		System.out.println("Actions:");
		System.out.println("Choose file Test1.txt");
		System.out.println("Choose file Test2.txt");
		System.out.println("Choose console");
		System.out.println("-------------------------------");
		
		DeckOrHand deck1 = new DeckOrHand();
		DeckOrHand deck2 = new DeckOrHand();
		DeckOrHand deck3 = new DeckOrHand();
		ArrayList<String> moves1 = new ArrayList<>();
		ArrayList<String> moves2 = new ArrayList<>();
		ArrayList<String> moves3 = new ArrayList<>();
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		
		// using file input
		// using file Test1.txt
		Blackjack.createDeckAndPickUI(deck1, moves1, scanner1);
		assertEquals(9, deck1.size());
		assertEquals(4, moves1.size());
		
		// using file input
		// using file Test2.txt
		Blackjack.createDeckAndPickUI(deck2, moves2, scanner2);
		assertEquals(7, deck2.size());
		assertEquals(2, moves2.size());
		
		
		// using console input
		Blackjack.createDeckAndPickUI(deck3, moves3, scanner3);
		assertEquals(52, deck3.size());
		assertEquals(0, moves3.size());
		
	}
	
	public void testPlayerTurn() {
		
		System.out.println("-------------------------------");
		System.out.println("Running testPlayerTurn() (test 14)");
		System.out.println("Actions:");
		System.out.println("Hit");
		System.out.println("Stand");
		System.out.println("Hit");
		System.out.println("Hit");
		System.out.println("-------------------------------");
		
		DeckOrHand pHand1 = new DeckOrHand();
		DeckOrHand pHand2 = new DeckOrHand();
		DeckOrHand pHand3 = new DeckOrHand();
		DeckOrHand pHand4 = new DeckOrHand();
		DeckOrHand dHand1 = new DeckOrHand();
		DeckOrHand dHand2 = new DeckOrHand();
		DeckOrHand dHand3 = new DeckOrHand();
		DeckOrHand dHand4 = new DeckOrHand();
		DeckOrHand deck1 = new DeckOrHand();
		DeckOrHand deck2 = new DeckOrHand();
		DeckOrHand deck3 = new DeckOrHand();
		DeckOrHand deck4 = new DeckOrHand();
		ArrayList<String> moves1 = new ArrayList<>();
		ArrayList<String> moves2 = new ArrayList<>();
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		
		// using file input
		// hit then stand
		pHand1.addCard(new Card("H", "5"));
		pHand1.addCard(new Card("C", "3"));
		dHand1.addCard(new Card("D", "A"));
		dHand1.addCard(new Card("S", "9"));
		moves1.add("H");
		moves1.add("S");
		deck1.addCard(new Card("D", "3"));
		deck1.addCard(new Card("H", "8"));
		deck1.addCard(new Card("H", "10"));
		Blackjack.playerTurn(pHand1, dHand1, moves1, deck1, scanner1, true);
		assertEquals(3, pHand1.size());
		
		// using file input
		// hit then bust
		pHand2.addCard(new Card("H", "5"));
		pHand2.addCard(new Card("C", "3"));
		dHand2.addCard(new Card("S", "9"));
		dHand2.addCard(new Card("D", "A"));
		moves2.add("H");
		moves2.add("H");
		moves2.add("H");
		moves2.add("H");
		deck2.addCard(new Card("D", "3"));
		deck2.addCard(new Card("H", "8"));
		deck2.addCard(new Card("H", "10"));
		deck2.addCard(new Card("S", "6"));
		Blackjack.playerTurn(pHand2, dHand2, moves2, deck2, scanner2, true);
		assertEquals(5, pHand2.size());
		
		// using console input
		// hit then stand
		pHand3.addCard(new Card("H", "5"));
		pHand3.addCard(new Card("C", "3"));
		dHand3.addCard(new Card("D", "A"));
		dHand3.addCard(new Card("S", "9"));
		deck3.addCard(new Card("D", "3"));
		deck3.addCard(new Card("H", "8"));
		deck3.addCard(new Card("H", "10"));
		Blackjack.playerTurn(pHand3, dHand3, moves1, deck3, scanner3, false);
		assertEquals(3, pHand1.size());
		
		// using console input
		// hit then bust
		pHand4.addCard(new Card("H", "5"));
		pHand4.addCard(new Card("C", "3"));
		dHand4.addCard(new Card("S", "9"));
		dHand4.addCard(new Card("D", "A"));
		deck4.addCard(new Card("D", "3"));
		deck4.addCard(new Card("H", "8"));
		deck4.addCard(new Card("H", "10"));
		deck4.addCard(new Card("S", "6"));
		Blackjack.playerTurn(pHand3, dHand3, moves2, deck3, scanner4, false);
		assertEquals(5, pHand2.size());
		
	}
	
	public void testDealerTurn() {
	
		System.out.println("-------------------------------");
		System.out.println("Running testDealerTurn() (test 15)");
		System.out.println("-------------------------------");
		
		DeckOrHand pHand1 = new DeckOrHand();
		DeckOrHand pHand2 = new DeckOrHand();
		DeckOrHand pHand3 = new DeckOrHand();
		DeckOrHand pHand4 = new DeckOrHand();
		DeckOrHand pHand5 = new DeckOrHand();
		DeckOrHand pHand6 = new DeckOrHand();
		DeckOrHand dHand1 = new DeckOrHand();
		DeckOrHand dHand2 = new DeckOrHand();
		DeckOrHand dHand3 = new DeckOrHand();
		DeckOrHand dHand4 = new DeckOrHand();
		DeckOrHand dHand5 = new DeckOrHand();
		DeckOrHand dHand6 = new DeckOrHand();
		DeckOrHand deck1 = new DeckOrHand();
		DeckOrHand deck2 = new DeckOrHand();
		DeckOrHand deck3 = new DeckOrHand();
		DeckOrHand deck4 = new DeckOrHand();
		DeckOrHand deck5 = new DeckOrHand();
		DeckOrHand deck6 = new DeckOrHand();
		
		
		// dealer has a better hand than player
		pHand1.addCard(new Card("H", "5"));
		pHand1.addCard(new Card("C", "3"));
		dHand1.addCard(new Card("D", "A"));
		dHand1.addCard(new Card("S", "9"));
		Blackjack.dealerTurn(pHand1, dHand1, deck1, false);
		assertEquals(2, dHand1.size());
		
		// dealer has a better hand after taking cards
		pHand2.addCard(new Card("H", "5"));
		pHand2.addCard(new Card("C", "10"));
		dHand2.addCard(new Card("D", "2"));
		dHand2.addCard(new Card("S", "3"));
		deck2.addCard(new Card("D", "3"));
		deck2.addCard(new Card("H", "8"));
		deck2.addCard(new Card("S", "4"));
		Blackjack.dealerTurn(pHand2, dHand2, deck2, false);
		assertEquals(5, dHand2.size());
		
		// player has a better hand after dealer takes cards
		pHand3.addCard(new Card("H", "5"));
		pHand3.addCard(new Card("C", "10"));
		pHand3.addCard(new Card("S", "6"));
		dHand3.addCard(new Card("D", "2"));
		dHand3.addCard(new Card("S", "3"));
		deck3.addCard(new Card("D", "3"));
		deck3.addCard(new Card("H", "8"));
		deck3.addCard(new Card("S", "4"));
		Blackjack.dealerTurn(pHand3, dHand3, deck3, false);
		assertEquals(5, dHand3.size());
		
		// tie
		pHand4.addCard(new Card("H", "10"));
		pHand4.addCard(new Card("C", "10"));
		dHand4.addCard(new Card("D", "2"));
		dHand4.addCard(new Card("S", "3"));
		deck4.addCard(new Card("D", "3"));
		deck4.addCard(new Card("H", "8"));
		deck4.addCard(new Card("S", "4"));
		Blackjack.dealerTurn(pHand4, dHand4, deck4, false);
		assertEquals(5, dHand4.size());
				
		// dealer busts
		pHand5.addCard(new Card("H", "10"));
		pHand5.addCard(new Card("C", "10"));
		dHand5.addCard(new Card("D", "2"));
		dHand5.addCard(new Card("S", "3"));
		deck5.addCard(new Card("D", "3"));
		deck5.addCard(new Card("H", "8"));
		deck5.addCard(new Card("S", "10"));
		Blackjack.dealerTurn(pHand5, dHand5, deck5, false);
		assertEquals(5, dHand5.size());
				
		// dealer get's a soft 17
		pHand6.addCard(new Card("H", "5"));
		pHand6.addCard(new Card("C", "10"));
		dHand6.addCard(new Card("D", "A"));
		dHand6.addCard(new Card("S", "3"));
		deck6.addCard(new Card("D", "3"));
		deck6.addCard(new Card("S", "2"));
		Blackjack.dealerTurn(pHand6, dHand6, deck6, false);
		assertEquals(4, dHand6.size());
		
	}
	
}
