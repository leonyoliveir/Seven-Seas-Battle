package box;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

import javax.swing.*;

public class InfoBox extends JPanel {
	
	private BufferedImage img = null;    
    private int x = 0;  
    private int y = 0;
	
	public InfoBox(String address) throws IOException {
		this.img = ImageIO.read(new File(address));
		this.setSize(400, 320);
        this.setLayout(null);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE.brighter()));
	}
	
	@Override  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, x, y, this.getWidth(), this.getHeight(), this);  
        gr.dispose();  
    }
	
}
