package game;

import javax.swing.*;

import box.LogBookBox;
import buttons.GameBoard;

public class Aircraftcarrier extends Ship {
	
	public Aircraftcarrier(){
		ship = new int[5];
		hits = 0;
		size = 5;
		this.Initialize();
	}
	
	@Override
	protected void position(int[][] gameboard, int col, int row){
		this.initialX = row;
		this.initialY = col;
		for(int i = 0; i < size; i++){
			gameboard[col+i][row] = 4;
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
		ImageIcon[] icon= new ImageIcon[5];
		icon[0] = new ImageIcon("src/images/aircraftcarrier1.jpg");
		icon[1] = new ImageIcon("src/images/aircraftcarrier2.jpg");
		icon[2] = new ImageIcon("src/images/aircraftcarrier3.jpg");
		icon[3] = new ImageIcon("src/images/aircraftcarrier4.jpg");
		icon[4] = new ImageIcon("src/images/aircraftcarrier5.jpg");
		for (int i = 0; i < 5; i++) {
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
			LogBookBox.changeMessage("You destroyed the enemy's\n                                         Aircraft Carrier!");
			Board.ships[Board.gameboard[this.getInitialY()][this.getInitialX()]].setShiponScreen();
		}
		else{
			LogBookBox.changeMessage("You hit the enemy's ship!\nKeep up the good work!");
		}
	}
	
}
