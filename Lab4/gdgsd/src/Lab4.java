/*  File name: Lab4.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 3
	Date: 07-11-2022
	Professor: Daniel Cormier
	Purpose: A program that will play a card game with 4 computer players. Each player has a hand, a card is picked fro those hands and randomly played. The winner is then picked at random
*/
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * This class acts as the main operating body of the card game
 * @author William Hinterberger
 * @version 1.2
 * @since Java 8
 */
public class Lab4 {
	//Random number instance
	private Random myRNG = new Random();
	//Input from user
	Scanner keyboard = new Scanner(System.in);
	//Card array list that acts as a deck 
	/**An Array list that holds a deck of 52 cards*/
	private ArrayList <Card> deck = new ArrayList <Card>();
	
	//Variables that have check if the game should continue
	/**A boolean that continues the game if the user says so*/
	private Boolean play = true;
	
	/**A boolean that continues the hand if the user says so*/
	private String cont;
	
	//Signifies the last rounds winner
	/**Stores the last round winner*/
	private String lastRoundWinner = "none";
	
	//Round count
	/**Stores the round score*/
	private int round = 1;
	
	//If each players hand was shown
	private Boolean showed = false;
	
	/**
	 * Constructor that holds pretty much all the logic for the program. Including instancing all of the other classes and array lists for all player
	 */
	public Lab4() {
		//Filling the deck with 52 cards from class card
		for (int i = 0;i < (4);i++) {
			for (int y = 0;y < (13);y++) {
				Card myCard = new Card(i, y);
				deck.add(myCard);
			}
		}
		
		
		//Getting each players name, and then instancing it with 4 different instances of player class
		System.out.println("Enter player 1's name:");
		String p1Name = keyboard.next() ;
		keyboard.nextLine();			
		Player p1 = new Player(p1Name);
		p1.reset();
			
		System.out.println("Enter player 2's name:");
		String p2Name = keyboard.next() ;
		keyboard.nextLine();
		Player p2 = new Player(p2Name);
		p2.reset();
			
		System.out.println("Enter player 3's name:");
		String p3Name = keyboard.next() ;
		keyboard.nextLine();
		Player p3 = new Player(p3Name);
		p3.reset();
			
		System.out.println("Enter player 4's name:");
		String p4Name = keyboard.next() ;
		keyboard.nextLine();
		Player p4 = new Player(p4Name);
		p4.reset();
		
		//For loop that gets a random number, assigns it player 1's deck and then removes it from the communal deck by 
		//adding to the players individual deck, and then repeats for each player, 13 times
		for (int t = 13;t >= (1);t--) {
			int newCard = myRNG.nextInt(deck.size());
			p1.addCard(deck.get(newCard));
			deck.remove(newCard);
			
			newCard = myRNG.nextInt(deck.size());
			p2.addCard(deck.get(newCard));
			deck.remove(newCard);
			
			newCard = myRNG.nextInt(deck.size());
			p3.addCard(deck.get(newCard));
			deck.remove(newCard);
			
			newCard = myRNG.nextInt(deck.size());
			p4.addCard(deck.get(newCard));
			deck.remove(newCard);
		}
		
		while (play == true){
			//If there are still cards in the deck
			if (round <= 13){
				//Show round number
				System.out.println("Round "+round+":\n");
				
				//Showing each players score
				System.out.println(p1.getName()+"'s score:"+p1.getScore());
				System.out.println(p2.getName()+"'s score:"+p2.getScore());
				System.out.println(p3.getName()+"'s score:"+p3.getScore());
				System.out.println(p4.getName()+"'s score:"+p4.getScore());
				
				//Showing p1's hand
				System.out.println("\n"+p1.getName()+"'s hand:");
				for (int x = 0;x < (14-round);x++) {
					//Calling the players deck and outputting the symbol
					System.out.print(p1.showCard(x).getShortName()+" ");
				}
				
				//Showing p2's hand
				System.out.println("\n");
				System.out.println(p2.getName()+"'s hand:");
				for (int x = 0;x < (14-round);x++) {
					//Calling the players deck and outputting the symbol
					System.out.print(p2.showCard(x).getShortName()+" ");
				}
				
				//Showing p3's hand
				System.out.println("\n");
				System.out.println(p3.getName()+"'s hand:");
				for (int x = 0;x < (14-round);x++) {
					//Calling the players deck and outputting the symbol
					System.out.print(p3.showCard(x).getShortName()+" ");
				}
				
				//Showing p4's hand
				System.out.println("\n");
				System.out.println(p4.getName()+"'s hand:");
				for (int x = 0;x < (14-round);x++) {
					//Calling the players deck and outputting the symbol
					System.out.print(p4.showCard(x).getShortName()+" ");
				}
				//Asking the user if they wish to play the hand
				System.out.println("\n\nWould you like to play out the hand?(Yes/No)");
				cont = keyboard.next();
				keyboard.nextLine();
				
				//Stops play if the user picks to stop
				if (cont.toLowerCase().equals("no")) {
					play = false;
				}
				
				//If player one won last, start with them
				if (lastRoundWinner.equals("p1")||(lastRoundWinner.equals("none"))&& play!=false) {
					System.out.println(p1.getName()+"'s card: "+p1.playCard().getShortName());
					System.out.println(p2.getName()+"'s card: "+p2.playCard().getShortName());
					System.out.println(p3.getName()+"'s card: "+p3.playCard().getShortName());
					System.out.println(p4.getName()+"'s card: "+p4.playCard().getShortName());
				
				//If player two won last, start with them	
				}else if (lastRoundWinner.equals("p2")&& play!=false) {
					System.out.println(p2.getName()+"'s card: "+p2.playCard().getShortName());
					System.out.println(p3.getName()+"'s card: "+p3.playCard().getShortName());
					System.out.println(p4.getName()+"'s card: "+p4.playCard().getShortName());
					System.out.println(p1.getName()+"'s card: "+p1.playCard().getShortName());
				
				//If player three won last, start with them
				}else if (lastRoundWinner.equals("p3")&& play!=false) {
					System.out.println(p3.getName()+"'s card: "+p3.playCard().getShortName());
					System.out.println(p4.getName()+"'s card: "+p4.playCard().getShortName());
					System.out.println(p1.getName()+"'s card: "+p1.playCard().getShortName());
					System.out.println(p2.getName()+"'s card: "+p2.playCard().getShortName());
					
				//If player four won last, start with them
				}else if (lastRoundWinner.equals("p4")&& play!=false) {
					System.out.println(p4.getName()+"'s card: "+p4.playCard().getShortName());
					System.out.println(p1.getName()+"'s card: "+p1.playCard().getShortName());
					System.out.println(p2.getName()+"'s card: "+p2.playCard().getShortName());
					System.out.println(p3.getName()+"'s card: "+p3.playCard().getShortName());
				}
				
				//Picking the winner
				int roundWinner = (myRNG.nextInt(4));
				
				//Outputting the hand winner
				if (roundWinner == 0 && play!=false) {
					p1.handWon();
					System.out.println(p1.getName()+" wins the hand!");
					lastRoundWinner = "p1";
				}else if (roundWinner == 1&& play!=false) {
					p2.handWon();
					System.out.println(p2.getName()+" wins the hand!");
					lastRoundWinner = "p2";
				}else if (roundWinner == 2&& play!=false) {
					p3.handWon();
					System.out.println(p3.getName()+" wins the hand!");
					lastRoundWinner = "p3";
				}else if (roundWinner == 3&& play!=false) {
					p4.handWon();
					System.out.println(p4.getName()+" wins the hand!");
					lastRoundWinner = "p4";
				}
				
				//advancing round count
				round++;
				
			//Showing the user that won the most hands
			}else {
				showed = true;
				System.out.println("\nGAME OVER!");
				if ((p1.getScore()>p2.getScore())&&(p1.getScore()>p3.getScore())&&(p1.getScore()>p4.getScore())){
					System.out.println(p1.getName()+" wins the game!");
				}else if ((p2.getScore()>p1.getScore())&&(p2.getScore()>p3.getScore())&&(p2.getScore()>p4.getScore())){
					System.out.println(p2.getName()+" wins the game!");
				}else if ((p3.getScore()>p2.getScore())&&(p3.getScore()>p1.getScore())&&(p3.getScore()>p4.getScore())){
					System.out.println(p3.getName()+" wins the game!");
				}else if ((p4.getScore()>p2.getScore())&&(p4.getScore()>p3.getScore())&&(p4.getScore()>p1.getScore())){
					System.out.println(p4.getName()+" wins the game!");
				}else {
					System.out.println("\nA tie has occured");
				}
				play = false;
			}
		}
		//Showing the user that won the most hands, if the user decided to quit before all the rounds concluded
		if (showed.equals(false)) {
			System.out.println("\nGAME OVER!");
			if ((p1.getScore()>p2.getScore())&&(p1.getScore()>p3.getScore())&&(p1.getScore()>p4.getScore())){
				System.out.println(p1.getName()+" wins the game!");
			}else if ((p2.getScore()>p1.getScore())&&(p2.getScore()>p3.getScore())&&(p2.getScore()>p4.getScore())){
				System.out.println(p2.getName()+" wins the game!");
			}else if ((p3.getScore()>p2.getScore())&&(p3.getScore()>p1.getScore())&&(p3.getScore()>p4.getScore())){
				System.out.println(p3.getName()+" wins the game!");
			}else if ((p4.getScore()>p2.getScore())&&(p4.getScore()>p3.getScore())&&(p4.getScore()>p1.getScore())){
				System.out.println(p4.getName()+" wins the game!");
			}else {
				System.out.println("\nA tie has occured");
			}
			play = false;
		}
		
	
	}
	
	/**
	 * Main that calls lab 4 and asks the user if they want to play again
	 */
	public static void main(String[] args) {
		boolean contGame = true;
		String playAgain;
	
	//Loop that restarts game if player chooses to.
	while (contGame == true) {
		Scanner keyboard = new Scanner(System.in);
		new Lab4();
		System.out.println("Would you like to play again?(yes/no)");
		playAgain = keyboard.next();
		keyboard.nextLine();
		
		if ((playAgain.toLowerCase()).equals("no")) {
			contGame = false;
			System.out.println("\nThank you for playing");
		}
		
	}
		
		
	
		
	}

}
