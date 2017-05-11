package buttons;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

	public static GameButton buttons[][] = new GameButton[10][10];
	private BoardHandler hand;
	
	public GameBoard() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		this.setSize(550, 550);
		this.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 30, Color.BLUE.brighter()));
		this.hand = new BoardHandler(buttons);
		cons.weightx = 0;
        cons.weighty = 0;
        for(int i = 0; i < 10; i++) {
        	cons.gridx = i;
        	for(int j = 0; j < 10; j++) {
        		cons.gridy = j;
        		buttons[i][j] = new GameButton(i, j);
                add(buttons[i][j], cons);
                buttons[i][j].addActionListener(hand);
        	}
        }
	}
	
}
