package box;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LogBookBox extends JPanel {

	private BufferedImage img = null;    
    private int x = 0;  
    private int y = 0;
    private static JTextArea logbook;
	
	public LogBookBox() throws IOException {
		this.img = ImageIO.read(new File("src/images/logbook.jpg"));
		this.setSize(400, 150);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLUE.brighter()));
        this.setLayout(null);
        logbook = new JTextArea();
        String message = "Let's start the war, soldier!\nYou have to hit five ships to win!\n";
        changeMessage(message);
        logbook.setWrapStyleWord(true);
        logbook.setLocation(27, 65);
        logbook.setSize(350, 70);
        logbook.setFont(new Font("Arial", Font.BOLD, 18));
        logbook.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE.brighter()));
        logbook.setBackground(Color.GRAY.brighter());
        logbook.setEditable(false);
        this.add(logbook);
	}
	
	public static void changeMessage(String message) {
		logbook.setText(message);
	}
	
	@Override  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, x, y, this.getWidth(), this.getHeight(), this);  
        gr.dispose();  
    }
	
}
