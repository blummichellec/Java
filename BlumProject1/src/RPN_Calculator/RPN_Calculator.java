/*
 *Project #1
 *Data Structures and Algorithms Using Java
 *
 * Submitted by: Michelle Blum
 * Submitted to: Dr Rao
 * 7 October 2018
 * 
 * Reverse Polish Notation (RPN) Calculator
 */

/*
 * Instructions:
 * The user enters a string in Reverse Polish Notation. The program will then 
 * calculate the answer to the problem presented by the string input using the 
 * Stack data structure.
 */

package RPN_Calculator;

import java.util.Stack; //Used to create the stack data structure
import java.util.Scanner; //Used for user input

public class RPN_Calculator {
	
	//Creating a Stack
	static Stack<String> stackForNums = new Stack<>();
	//Variable to hold the final answer
	static double answer = 0;
	
	public static void main(String[] args) {
		
		//Get the user input
		int count = 0;
		String for_calculation;
		/* This for_calculation2 variable will hold the next token in the string (2 tokens read per loop)
		*This is because the while loop needs to know when to end without knowing the length of the string
		*Length of string unknown because using next method, not nextLine
		*The loop awaits additional scanner input from the user when should be false because no condition to close scanner
		*The second variable will know if the while loop condition should be false before the loop is actually entered */
		String for_calculation2;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a string in RPN form using white space as a token delimiter.");
		//Java strings are not terminated by any specific character, so selected # to terminate for the purpose of exiting the loop
		System.out.println("Terminate your string with \" #\".");
		
		//Loop to run through each token in string using Scanner's next() method
		while(keyboard.hasNext()) {
			
			for_calculation = keyboard.next();
			for_calculation2 = keyboard.next();
			
			//Calling the method "calculation"
			count++;
			calculation(for_calculation, count);
			count++;
			calculation(for_calculation2, count);	
		}
		//Close the keyboard to prevent leaking of resources
		keyboard.close();
	}	

	//A separate method was created for the calculation because needed twice (once for for_calculation and again for for_calculation2)
	public static int calculation(String for_calculation, int count) {	
		
		//Ending condition
		if (for_calculation.equals("#")) {
			//Print final result
			System.out.println("Answer: " + answer);
			System.exit(0); }
		
		//Validation: Is the token an integer?
		boolean isValidDouble = false;
		try {
			Double.parseDouble(for_calculation);
			isValidDouble = true; }
		
		catch (NumberFormatException ex) {
			
			//for_calculation is not a number
			//Validation: Is the token an operand?
			//Which operand?
			int operand = 0;
			if (for_calculation.equals("+") || for_calculation.equals("-")
					|| for_calculation.equals("*") || for_calculation.equals("/")) {
				String topNum1 = stackForNums.pop();
				String topNum2 = stackForNums.pop(); 
				if (for_calculation.equals("+")) operand = 1;
				if (for_calculation.equals("-")) operand = 2;
				if (for_calculation.equals("*")) operand = 3;
				if (for_calculation.equals("/")) operand = 4;
				
				//Perform the operation
				if (operand == 1) answer = Double.parseDouble(topNum2) + Double.parseDouble(topNum1);
				if (operand == 2) answer = Double.parseDouble(topNum2) - Double.parseDouble(topNum1);
				if (operand == 3) answer = Double.parseDouble(topNum2) * Double.parseDouble(topNum1);
				if (operand == 4) answer = Double.parseDouble(topNum2) / Double.parseDouble(topNum1);
				String answerAsString = Double.toString(answer);
				stackForNums.push(answerAsString); }
			
			//Error message presented when invalid input entered
			else {
				System.out.println("The token at location " + count + " of your input is neither a number or an operator.");
				System.exit(1); } //non-zero status code used to indicate abnormal termination (due to error)
		}
		
		//Push number onto stack if integer
		if (isValidDouble == true) {
			stackForNums.push(for_calculation); }
		
		return 0; //method must return integer
	}
}
