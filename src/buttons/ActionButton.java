package buttons;

import java.awt.Color;
import javax.swing.*;

public class ActionButton extends JButton {

	public ActionButton(String address) {
		super();
		ImageIcon icon = new ImageIcon(address);
		this.setIcon(icon);
		this.setSize(120, 50);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE));
	}
	
}
