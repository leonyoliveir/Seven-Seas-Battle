package buttons;

import java.awt.event.*;
import javax.swing.*;

import game.Start;

import java.io.*;
import screens.*;
import main.Main;

public class ButtonHandler implements ActionListener {

	private JButton start;
	private JButton exit;
	
	public ButtonHandler (JButton start, JButton exit) {
		this.start = start;
		this.exit = exit;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			try{
				Start.start();
				JPanel start = new StartScreen();
				Main.window.addNewPanel(start);
			} catch (IOException exc){
				exc.getMessage();
			}
		} else {
			Main.window.dispose();
		}
	}

}
