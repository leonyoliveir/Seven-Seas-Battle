package main;

import javax.swing.*;
import java.io.*;

public class Window extends JFrame {
	
	public Window() throws IOException {
        this.setTitle("Seven Seas Battle"); 
        this.setSize(1360, 720);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	public void addNewPanel(JPanel panel) {
		this.getContentPane().removeAll();
    	this.add(panel);
    	this.setVisible(true);
	}
	
}
