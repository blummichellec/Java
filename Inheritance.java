
/*
Understanding the concept of inheritance.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

public class inheritance {
public static void makeCounts(int n)
{
	int[][] counts = new int [3][n];
	counts[0][0] = 0;
	counts [1][0] = 0;
	counts [2][0] = 1;
	for (int k = 1; k < n; k++)
	{
		counts[0][k] = counts [0][k-1] + counts [1][k-1];
		counts [1][k] = counts [1][k-1] + counts [0][k-1] + counts [2][k-1];
		counts[2][k] = counts [2][k-1] + counts[1][k-1];
	}
	System.out.println(counts);
	}
	public static void main(String[] args) {
		makeCounts(5);
		}
		}
