/**
 * Michelle Blum
 * January 12th, 2015
 */

import java.text.DecimalFormat;

public class Celcius {

	public static void main(String[] args) {
		
		for (int f = 1; f <= 20; f++)
		{
		String C = celcius(f);
		System.out.println(f + "\t\t\t\t" + C);
		}

	}

	public static String celcius(int f)
	{
		DecimalFormat degrees = new DecimalFormat("0.00");
		String C = degrees.format((f-32.0)*(5.0/9.0));
		return C;
	}
}
