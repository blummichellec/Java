/**
 * Michelle Blum
 * December 2nd, 2014
 */

import java.util.Random;
import java.util.Scanner;

public class Random {

	public static void main(String[] args) {

		int user,var;
		Scanner keyboard = new Scanner(System.in);
		Random randomNumbers = new Random();
		var = randomNumbers.nextInt(100);
		
System.out.println("Please enter a number between 0 and 99.");
user = keyboard.nextInt();

while (!(var == user))
{
	if (var < user)
	{
		System.out.println("Too high, try again.");
		user = keyboard.nextInt();
				
	}
	else if (var > user)
	{
		System.out.println("Too low, try again.");
		user = keyboard.nextInt();
	}
}

	}

	}

}
