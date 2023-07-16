/*  File name: Lab2.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 2
	Date: 06-10-2022
	Professor: Daniel Cormier
	Purpose: A Class that acts as the parent class for all of the individual pieces
*/
public abstract class Piece {
	
	//Variable that checks if the piece is black or white
	protected boolean isBlack = true;
	
	public abstract void getValidMoves(int row, int col);
	
	//Gets the symbol
	public abstract String getSymbol();
	
	//Gets the name of the piece Note: I did not use this method because I didn't see we had to add it
	public abstract String getName() ;
}

