import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuickSum {

	private static Scanner key;

	public static void main(String[] args) {

		key = new Scanner(System.in);
		String input = key.nextLine();
		Pattern pat = Pattern.compile("[:?!@#$%^&*()]");
		Matcher m = pat.matcher(input);
		char arr[] = input.toCharArray();
		int max = 255;
		int[] position = new int[max];
		position[0] = 0;
		for (int i = 1; i <= input.length(); i++) {
			if (arr[i - 1] == 'A') {
				position[i] = i * 1;
			} else if (arr[i - 1] == 'B') {
				position[i] = i * 2;
			} else if (arr[i - 1] == 'C') {
				position[i] = i * 3;
			} else if (arr[i - 1] == 'D') {
				position[i] = i * 4;
			} else if (arr[i - 1] == 'E') {
				position[i] = i * 5;
			} else if (arr[i - 1] == 'F') {
				position[i] = i * 6;
			} else if (arr[i - 1] == 'G') {
				position[i] = i * 7;
			} else if (arr[i - 1] == 'H') {
				position[i] = i * 8;
			} else if (arr[i - 1] == 'I') {
				position[i] = i * 9;
			} else if (arr[i - 1] == 'J') {
				position[i] = i * 10;
			} else if (arr[i - 1] == 'K') {
				position[i] = i * 11;
			} else if (arr[i - 1] == 'L') {
				position[i] = i * 12;
			} else if (arr[i - 1] == 'M') {
				position[i] = i * 13;
			} else if (arr[i - 1] == 'N') {
				position[i] = i * 14;
			} else if (arr[i - 1] == 'O') {
				position[i] = i * 15;
			} else if (arr[i - 1] == 'P') {
				position[i] = i * 16;
			} else if (arr[i - 1] == 'Q') {
				position[i] = i * 17;
			} else if (arr[i - 1] == 'R') {
				position[i] = i * 18;
			} else if (arr[i - 1] == 'S') {
				position[i] = i * 19;
			} else if (arr[i - 1] == 'T') {
				position[i] = i * 20;
			} else if (arr[i - 1] == 'U') {
				position[i] = i * 21;
			} else if (arr[i - 1] == 'V') {
				position[i] = i * 22;
			} else if (arr[i - 1] == 'W') {
				position[i] = i * 23;
			} else if (arr[i - 1] == 'X') {
				position[i] = i * 24;
			} else if (arr[i - 1] == 'Y') {
				position[i] = i * 25;
			} else if (arr[i - 1] == 'Z') {
				position[i] = i * 26;
			}
		}
		if (input != input.toUpperCase() || m.find()) {
			System.out.println("");
		} else {
			int sum = 0;
			for (int i : position)
				sum += i;
			System.out.println(sum);
		}

	}
}
