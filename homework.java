/** 
 * Michelle Blum
 * November 18th, 2014
 */

import java.util.Scanner;
public class homework {

	public static void main(String[] args) {
		int num;
		Scanner keyboard = new Scanner(System.in);
System.out.println("Please enter a number within the range of 10 to 24.");
num = keyboard.nextInt();
while ((num < 10) || (num > 24))
{
	System.out.println("That number is invalid. Please enter a number within the" +
"the range of 10 to 24.");
	num = keyboard.nextInt();
}
System.out.println("Thankyou.");

	
}
	}

