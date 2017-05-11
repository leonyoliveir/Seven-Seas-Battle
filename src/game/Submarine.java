package game;

import javax.swing.ImageIcon;

import box.LogBookBox;
import buttons.GameBoard;

public class Submarine extends Ship {
	
	public Submarine(){
		ship = new int[3];
		hits = 0;
		size = 3;
		this.Initialize();
	}
	
	@Override
	protected void position(int[][] gameboard, int col, int row){
		this.initialX = row;
		this.initialY = col;
		for(int i = 0; i < size; i++){
			gameboard[col+i][row] = 2;
		}
	}

	@Override
	public int getInitialY() {
		return this.initialY;
	}

	@Override
	public int getInitialX() {
		return this.initialX;
	}

	@Override
	public void setShiponScreen() {
		ImageIcon[] icon= new ImageIcon[3];
		icon[0] = new ImageIcon("src/images/submarine1.jpg");
		icon[1] = new ImageIcon("src/images/submarine2.jpg");
		icon[2] = new ImageIcon("src/images/submarine3.jpg");
		for (int i = 0; i < 3; i++) {
			GameBoard.buttons[getInitialY()+i][getInitialX()].setDisabledIcon(icon[i]);
		}
	}
	
	@Override
	protected void shot(int j) {
		if(ship[j] != -1){ // Check if there's positions that hasn't been hit
			ship[j] = -1; // If hasn't sets to -1
			hits++;
		}
		
		if(test()){ // Verify if all the positions have been hit
			LogBookBox.changeMessage("You destroyed the enemy's\n                                                Submarine!");
			Board.ships[Board.gameboard[this.getInitialY()][this.getInitialX()]].setShiponScreen();
		}
		else{
			LogBookBox.changeMessage("You hit the enemy's ship!\nKeep up the good work!");
		}
	}
}
