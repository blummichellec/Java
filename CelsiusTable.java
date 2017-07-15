/**
 * Michelle Blum
 * January 12th, 2015
 */

import java.text.DecimalFormat;

public class CelsiusTable {

	public static void main(String[] args) {
		
		System.out.println("\tFarenheitCelsius");
		System.out.println("===============================");
		
		for (int f = 1; f <= 20; f++)
		{
		String C = celsius(f);
		System.out.println(f + "\t\t\t" + C);
		}

	}

	public static String celsius(int f)
	{
		DecimalFormat degrees = new DecimalFormat("0.00");
		String C = degrees.format((f-32.0)*(5.0/9.0));
		return C;
	}
}
