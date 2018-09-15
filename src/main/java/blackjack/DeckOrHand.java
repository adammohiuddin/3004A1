package blackjack;

import java.util.ArrayList;

public class DeckOrHand {
	private ArrayList<Card> cards;
	
	public DeckOrHand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void makeDeck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				this.cards.add(new Card(suit, rank));
			}	
		}
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
}
