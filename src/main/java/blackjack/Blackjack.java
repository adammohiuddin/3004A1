package blackjack;

public class Blackjack {
	
	private static final int maxHandValue = 21;
	
	public static DeckOrHand didBlackjackHappen(DeckOrHand playerHand, DeckOrHand dealerHand) {
		boolean playerWin = false;
		boolean dealerWin = false;
		
		if (playerHand.getHandValue() == maxHandValue && playerHand.size() == 2) {
			for (int i = 0; i < playerHand.size(); i++) {
				if (playerHand.getCard(i).getRank().startsWith("A")) {
					playerWin = true;
				}		
			} 
		}
		
		if (dealerHand.getHandValue() == maxHandValue && dealerHand.size() == 2) {
			for (int i = 0; i < dealerHand.size(); i++) {
				if (dealerHand.getCard(i).getRank().startsWith("A")) {
					dealerWin = true;
				}
			} 
		}
		
		if (dealerWin && playerWin) {
			System.out.println("\nBoth the Dealer and the Player have blackjack");
			System.out.println("Dealer wins... Better luck next time!");
			return dealerHand;
		}
		else if (dealerWin) {
			System.out.println("\nThe Dealer has blackjack");
			System.out.println("The Dealer wins... Better luck next time!");
			return dealerHand;
		}
		else if (playerWin) {
			System.out.println("\nThe Player has blackjack");
			System.out.println("The Player wins! Congratulations!");
			return playerHand;
		}
		else {
			return null;
		}
	}
	
}
