/*
This program demonstrates the different capabilities of the math class in java.
© 2014 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import java.util.Scanner;
import java.lang.Math;

public class Arithmetic {

	public static void main(String[] args) {
		int number;
		int number2;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Pick a number.");
		number = keyboard.nextInt();
		System.out.println("Pick another number.");
		number2 = keyboard.nextInt();
		int sum = number + number2;
		int difference = number - number2;
		int average = (number + number2) / 2;
		System.out.println("Sum: " + sum);
		System.out.println("Difference: " + difference);
		System.out.println("Average: " + average);
		System.out.print("Absolute value: " + Math.abs(number) + ", ");
		System.out.println(Math.abs(number2));
		System.out.print("To the fourth power: " + Math.pow(number, 4) + ", ");
		System.out.println(Math.pow(number2, 4));
		System.out.print("Square rooted: " + Math.sqrt(number) + ", ");
		System.out.println(Math.sqrt(number2));
		System.out.println("Maximum value: " + Math.max(number,  number2));
		System.out.println("Minimum value: " + Math.min(number, number2));
		System.out.println("Increment of 1: " + ++number);
		System.out.println("Decrement of 1: " + --number2);
	

	}

}
