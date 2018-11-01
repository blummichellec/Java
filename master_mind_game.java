/*
 * Michelle Blum
 * Professor Rao
 * Data Structures and Algorithms using Java
 * Mid-term Project
 * 13 October 2018
 */

import java.util.InputMismatchException; //Used to catch non-digit input by user
import java.util.Random; //Used to generate random digits for code
import java.util.Scanner; //Used for user input

public class master_mind_game {
	private static final int NUM_DIGITS = 4; //length of code
	private static int program_count = 0; //Number of guesses
	//NOTE: Static array automatically initializes elements as 0
	private static int[] codemaker = new int[NUM_DIGITS]; //create array to hold 4-digit code from computer
	private static int[] userinput = new int[NUM_DIGITS]; //create array to hold 4-digit code from user
	
	//This method selects a random number between 0 and 9
	//The code digits will always range from 1 to 9 because the initial 0s get replaced
	public int generate_random_number() {
	
		Random rand = new Random();
		int array_attempt = rand.nextInt(9);
		return array_attempt;	
	}
	
	//This method checks if current codemaker array contains the new random number
	//If it does, the loop is exited
	//If it does not, the number replaces the first 0 found in the array
	public int[] add_to_array() {
		
		//Loop used to compare generated random number to each element in array
		for (int i = 0; i < NUM_DIGITS; i++) {
			int test = generate_random_number();
			for (int j = 0; j < NUM_DIGITS; j++) {
				if (codemaker[j] == test) {
					add_to_array();
				}
			}
			
			//Place random number into first available space
			if (indexOfFirstZero() != -1)
				codemaker[indexOfFirstZero()] = test;
			//When no 0s present, code maker digits found
			//Call the userGuess module
			else {
				userGuess();
			}
		}
		//Return the computers code
		return codemaker;
		}
	
	//This method finds the location of the first zero in the array
	//Leads to verification of array completion by returning -1 when no 0s found
	public int indexOfFirstZero() {
		for (int i = 0; i < NUM_DIGITS; i++)
			if(codemaker[i] == 0)
				return i;
		return -1;
	}
	
	//This method retrieves the user guess
	//Program checks for non-numeric data, too many numbers entered, too few numbers entered, and for
	//duplicate digits
	//Errors in entering data do not count towards 10 guess attempts
	//Method also creates array from user input
	//Program counter is monitored here for display purposes
	public int[] userGuess() {
		
		
		//Stop the program after 10 guesses and display answer
		if (program_count == 10) {
			System.out.println("Game over.");
			System.out.println("Answer: ");
			for (int i = 1; i < NUM_DIGITS; i++)
				System.out.print(codemaker[i]);
			System.exit(0);
		}
		
		
		//Display the hints or feedback at certain program counter values
		if (program_count == 2)
			System.out.println("# of digits below 6: " + hints());
		if (program_count == 4)
			System.out.println("# of even digits: " + hints());
		if (program_count == 6)
			System.out.println("First digit: " + hints());
		if (program_count == 8)
			System.out.println("Last digit: " + hints());
		
		
		//User input
		Scanner keyboard = new Scanner(System.in);
		int guess = 0;
		
		System.out.println("Guess #" + (program_count+1) + ". Enter a 4 digit number. No digit should appear within the number twice.");
		//Tests for numerical data
		try {guess = keyboard.nextInt();} catch(InputMismatchException e) { 
			System.out.println("Please enter numerical data."); 
			userGuess();
		}
		
		//Parse data into individual digits
		//Temp variable used to test for number of digits
		int temp = NUM_DIGITS-1;
		int temp2 = guess;
		//Modulus begins from last digit in integer
		while (guess > 0) {
			for (int i = 0; i < 4; i++)
				if (temp < 0) {
					System.out.println("You have entered greater than 4 digits as your guess.");
					userGuess();
				}
				userinput[temp] = guess % 10;
				guess = guess/10;
				temp--;
		}
		
		if (temp != -1) {
			System.out.println("You have entered fewer than 4 digits.");
			userGuess();
		}
		guess = temp2;
		//Checking for duplicates
		int seen = 0;
		for (int i = 0; i < NUM_DIGITS; i++) {
			int curDigit = (int)(guess / Math.pow(10, i))%10;
			int seen_compare = (int)Math.pow(2, curDigit);
			if ((seen & seen_compare) > 0) {
				System.out.println("You have entered a number with duplicate digits.");
				userGuess();
			}
			seen = seen | seen_compare;
		}
		//Call the compare method after user input verified as acceptable
		compare();
		return userinput;
	}
	
	//This method compares the user input to the computer's answer
	public int compare() {
		
		//Output string of Ws and Bs begins as empty
		String result = "";
		
		//Conditions for displaying B vs displaying W vs displaying nothing
		for (int i = 0; i < NUM_DIGITS; i++) {
			if (userinput[i] == codemaker[i])
				result += "B";
			for (int j = 0; j < NUM_DIGITS; j++) {
				if (userinput[j] == codemaker[i]) {
					if (i != j)
						result += "W"; 
				}
			}
		}
		
		//Winning condition. Program execution ends.
		if (result.contains("BBBB") ) {
			System.out.println("You win!");
			System.exit(0);
		}
		//Continue guessing
		else {
			System.out.println("Your current guess yields: " + result + ".");
			program_count++;
			userGuess();
		}
		
		//Program count increments when user's guess confirmed as incorrect
		return program_count;
	}
	
	//This module generates the information needed for the 4 hints.
	//The first hint is given after the second guess, the second hint is given after the fourth guess,
	//and the third hint is given after the eighth guess.
	public int hints() {
		
		//Hint #1: Number less than 6.
		//Hint #2: Number of even numbers.
		//Hint #3: The first number is -.
		//Hint #4: The last number is -.
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < NUM_DIGITS; i++) {
			if (codemaker[i] < 6)
				count1++;
			if ((codemaker[i]%2) == 0)
				count2++;
		}
		
		if (program_count == 2)
			return count1;
		if (program_count == 4)
			return count2;
		if (program_count == 6)
			return codemaker[0];
		if (program_count == 8)
			return codemaker[NUM_DIGITS-1];
		return 0;
	}
			
//**END PROGRAM**//
}
