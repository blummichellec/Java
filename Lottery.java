/*
Shows how Java's random function works.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import java.util.Random;

public class Lottery {
	private static final int NUM_DIGITS = 3;
	private static int[] lotteryNumbers = new int[NUM_DIGITS];

	public Lottery() {
		Random rand = new Random();
		for (int i = 0; i < NUM_DIGITS; i++) {
			lotteryNumbers[i] = rand.nextInt(3);
		}
	}

	public static void numMatching(int[] myNumbers) {
		int num = 0;
		for (int i = 0; i < NUM_DIGITS; i++) {
			if (myNumbers[i] == lotteryNumbers[i]) {
				num++;
			}
		}
		if (num == 0)
		{
			System.out.println("You got no numbers correct.");
		}
		if (num == 1)
		{
			System.out.println("You got one number correct.");
		}
		if (num == 2)
		{
			System.out.println("You got two number correct.");
		}
		if (num == 3)
		{
			System.out.println("You won!");
		}
	}

	public static int[] getLotteryNumbers() {
		return lotteryNumbers;
	}
}

