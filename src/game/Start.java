package game;

public class Start {
	
	public static void start(){
		Board new_board = new Board();
		
		// Initialize the board and places the ships
		new_board.initializeBoard();
		new_board.positionShips();
	}
	
}