/*  File name: Lab2.java
	Author: Ethan Hinterberger, 041066029
	Course: CST8132  OOP, Lab Section: 301
	Lab: 2
	Date: 06-10-2022
	Professor: Daniel Cormier
	Purpose: A program that will display a grid with the chess pieces in side of the grid. The user then can move those piecs around said grid or check
	the validity of the rook and pawn moves.
*/
import java.util.Scanner;
public class Lab3 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		boolean quit = false;//Menu navigation
		Piece[][] piece = new Piece[8][8];
		
		Lab3.fillBoard(piece);//Calls method that fills pieces with starting positions
		Lab3.drawBoard(piece);//Calls method that outputs the board
		
		//Menu
		do {
			System.out.print("\n");
			System.out.println("Select a menu option\n1 to move a piece\n2 to check valid moves for a piece\n3 to print the board\nQ to quit");
			String option = keyboard.next();
			keyboard.nextLine();
			//1 has the user enter the coords of piece they would like to move and the coords they want to have that piece end up
			if (option.equals("1")== true) {
				
				System.out.println("Enter the row number of the piece you would like to move:");
				int rowMove = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				System.out.println("Enter the col number of the piece you would like to move:");
				int colMove = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				System.out.println("Enter the row number of the sqaure you would like to move the piece to:");
				int newRowMove = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				
				System.out.println("Enter the col number of the sqaure you would like to move the piece to:");
				int newColMove = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				rowMove = rowMove -1;//Adjusting the values to work in an array
				colMove = colMove -1;
				newRowMove = newRowMove -1;
				newColMove = newColMove -1;
				
				Lab3.movePiece(piece, rowMove, colMove,newRowMove,newColMove);//Calls the method that moves a piece
			
			//2 has the user enter the coords of the piece whose moves they would like to check
			}else if (option.equals("2")== true) {
				System.out.println("Enter the row number of the piece you would like to check:");
				int rowCheck = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				System.out.println("Enter the column number of the piece you would like to check:");
				int colCheck = Lab3.chessBoundsCheck();//Calls the method that verifies if the user number is a valid chess square
				
				rowCheck = rowCheck -1;//Adjusting the values to work in an array
				colCheck = colCheck -1;
				
				if ((piece[rowCheck][colCheck]) != null) {//Checking if there is a piece on that squared
					System.out.println("The piece on that square is a "+piece[rowCheck][colCheck].getName().toString());
					piece[rowCheck][colCheck].getValidMoves(rowCheck,colCheck);//Calls the method in class pieces that checks is what the valid moves are
				}else {
					System.out.println("There is no piece on that square");
				}
			//3 reprints the board
			}else if (option.equals("3")== true) {
				Lab3.drawBoard(piece);//Calls the method that prints the board
			//Entering "Q" ends the program
			}else if ((option.toString().toLowerCase()).equals("q")) {
				quit = true;
			//Tells the user they did not pick a valid option
			}else {
				System.out.println("Only 1,2,3 and Q are valid menu options");
			}
		//End if
		//Exits message and prints a funny message
		}while (quit != true);//End Loop
		System.out.print("Thank you for playing \"Just Barely Chess\"\nCode written by: Ethan Hinterberger ");
	}
	
	
	public static void drawBoard(Piece piece[][]){
		//Draws the board
		System.out.print("     ");
		//Loop that displays the top board numbers
		for (int i = 0; i < (8);i++){
			System.out.print(""+(i+1)+"     ");
		}//End loop

		System.out.println();
		//For loop that draws grid
		for (int x = 0;x < (8);x++) {
			System.out.print("  +");
			for (int i = 0; i < (8);i++){
				System.out.print("-----+");
			}//End loop
			System.out.println();
			
			//For loop that draws gird
			System.out.print("  |");
			for (int i = 0; i < (8);i++){
				System.out.print("     |");
			}//End loop
			System.out.println();
			System.out.print(x+1);
			//For loop that places pieces in position
			for (int y = 0;y < (8);y++) {
				if (piece[x][y] != null) {
					System.out.print(" |  "+piece[x][y].getSymbol()+ " ");
				} else{
					System.out.print(" |    ");
				}//End if
				if (y == 8-1) {
					System.out.print(" |");
					System.out.println();
				}//End If
			}//End loop
			System.out.print("  |");
			//Prints end of columns
			for (int i = 0; i < (8);i++){
				System.out.print("     |");
			}//End loop
			System.out.println();
			
		}
		System.out.print("  +");
		//For that prints bottom of grid
		for (int i = 0; i < (8);i++){
			System.out.print("-----+");
		}//End loop
	}
	
	public static Piece[][] fillBoard(Piece piece[][]){
		//Method that fills piece[][] with the starting positions of the chessmen
		piece[6][0] = new Pawn(true);
		piece[6][1] = new Pawn(true);
		piece[6][2] = new Pawn(true);
		piece[6][3] = new Pawn(true);
		piece[6][4] = new Pawn(true);
		piece[6][5] = new Pawn(true);
		piece[6][6] = new Pawn(true);
		piece[6][7] = new Pawn(true);

		piece[1][0] = new Pawn(false);
		piece[1][1] = new Pawn(false);
		piece[1][2] = new Pawn(false);
		piece[1][3] = new Pawn(false);
		piece[1][4] = new Pawn(false);
		piece[1][5] = new Pawn(false);
		piece[1][6] = new Pawn(false);
		piece[1][7] = new Pawn(false);
		
		piece[0][0] = new Rook(false);
		piece[0][7] = new Rook(false);
		
		piece[7][0] = new Rook(true);
		piece[7][7] = new Rook(true);
		
		piece[0][1] = new Knight(false);
		piece[0][6] = new Knight(false);
		
		piece[7][1] = new Knight(true);
		piece[7][6] = new Knight(true);
		
		piece[0][2] = new Bishop(false);
		piece[0][5] = new Bishop(false);
		
		piece[7][2] = new Bishop(true);
		piece[7][5] = new Bishop(true);
		
		piece[0][3] = new King(false);
		piece[0][4] = new King(false);
	
		piece[7][3] = new King(true);
		piece[7][4] = new Queen(true);
		
		return piece;
	}
	
	public static Piece[][] movePiece(Piece piece[][],int oldRow,int oldCol,int newRow,int newCol) {
		//Method that locates the position of the piece that wants to be moved and moves that value to the new position, then wipes the old values
		piece[newRow][newCol] = piece[oldRow][oldCol];
		piece[oldRow][oldCol] = null;
		return piece;
	}
	
	public void validMove(Piece[][] piece,int row,int col) {
		//Calls class piece which invokes the individual piece methods in each subclass
		piece[row][col].getValidMoves(row, col);
	}
	
	public static int chessBoundsCheck() {;
		//Method that checks if the user input is valid on a chess board
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		do {
			//Traps the user if their value is not 1 through 8
			int value = keyboard.nextInt();
			keyboard.nextLine();
			if ((value < 1)||(value > 8)) {
				System.out.println("Valid spaces on the chess board are numbers 1 through 8\nPlease select again:");
			}else {//Quits once the value is in the valid range
				quit = true;
				return value;
			}//End if
		} while (quit==false);//End loop
		return 0;//Dummy value that will never be reached
	}

	
}
