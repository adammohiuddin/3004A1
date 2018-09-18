package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeckOrHand {
	private ArrayList<Card> cards;
	private boolean aceIs11 = false;
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
	
	public void makeDeckFromFile(ArrayList<String> cardInput) {
		String s, r;
		for (String string : cardInput) {
			s = string.substring(0, 1);
			r = string.substring(1, string.length());
			this.cards.add(new Card(s, r));
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
	
	public boolean isAce11() {
		return aceIs11;
	}
	
	public int getHandValue() {
		int value = 0;
		int aces = 0;
		
		for (Card card : this.cards) {	
			switch (card.getRank()) {
			case "2":
				value += 2;
				break;
			case "3":
				value += 3;
				break;
			case "4":
				value += 4;
				break;
			case "5":
				value += 5;
				break;
			case "6":
				value += 6;
				break;
			case "7":
				value += 7;
				break;
			case "8":
				value += 8;
				break;
			case "9":
				value += 9;
				break;
			case "10":
				value += 10;
				break;
			case "J":
				value += 10;
				break;
			case "Q":
				value += 10;
				break;
			case "K":
				value += 10;
				break;
			case "A":
				aces += 1;
				break;
				
			default:
				break;
			}
		}
		
		aceIs11 = false;
		for (int i = 0; i < aces; i++) {
			if (value > 10) {
				value += 1;
			}
			else {
				value += 11;
				aceIs11 = true;
			}
		}
		
		return value;
	}
}
