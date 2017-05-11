package box;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShotsOnWaterBox extends JPanel {

	private BufferedImage img = null;    
    private int x = 0;  
    private int y = 0;
    private static JTextArea shots;
    
	public ShotsOnWaterBox() throws IOException {
		this.img = ImageIO.read(new File("src/images/shotswater.jpg"));
		this.setSize(400, 100);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE.brighter()));
        this.setLayout(null);
        shots = new JTextArea();
        shots.setWrapStyleWord(true);
        changeMessage("0 of 25");
        shots.setFont(new Font("Arial", Font.BOLD, 18));
        shots.setLocation(162, 45);
        shots.setSize(75, 30);
        shots.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE.brighter()));
        shots.setBackground(Color.GRAY.brighter());
        shots.setEditable(false);
        this.add(shots);
	}
	
	public static void changeMessage(String message) {
		shots.setText(message);
	}
	
	@Override  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, x, y, this.getWidth(), this.getHeight(), this);  
        gr.dispose();  
    }
	
}
