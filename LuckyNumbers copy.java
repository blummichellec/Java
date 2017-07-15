import java.util.Scanner;

public class LuckyNumbers {

	private static Scanner key;

	public static void main(String[] args) {

		key = new Scanner(System.in);
		int number, digit6, digit5, digit4, digit3, digit2, digit1;
		number = key.nextInt();
		digit6 = number % 10;
		digit5 = number % 100 / 10;
		digit4 = number % 1000 / 100;
		digit3 = number % 10000 / 1000;
		digit2 = number % 100000 / 10000;
		digit1 = number % 1000000 / 100000;

		if ((digit6 + digit5 + digit4) == (digit3 + digit2 + digit1)) {
			System.out.print("lucky");
		} else {
			System.out.print("not lucky");
		}

	}

}
