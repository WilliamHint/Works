/*  File name: Player.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 3
	Date: 07-11-2022
	Professor: Daniel Cormier
	Purpose: A class that holds the framework of a player. Including the players deck, as well as action of playing the card.
*/
import java.util.ArrayList;
import java.util.Random;


/**
 * This stores and modifies the hand arrayList of each player
 * @author William Hinterberger
 * @version 1.2
 * @since Java 8
 */
public class Player {
	
	//Setting up rng in this class
	/***/
	Random myRNG = new Random();
	
	//ArrayList that holds each players hands
	/**ArrayList of type card that holds a players hand*/
	private ArrayList<Card> pHand = new ArrayList <Card>();
	
	//Holds the players name
	/**String that hold the players name*/
	private String pName;
	
	//Holds the players score
	/**String that holds the player score*/
	private int wonHands = 0;
	
	//Constructor that holds player name
	/**
	 * Constructor that assigns the pName a name given by user
	 * @param name The name of the player as given by user
	 */
	public Player(String name) 
	{
		pName = name;
	}
	
	//Adds a card to the hand array list
	/**
	 * Adds a card to the players hand
	 * @param card a card of type card from Class lab4
	 */
	public void addCard(Card card) {
		pHand.add(card);
	}
	
	/**
	 * returns the player name for use outside of this class
	 * @return the players name
	 */
	//Returns player's name
	public String getName() {
		return pName;
	}
	
	/**
	 * Clears the decks
	 */
	//Resets the game
	public void reset() {
		pHand.clear();
	}
	
	//Adds 1 to the point total
	/**
	 * Adds 1 to the players point total
	 */
	public void handWon() {
		wonHands = wonHands+1;
	}
	
	/**
	 * @return the amount of hands 1
	 */
	public int getScore() {
		return wonHands;
	}
	
	/**
	 * Randomly generates a number, deletes it from the phand array list then returns it to lab 4
	 * @return a copy of a card 
	 */
	public Card playCard() {
		int randomlyGeneratedNumber = (myRNG.nextInt(pHand.size()));
		Card copy = pHand.get(randomlyGeneratedNumber);
		pHand.remove(randomlyGeneratedNumber);
		return copy;
	}
	
	/**
	 * Does the same as playCard without removing it from the pHand Array list
	 * @param x a value that corresponds to a card
	 * @return that x values symbol
	 */
	public Card showCard(int x) {
		Card copy = pHand.get(x);
		return copy;
	}
}
	

