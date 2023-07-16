/*  File name: CardTemplate.java
	Author: Daniel Cormier
	Course: CST8132  OOP, Lab Section: 301
	Lab: 3
	Date: 07-11-2022
	Professor: Daniel Cormier
	Purpose: An interface that includes information used for drawing cards
*/
public interface CardTemplate
{
    //All values are static, as they won't vary from instance to instance.
    //Why use extra memory when we don't need to?
    
    //Convenience constants:
    final static int MAX_CARDS = 52;
    final static int MAX_SUITS = 4;
    final static int MAX_FACES = 13;
 
    // Contains the Unicode symbols for solid spades, hollow hearts,
    // hollow diamonds and solid clubs, respectively.  Try commenting it out if you're on a Linux or Mac
    // to see what happens?  If you see gibberish, use the other suitShort definition below.
//     static char[] suitShort = new char[]{'\u2660', '\u2661', '\u2662', '\u2663'};
    
    // Windows console does not render unicode characters.  Use the below line for all
    // Windows implementations:
    static char[] suitShort = new char[]{'s', 'h', 'd', 'c'};
    
    //To be used to assemble your card names:
    static String[] rankShort = new String[]{"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    static String[] suitLong = new String[]{"Spades", "Hearts", "Diamonds", "Clubs"};
    static String[] rankLong = new String[]{"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven",
        "Six", "Five", "Four", "Three", "Two"};
        
    //Method to return the "short name" of the card, drawn from the various Short arrays:
    //ie: "Ac" for "Ace of Clubs".
    public String getShortName();
    
    //Method to return the full name of the card, drawn from the various Long arrays:
    //ie: "Ace of Clubs"
    public String getLongName();
}


