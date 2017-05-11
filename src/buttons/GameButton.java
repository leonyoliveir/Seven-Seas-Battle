package buttons;

import java.awt.Color;
import javax.swing.*;

public class GameButton extends JButton {

	private int xCoordenade;
	private int yCoordenade;
	
	public GameButton(int x, int y) {
		super();
		ImageIcon icon = new ImageIcon("src/images/water.jpg");
		this.setIcon(icon);
		this.setDisabledIcon(icon);
		this.setxCoordenade(x);
		this.setyCoordenade(y);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
	}

	public int getxCoordenade() {
		return xCoordenade;
	}

	public void setxCoordenade(int xCoordenade) {
		this.xCoordenade = xCoordenade;
	}

	public int getyCoordenade() {
		return yCoordenade;
	}

	public void setyCoordenade(int yCoordenade) {
		this.yCoordenade = yCoordenade;
	}
	
}
