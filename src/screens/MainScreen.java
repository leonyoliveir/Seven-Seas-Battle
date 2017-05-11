package screens;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import buttons.*;
import buttons.ActionButton;

public class MainScreen extends JPanel {
	
	private BufferedImage img = null;    
    private int x = 0;  
    private int y = 0;
    private ButtonHandler hand;
    
    public MainScreen(String addressBackground, String buttonAddress) throws IOException {  
        this.img = ImageIO.read(new File(addressBackground));
        this.setLayout(null);
        JButton start = new ActionButton(buttonAddress);
        start.setLocation(620, 350);
        JButton exit = new ActionButton("src/images/exit.jpg");
        exit.setLocation(620, 450);
    	this.hand = new ButtonHandler(start, exit);
    	start.addActionListener(hand);
    	exit.addActionListener(hand);
    	this.add(start);
    	this.add(exit);
    }  
    
    @Override  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, x, y, this.getWidth(), this.getHeight(), this);  
        gr.dispose();     
    }
    
}
