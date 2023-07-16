public class Knight extends Piece{	
		public Knight (boolean paramColor) {
			isBlack = paramColor;
		}
		
		public void getValidMoves(int row, int column) {
			System.out.println("Move functionality not yet implemented");
		}
		
		public String getSymbol() {
			if (isBlack != true) {
				return ("n");
			} else 
			{
				return ("N");
			}
		}
		
		public String getName() {
			if (isBlack != true) {
				return ("white knight");//if its white return lower p
			} else 
			{
				return ("black knight");//if its black return upper p]
			}
		}
	}