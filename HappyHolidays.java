/**
 * Michelle Blum
 * December 12th, 2014
 *
 */

import java.util.Scanner;

public class HappyHolidays {
     public static void main(String[] args) {

		double budget, percent;
		int num, count = 0;
   Scanner snowman = new Scanner(System.in);
   
System.out.println("What is your budget for Christmas gifts?");
  budget = snowman.nextDouble();
  while (budget <= 0)
  {
	  System.out.println("Please enter your budget.");
	    budget = snowman.nextDouble();
  }
  
System.out.println("How many people are you going to buy for?");
  num = snowman.nextInt();
  while (num <= 0)
  {
	  System.out.println("Please enter the amount of people.");
	    num = snowman.nextInt();
  }
  
for (int num2 = 1; num >= num2; num2++)
{
	System.out.println("What percentage of your budget would you like to spend on this person " + num2 + "?");
	  percent = snowman.nextDouble();
	  count += percent;
	   if ((count > 100) || (percent <= 0))
	   {
		   System.out.println("Please reenter your percentages.");
		   num2 = 0;
		   count = 0;
	   }
}
if (count == 100)
{
	   System.out.println("You can spend this amount on each person.");
}
     }
}
