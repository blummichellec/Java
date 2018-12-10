/**
 * Submitted by: Michelle Blum
 * Submitted to: Dr Rao
 * 
 * Object Oriented Programming and Data Structures
 * 30 November 2018
 * 
 * Goal:
 * 1 - Read 1131 words from text file into array list.
 * 2 - Use array list to create an unbalanced BST.
 * 3 - Time how long it takes to search this array
 * 		list (perform linear search). 
 * 4 - Balance the BST.
 * 5 - Time how long it takes to search through this
 * 		balanced tree for a user inputed word.
 * Purpose: 
 * See how balancing the tree improves efficiency!
 * 
 * Note:
 * Error Handling:
 * File not found displays appropriate error.
 * Check if provided list is in alphabetical order.
 * Converts user input to lower case text.
 * 
 **/

package BlumBalanceBinaryTree;

import java.io.*; //For reading from text file
import java.util.ArrayList; //needed to use array list
import java.util.Scanner; //For user input (in this case, text file)
import java.time.Duration; //needed for timing purposes
import java.time.Instant; //needed for timing purposes

public class Runner {

	public static void main(String[] args) throws IOException {
		
		UserChoice Input = new UserChoice();
		TreeFunctions<String> tree = new TreeFunctions<String>();
		
		System.out.println("This program will search for a word in a given text file using"
				+ "\na balanced binary tree and an unbalanced binary tree.\n");
		System.out.println("Please enter the word that you would like to search for: ");
		
		//Accepts user input and searches tree
		//Input defined in User class
		Input.setInput();
		
		//Array list
		//Read words from text file into array list
		//Try to find the file
		//Buffered reader is faster than scanner
		BufferedReader buff = null;
		try {
			buff= new BufferedReader(new FileReader("RandomWords.txt"));
			String text = null;
			
			ArrayList<String> search = new ArrayList<String>();
			
			while((text = buff.readLine()) != null) {
				//Crate string array list for linear search
				search.add(text);
				//inserting the words into a node array list for the tree
				//Go to TreeFunctions.java file for method
				tree.TreeConvert(tree.insertword(text));	
			}
			
			
			//Verify that text file is in alphabetical order
			String previous = ""; // empty string: guaranteed to be less than or equal to any other

			for (final String current: search) {
			    if (current.compareTo(previous) < 0) {
			        System.out.println("Use a file with alphabetized words.");
			        System.exit(0);
			    }
			    previous = current;
			}
			
			//Use string array list to conduct the linear search
			tree.linearSearch(search,  Input.getInput());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Close buffered reader to account for resource leaks
		buff.close();
		
		//Time searching in balanced tree
		Instant start2 = Instant.now();
		TreeFunctions<String>.Node<String> find_word = tree.Treesearch(Input.getInput());
		Instant finish2 = Instant.now();
		long timeElapsed2 = Duration.between(start2, finish2).toNanos();
		
		if (find_word != null) {
			System.out.println("Balanced (in ns): " + timeElapsed2);
			System.out.println(find_word.getword() + " is in the text file."); }
		else
			System.out.println(Input.getInput()+" is not found in the text file, please try again.");
	}
}


//Uses Scanner to accept user input
//Called from main method
class UserChoice {

	
	private Scanner keyboard = new Scanner(System.in);
	private String Input;
	
	public void setInput() {
		Input =keyboard.nextLine();
		Input = Input.toLowerCase();
	
		keyboard.close();
	}
	
	public String getInput() {
		return Input;
	}
}

