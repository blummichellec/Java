/*
Performs triangle calculations.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import java.util.Scanner;
import java.lang.Math;

public class RightTriangles {
	private static Scanner key;
	static int[] tri1 = new int[3];
	static int[] tri2 = new int[3];

	public static void main(String[] args) {

		key = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			tri1[i] = key.nextInt();
			tri2[i] = key.nextInt();
		}
		for (int b = 0; b < 3; b++) {
			int hyp, perim;
			hyp = (int) Math.sqrt(Math.pow(tri2[b], 2) + Math.pow(tri1[b], 2));
			perim = tri1[b] + tri2[b] + hyp;
			System.out.println(hyp + " " + perim + " ");
		}
	}

}
