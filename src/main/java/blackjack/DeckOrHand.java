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
	
	public String getCard(int i) {
		return this.cards.get(i).toString();
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
}
