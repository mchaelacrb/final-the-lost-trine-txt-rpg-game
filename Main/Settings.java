package Main;

import java.util.Scanner;
 
/**
         * A class settings serves the 
	 */
public class Settings {
	
	 private boolean isRunning;
	 String input;
	 boolean gameOver;
	 
	 static Scanner in = new Scanner(System.in);
	 
		public static void createNewGame() {
			Characters.characterCreation();
			Effects.delayPrint(60,"Welcome to the Game!");
			
		
	}
		
		
		
		
		
		
		
		public void startGame() {
	        isRunning = true;
	        // Initialize game state and display welcome message
	        // Set up any necessary objects or variables
	        // Enter the game loop
	        gameLoop();
	    }
	    
	    private void gameLoop() {
	        while (isRunning) {
	            // Display game prompt and get player input
	            input = getPlayerInput();
	            
	            // Process player input and update game state
	            processInput(input);
	            
	            // Check for game over conditions
	            if (isGameOver()) {
	                endGame();
	                break;
	            }
	            
	            // Display updated game state or message
	            displayGameState();
	        }
	    }
	    
	    private String getPlayerInput() {
	        // Code to get player input from the console or other sources
	        return input;
	    }
	    
	    private void processInput(String input) {
	        // Code to handle and interpret player input
	        // Update game state based on the input
	    }
	    
	    private boolean isGameOver() {
	        // Code to check if the game should end based on the game state
	        return gameOver;
	    }
	    
	    private void endGame() {
	        isRunning = false;
	        // Display game over message and final score or results
	        // Perform any necessary cleanup or save game state
	    }
	    
	    private void displayGameState() {
	        // Code to display the current game state or messages to the player
	    }


}
