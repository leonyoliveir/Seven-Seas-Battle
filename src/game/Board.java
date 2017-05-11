package game;

import java.util.Random;
import buttons.*;
import main.Main;
import screens.*;

import javax.swing.*;

import box.LogBookBox;
import box.ShotsOnWaterBox;
import box.InfoBox;

import java.io.*;
import music.*;
import screens.StartScreen;

public class Board {
	public static int[][] gameboard;
	public static Ship[] ships;
	public static int shotsInWater;
	public static ImageIcon imgSWater;
	public static ImageIcon imgHit;
	public static File sndHit;
	public static File sndWater;
	
	//Constructor
	protected Board(){
		gameboard = new int[10][10];
		ships = new Ship[5];
		shotsInWater = 0;
		imgHit = new ImageIcon("src/images/hit.jpg"); 
		imgSWater = new ImageIcon("src/images/miss.jpg");
		sndHit = new File("src/sounds/boom.wav");
		sndWater = new File("src/sounds/splash.wav");
	}
	
	// Initialize the board
	protected void initializeBoard(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				gameboard[i][j] = -1;
			}
		}
	}
	
	// Position the ships
	protected void positionShips(){
		int col = 0, row = 0;
		Random rdm = new Random();
		
		for(int k = 0; k < 5; k++){
			switch(k){ // Which ship will be initialized and definition of random numbers to row and column
			case 0:
				ships[k] = new Minesweeper();
				col = rdm.nextInt(9);
				row = rdm.nextInt(10);
				break;
				
			case 1:
				ships[k] = new Frigate();
				col = rdm.nextInt(8);
				row = rdm.nextInt(10);
				break;
				
			case 2:
				ships[k] = new Submarine();
				col = rdm.nextInt(8);
				row = rdm.nextInt(10);
				break;
				
			case 3:
				ships[k] = new Battleship();
				col = rdm.nextInt(7);
				row = rdm.nextInt(10);
				break;
				
			case 4:
				ships[k] = new Aircraftcarrier();
				col = rdm.nextInt(6);
				row = rdm.nextInt(10);
				break;
				
			default:
				break;
			}
			
			if(ships[k].hasSpace(gameboard, col, row)){ // Verify if the row and column are valid 
				ships[k].position(gameboard, col, row);
			} 
			else { // If not, decreases k so the ship will be accessed again
				k--;
			}
		}
	}
	
	// Processor of shots
	public static void shot(GameButton button) throws IOException {
		int count = 0;
		for (int i = 0; i < 5; i++){
			if(ships[i].test()){
				count++;
			}
		}
		
		if(shotsInWater < 25 && count != 5){
			int row = button.getyCoordenade();
			int col = button.getxCoordenade();
			/* If the position in the matrix is set as 100 it've already been shot and it was a shot in water
			 * If not and is not -1 then it's a ship */
			if(gameboard[col][row] < 100 && gameboard[col][row] > -1){
				
				if(!ships[gameboard[col][row]].test()){ // Verify if the ship haven't already been sunk
					int first = ships[gameboard[col][row]].initialY;
					ships[gameboard[col][row]].shot(col-first); // If not it processes the shot
					Music.playWav(sndHit);
						
					if(!ships[gameboard[col][row]].test()) {
						ImageIcon icon = imgHit;
						button.setDisabledIcon(icon);
					} else {
						count++;
					}
				}
			}
			else{ // Shot in water. Sets the position to 100 to clarify it has been hit
				gameboard[col][row] = 100;
				shotsInWater++;
				
				LogBookBox.changeMessage("Shot in water!");
				ShotsOnWaterBox.changeMessage(shotsInWater + " of 25");
				
				Music.playWav(sndWater);
				
				ImageIcon icon = imgSWater;
				button.setDisabledIcon(icon);
			}
			
			if(count == 5){
				BoardHandler.disableAll();
				endingScreen("src/images/youwon.jpg");
			}
			
			if(shotsInWater == 25){
				BoardHandler.disableAll();
				endingScreen("src/images/youlose.jpg");
			}
		}
	}
	
	private static void endingScreen(String screen) {
		try{
			JPanel endGame = new MainScreen(screen,"src/images/restart.jpg");
			Main.window.addNewPanel(endGame);
		} catch (IOException exc){
			exc.getMessage();
		}
	}
}
