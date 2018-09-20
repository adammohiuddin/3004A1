package blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
	
	private static final int maxHandValue = 21;
	private static final int dealerSoftValue = 17;
	
	private static Scanner fileScanner;
	private static Scanner playerConsole;
	
	public static boolean gameOver = false;
	private static boolean usingFile = false;
	
	
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
			System.out.println("Both the Dealer and the Player have blackjack.");
			System.out.print("The Dealer's hand is: ");
			System.out.println(dealerHand.showHand());
			System.out.print("The value of the Dealer's hand is: ");
			System.out.println(dealerHand.getHandValue());
			System.out.println("The Dealer wins... Better luck next time!");
			gameOver = true;
			return dealerHand;
		}
		else if (dealerWin) {
			System.out.println("The Dealer has blackjack.");
			System.out.print("The Dealer's hand is: ");
			System.out.println(dealerHand.showHand());
			System.out.print("The value of the Dealer's hand is: ");
			System.out.println(dealerHand.getHandValue());
			System.out.println("The Dealer wins... Better luck next time!");
			gameOver = true;
			return dealerHand;
		}
		else if (playerWin) {
			System.out.println("The Player has blackjack.");
			System.out.print("The Dealer's hand is: ");
			System.out.println(dealerHand.showHand());
			System.out.print("The value of the Dealer's hand is: ");
			System.out.println(dealerHand.getHandValue());
			System.out.println("The Player wins! Congratulations!");
			gameOver = true;
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
			
			usingFile = true;
			System.out.println("Please enter the filename in src/main/resources (ex: filename.txt).");
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
	
	
	public static void playerTurn(DeckOrHand playerHand, DeckOrHand dealerHand, ArrayList<String> playerMovesFromFile, DeckOrHand deck, Scanner playerConsole, boolean usingFile) {
		
		System.out.print("The Player's hand is: ");
		System.out.println(playerHand.showHand());
		
		
		while(true) {
			
			System.out.print("The value of the Player's hand is: ");
			System.out.println(playerHand.getHandValue());
			
			System.out.print("The Dealer's hand is: ");
			System.out.print(dealerHand.getCard(0).toString());
			System.out.println(" [Face Down]");
			
//			if (gameOver == false) {
//				if (didBlackjackHappen(playerHand, dealerHand) != null) {
//					break;
//				}
//			}
			
			String command;
			System.out.println("Do you want to Hit (H) or Stand (S)?");
			if (usingFile == false) {
				command = playerConsole.nextLine();
			} else {
				command = playerMovesFromFile.get(0);
				System.out.println(command);
				playerMovesFromFile.remove(0);
			}
			
			if (command.startsWith("H")) {
			
				playerHand.drawCard(deck);
			
				System.out.print("The Player draws a: ");
				System.out.println(playerHand.getCard(playerHand.size()-1).toString());
					
				if (playerHand.getHandValue() > maxHandValue) {
					System.out.print("The value of the Player's hand is: ");
					System.out.println(playerHand.getHandValue());
					System.out.println("Unfortunately the Player busts... better luck next time!");
					System.out.print("The Dealer's hand is: ");
					System.out.println(dealerHand.showHand());
					System.out.print("The value of the Dealer's hand is: ");
					System.out.println(dealerHand.getHandValue());
					gameOver = true;
					break;
				}	
			}
			else if (command.startsWith("S")) {
				System.out.print("The Player's hand is: ");
				System.out.println(playerHand.showHand());
				System.out.print("The value of the Player's hand is: ");
				System.out.println(playerHand.getHandValue());
				break;
			}
			
		}
	}
	
	public static void dealerTurn(DeckOrHand playerHand, DeckOrHand dealerHand, DeckOrHand deck, boolean gameOver) {
		
		if (gameOver == false) {
			if (didBlackjackHappen(playerHand, dealerHand) != null) {
				gameOver = true;
			}
		}
		if (gameOver == false) {
			System.out.print("The Dealer's hand is: ");
			System.out.println(dealerHand.showHand());
			System.out.print("The value of the Dealer's hand is: ");
			System.out.println(dealerHand.getHandValue());
		}
		
		if (dealerHand.getHandValue() > playerHand.getHandValue() && gameOver == false) {
			System.out.println("The Dealer has a better hand than the Player.");
			System.out.println("Unfortunately the Player loses... better luck next time!");
			gameOver = true;
		}
		
		if (gameOver == false) {
			while((dealerHand.getHandValue() == dealerSoftValue && dealerHand.isAce11()) || (dealerHand.getHandValue() < dealerSoftValue)) {
				dealerHand.drawCard(deck);
				
				System.out.print("The Dealer draws a: ");
				System.out.println(dealerHand.getCard(dealerHand.size()-1).toString());
	
			}
		}
		if (gameOver == false) {
			System.out.print("The Dealer's hand is: ");
			System.out.println(dealerHand.showHand());
			System.out.print("The value of the Dealer's hand is: ");
			System.out.println(dealerHand.getHandValue());
		}

		if ((dealerHand.getHandValue() > maxHandValue) && gameOver == false) {
			System.out.println("The Dealer busts.");
			System.out.println("The Player wins! Congratulations!");
			gameOver = true; 
		}
		
		if ((playerHand.getHandValue() == dealerHand.getHandValue()) && gameOver == false) {
			System.out.println("The Player's hand and the Dealer's hand have the same value.");
			System.out.println("It is a push situation. You tie.");
			gameOver = true;
		}
		
		if ((playerHand.getHandValue() > dealerHand.getHandValue()) && gameOver == false) {
			System.out.println("The Player has the higher hand.");
			System.out.println("The Player wins! Congratulations!");
			gameOver = true; 
		}
		else if (gameOver == false) {
			System.out.println("The Dealer has the higher hand.");
			System.out.println("Unfortunately the Player loses... better luck next time!");
			gameOver = true;
		}
		
	}
	
	
	public static void main(String[] args) {
		// Note: I have never actually played Blackjack before
		
		DeckOrHand deck = new DeckOrHand();
		DeckOrHand playerHand = new DeckOrHand();
		DeckOrHand dealerHand = new DeckOrHand();
				
		ArrayList<String> playerMovesFromFile = new ArrayList<>();
		playerConsole = new Scanner(System.in);
				
		createDeckAndPickUI(deck, playerMovesFromFile, playerConsole);
				
		playerHand.drawCard(deck);
		playerHand.drawCard(deck);
		dealerHand.drawCard(deck);
		dealerHand.drawCard(deck);
				
		playerTurn(playerHand, dealerHand, playerMovesFromFile, deck, playerConsole, usingFile);
		dealerTurn(playerHand, dealerHand, deck, gameOver);

		playerConsole.close();
	}
	
}
