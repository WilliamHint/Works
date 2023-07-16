public class Bishop extends Piece{	
		public Bishop (boolean paramColor) {
			isBlack = paramColor;
		}
		
		public void getValidMoves(int row, int column) {
			System.out.println("Move functionality not yet implemented");
		}
		
		public String getSymbol() {
			if (isBlack != true) {
				return ("b");
			} else 
			{
				return ("B");
			}
		}
		
		public String getName() {
			if (isBlack != true) {
				return ("white king");//if its white return lower p
			} else 
			{
				return ("black king");//if its black return upper p]
			}
		}
	}