/*  File name: Lab2.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 2
	Date: 06-10-2022
	Professor: Daniel Cormier
	Purpose: A Class that is a child class of class pieces that mainly checks the validity of rook moves
*/
public class Rook extends Piece{	
		public Rook (boolean paramColor) {
			isBlack = paramColor;
		}
		
		public void getValidMoves(int row, int column) {
			if (isBlack == true) {//Checks if the piece is black or white
				System.out.print("It's valid moves are: ");
			}else if(isBlack!=true) {
				System.out.print("It's valid moves are: ");
			}
			
			for (int i = 0; i < (8);i++){//Runs through every horizontal square, skipping the square the piece is on
				if (i!=row){
					System.out.print((i+1)+","+(column+1)+" ");
				}
			}
			
			for (int y = 0; y < (8);y++){//Runs through every vertical square, skipping the square the piece is on
				if (y!=column){
					System.out.print((row+1)+","+(y+1)+" ");
					}
			}
			
			System.out.println();
			
			
		}
		
		public String getSymbol() {
			if (isBlack != true) {//lower case r if white
				return ("r");
			} else 
			{
				return ("R");//upper if the piece is black
			}
		}
		
		public String getName() {
			if (isBlack != true) {
				return ("white rook");//if its white return lower p
			} else 
			{
				return ("black rook");//if its black return upper p]
			}
		}

	}
