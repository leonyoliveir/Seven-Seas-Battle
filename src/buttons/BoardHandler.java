package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import game.Board;

public class BoardHandler implements ActionListener {

	private static GameButton buttons[][];
	
	public BoardHandler(GameButton buttons[][]) {
		this.buttons = buttons;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GameButton clicked = (GameButton) e.getSource();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (buttons[i][j].equals(clicked)) {
					try{
						Board.shot(clicked);
					} catch (IOException exc){
						exc.getMessage();
					}
					clicked.setEnabled(false);
				}
			}
		}
	}
	
	public static void disableAll() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
	}
}
