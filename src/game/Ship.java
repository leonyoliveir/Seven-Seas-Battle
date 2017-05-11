package game;

public abstract class Ship {
	
	protected int[] ship;
	protected int hits;
	protected int size;
	protected int initialX;
	protected int initialY;
	
	// Initialize a ship
	protected void Initialize(){
		for(int i = 0; i < size; i++){
			ship[i] = -10;
		}
	}
	
	// Return how many times the ship has been hit
	protected int hit() {
		return hits;
	}
	
	/* Tests of the amount of hits is equal to the size of the ship
	 * Returns true if the ship has been sunk */
	public boolean test() {
		return (hit() == size);
	}
	
	// Verify if the row chosen has space for the ship
	protected boolean hasSpace(int[][] gameboard, int col, int row){
		int count = 0;
		int i = col;
		boolean valid = false;
		
		if (col + size < 10) {
			for(int j = 0; j < size; j++){
				if(gameboard[i][row] == -1){
					i++;
					count++;
				}
			}
			if(count == size){
				valid = true;
			}
		}
		
		return valid;
	}
	
	// Positions the ship on the board
	protected abstract void position(int[][] gameboard, int col, int row);
	
	public abstract int getInitialY();
	
	public abstract int getInitialX();
	
	public abstract void setShiponScreen();
	
	// Processes the shot
	protected abstract void shot(int j);
}
