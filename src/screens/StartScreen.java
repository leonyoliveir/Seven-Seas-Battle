package screens;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import box.*;
import buttons.GameBoard;

import java.awt.*;

public class StartScreen extends JPanel {
	
	private BufferedImage img = null;    
    private int x = 0;  
    private int y = 0;
    
    public StartScreen() throws IOException {  
        this.img = ImageIO.read(new File("src/images/background.jpg"));
        this.setLayout(null);
        JPanel board = new GameBoard();
        board.setLocation(100, 80);
        JPanel box1 = new InfoBox("src/images/howtoplay.jpg");
        box1.setLocation(830, 320);
        JPanel box2 = new ShotsOnWaterBox();
        box2.setLocation(830, 200);
        JPanel box3 = new LogBookBox();
        box3.setLocation(830, 40);
        this.add(board);
        this.add(box1);
        this.add(box2);
        this.add(box3);
      
    }
    
    @Override  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, x, y, this.getWidth(), this.getHeight(), this);  
        gr.dispose();  
    }
	
}
