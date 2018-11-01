/*
 * Michelle Blum
 * Professor Rao
 * Data Structures and Algorithms Using Java
 * Mid-term Project
 * 13 October 2018
 */

/* Master Mind Game - The Code Maker
 * 
 * Instructions:
 * 
 * The computer generates a random 4 digit code. No two digits within this code can be the same value.
 * The player needs to guess this 4 digit code. There are 10 permitted attempts before the game ends.
 * Feedback (hints) are given to the player after guesses 2, 4, 6, and 8.
 * Good luck!
 */

//This class contains the main module. It calls the master_mind_game class.
public class runner {
	
	public static void main(String[] args) {
		
		master_mind_game game_results = new master_mind_game();
		//add_to_array is the method within the master_mind_game class that 
		//begins the sequence of events for the game
		game_results.add_to_array();
	}
		 
}
