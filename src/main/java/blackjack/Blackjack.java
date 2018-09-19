package blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
	
	private static final int maxHandValue = 21;
	private static Scanner fileScanner;
	
	
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
	
	
	
	public static void createDeckAndPickUI(DeckOrHand deck, ArrayList<String> playerMovesFromFile, Scanner playerConsole) {
		
		System.out.println("Hello! Thank you for choosing AJNM blackjack!");
		System.out.println("Would you like to play on the console (c) or by file (f)?");
		
		ArrayList<String> cardsFromFile;
		String command = playerConsole.nextLine();
		
		if (command.startsWith("f")) {
			
			System.out.println("Please enter the filename in src/main/resources (ex: filename.txt)");
			command = "src/main/resources/" + playerConsole.nextLine();

			try {
				fileScanner = new Scanner(new File(command));
				fileScanner.useDelimiter(" ");
			} catch (FileNotFoundException e) {
				System.out.println("Could not open filename entered. Please try again.");
				e.printStackTrace();
			}
			
			String tokenFromFile;
			cardsFromFile = new ArrayList<>();
			
			while (fileScanner.hasNext()) {
				tokenFromFile = fileScanner.next();
				if (tokenFromFile.length() > 1) {
					cardsFromFile.add(tokenFromFile);
				} else {
					playerMovesFromFile.add(tokenFromFile);
				}
			}

			deck.makeDeckFromFile(cardsFromFile);
			fileScanner.close();
			
		}
		else if (command.startsWith("c")) {
			deck.makeDeck();
			deck.shuffleDeck();
		}	
	}
	

	
}
