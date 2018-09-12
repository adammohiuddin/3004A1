package blackjack;

public class Card {
	private String suit;
	private String rank;
	
	public Card(String s, String r) {
		this.suit = s;
		this.rank = r;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public String getRank() {
		return this.rank;
	}
	
}
