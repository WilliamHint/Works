public class Queen extends Piece{	
		public Queen (boolean paramColor) {
			isBlack = paramColor;
		}
		
		public void getValidMoves(int row, int column) {
			System.out.println("Move functionality not yet implemented");
		}
		
		public String getSymbol() {
			if (isBlack != true) {
				return ("q");
			} else 
			{
				return ("Q");
			}
		}
		
		public String getName() {
			if (isBlack != true) {
				return ("white queen");//if its white return lower p
			} else 
			{
				return ("black queen");//if its black return upper p]
			}
		}
	}