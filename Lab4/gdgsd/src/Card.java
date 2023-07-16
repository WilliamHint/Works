/*  File name: Card.java
	Author: Daniel Cormier
	Course: CST8132  OOP, Lab Section: 301
	Lab: 3
	Date: 07-11-2022
	Professor: Daniel Cormier
	Purpose: Extends CardTemplate. Returns the short and long card names.
*/
/**
 * This class implements the CardTemplate Class
 * @author William Hinterberger
 * @version 1.2
 * @since Java 8
 * @see CardTemplate
 */

public class Card implements CardTemplate{
	/** A value 0-3 that corresponds to card suit */
	private int cardSuit;
	/** A value 0-3 that corresponds to card suit */
	private int cardValue;
	
	/**
	 * Card constructor assigns card suit and rank a value to be used later
	 * @param suit An int that corresponds to a suit
	 * @param value An int that corresponds to a card rank
	 */
	public Card(int suit,int value) {
		cardSuit = suit;
		cardValue = value;
	}
	
	/**
	 * Returns the short symbols of a card
	 * @return short symbols of a card
	 */
	public String getShortName() {
		 return (rankShort[cardValue])+(suitShort[cardSuit]);
	}
	
	/**
	 * Returns the long symbols of a card
	 * @return long symbols of a card
	 */
	public String getLongName() {
		return (rankLong[cardValue])+(suitLong[cardSuit]);
	}
}
