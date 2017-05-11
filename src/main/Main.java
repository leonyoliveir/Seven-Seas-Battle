package main;

import java.io.*;
import javax.swing.*;
import screens.*;

public class Main {

	public static Window window;
	
	public static void main(String[] args) throws IOException{
		window = new Window();
		JPanel init = new MainScreen("src/images/startbackground.jpg", "src/images/start.jpg");
		window.addNewPanel(init);
	}

}
