package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeckOrHand {
	private ArrayList<Card> cards;
	final List<String> suit = Arrays.asList("D", "S", "C", "H");
	final List<String> rank = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
	
	public DeckOrHand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void makeDeck() {
		for (String s : suit) {
			for (String r : rank) {
				this.cards.add(new Card(s, r));
			}	
		}
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void shuffleDeck() {
		Random rand = new Random();
		int randIndex = 0;
		int size = this.cards.size();
		ArrayList<Card> tempArray = new ArrayList<Card>();
		for (int i = 0; i < size; i++) {
			// using rand.nextInt((max - min) + 1) + min to have inclusivity
			randIndex = rand.nextInt(this.cards.size());
			tempArray.add(this.cards.get(randIndex));
			this.cards.remove(randIndex);
		}
		this.cards = tempArray;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	public int size() {
		return this.cards.size(); 
	}
	
	public void drawCard(DeckOrHand deck) {
		this.cards.add(deck.getCard(0));
		deck.removeCard(0);
	}
	
	public String showHand() {
		String fullHand = "";
		for (Card card : this.cards) {
			fullHand += card.toString() + " ";
		}
		return fullHand;
	}
	
	public int getHandValue() {
		int value = 0;
		int aces = 0;
		
		for (Card card : this.cards) {	
			if (card.getRank() == "2") {
				value += 2;
			}
			else if (card.getRank() == "3") {
				value += 3;
			}
			else if (card.getRank() == "4") {
				value += 4;
			}
			else if (card.getRank() == "5") {
				value += 5;
			}
			else if (card.getRank() == "6") {
				value += 6;
			}
			else if (card.getRank() == "7") {
				value += 7;
			}
			else if (card.getRank() == "8") {
				value += 8;
			}
			else if (card.getRank() == "9") {
				value += 9;
			}
			else if (card.getRank() == "10") {
				value += 10;
			}
			else if (card.getRank() == "J") {
				value += 10;
			}
			else if (card.getRank() == "Q") {
				value += 10;
			}
			else if (card.getRank() == "K") {
				value += 10;
			}
			else if (card.getRank() == "A") {
				aces += 1;
			}
		}
		
		for (int i = 0; i < aces; i++) {
			if (value > 10) {
				value += 1;
			}
			else {
				value += 11;
			}
		}
		
		return value;
	}
}
