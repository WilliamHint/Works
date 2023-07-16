/*  File name: Lab2.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 2
	Date: 06-10-2022
	Professor: Daniel Cormier
	Purpose: A Class that is a child class of class pieces that mainly checks the validity of pawn moves
*/
public class Pawn extends Piece {
	
	
	public Pawn (boolean paramColor) {
		isBlack = paramColor;
	}
	
	public void getValidMoves(int row, int column){
		
		if (isBlack == true){//If the piece is black
			if (row != 0) { //Check if the black piece is on the white home row
				System.out.print("It's valid moves are: ");//General statement for all back pieces
			}
			if (row==0) {
				System.out.println("It has no valid moves remaining");//No moves left if the piece is on the white home row
			}else if (row == 6) {
				System.out.println(row+","+(column+1)+" "+(row-1)+","+(column+1));//Checks if its on the starting position for black
			}else {
				System.out.println(row+","+(column+1));//Checks if its anywhere else and adds 1
			}
		}else {//If the piece is white
			if (row != 7) {//If the piece is on any square other then the black home row
				System.out.print("It's valid moves are: ");//General statement for white piece
			}
			if (row==7) {//If it's on the home row
				System.out.println("It has no valid moves remaining");//No valid moves left
			}else if (row == 1) {
				System.out.println((row+2)+","+(column+1)+" "+(row+3)+","+(column+1));//Outputting if on the white home row
			}else {
				System.out.println((row+2)+","+(column+1));//Outputting the cell the piece can move
			}
		}		
	}
	
	public String getSymbol() {
		if (isBlack != true) {
			return ("p");//if its white return lower p
		} else 
		{
			return ("P");//if its black return upper p]
		}
			
		
	}
	
	public String getName() {
		if (isBlack != true) {
			return ("white pawn");//if its white return lower p
		} else 
		{
			return ("black pawn");//if its black return upper p]
		}
	}

}
