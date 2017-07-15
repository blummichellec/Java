/*
Finding uses for other Java libraries.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Problem2 {

	public static void main(String[] args) {

		int[] a = { 5, 7, 3, 1, 9 };
		Arrays.sort(a);
		int amount = Math.round(a.length / 2);
		System.out.println((a[amount - 1]));

	}

}
