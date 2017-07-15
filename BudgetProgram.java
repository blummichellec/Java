/**
 * Michelle Blum
 * December 12th, 2014
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class BudgetProgram {
     public static void main(String[] args) {

		double budget, percent;
		int num, count = 0;
   Scanner snowman = new Scanner(System.in);
   DecimalFormat money = new DecimalFormat("$0.00");
   
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
	  if (count == 100)
	  {
	    for (int num3 = 1; num >= num3; num3++)
	    {
	  	  System.out.println("Amount you can spend on person number " + num3 + ": " + (money.format(budget * (percent/100))));
	    }
	  }
	   if ((count > 100) || (percent <= 0))
	   {
		   System.out.println("Please reenter your percentages.");
		   num2 = 0;
		   count = 0;
	   }
}
     }
}
