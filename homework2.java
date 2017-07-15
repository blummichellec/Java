import java.util.Scanner;
public class homework2 {

	public static void main(String[] args) {
		String letter;
		Scanner keyboard = new Scanner(System.in);
		String letter2 = "Y", letter3 = "N", letter4 = "n", letter5 = "y";
System.out.println("Please enter either Y, y, N, or n.");
letter = keyboard.nextLine();
while ((letter.compareTo(letter2)) || (letter.compareTo(letter3)) || 
		(letter.compareTo(letter4)) || (letter.compareTo(letter5)))
{
	System.out.println("That letter is invalid. Please enter the letter 'n', 'y', 'N'," 
 + "or 'Y'.");
	letter = keyboard.nextLine();
}
System.out.println("Thankyou.");
}


	}

