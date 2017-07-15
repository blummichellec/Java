import java.util.Scanner;
public class Discounts {

	public static void main(String[] args) {
		int numSoftware;
 Scanner keyboard = new Scanner(System.in);
 System.out.println("How many pieces of software are you purchasing?");
 numSoftware = keyboard.nextInt();
        double software = 99.00;
 if (numSoftware >= 10 && numSoftware <= 19)
 {
	 double discount = .20;
	 double price = ((discount * numSoftware) + software);
	 System.out.println("The discount amount is: $" + discount + ".");
	 System.out.println("The price amount is: $" + price + ".");
 }
 else 
	 if (numSoftware >= 20 && numSoftware <= 49)
	 {
		 double discount = .30;
		 double price = ((discount * numSoftware) + software);
		 System.out.println("The discount amount is: $" + discount + ".");
		 System.out.println("The price amount is: $" + price + ".");
	 }
	 else 
		 if (numSoftware >= 50 && numSoftware <= 99)
		 {
			 double discount = .40;
			 double price = ((discount * numSoftware) + software);
			 System.out.println("The discount amount is: $" + discount + ".");
			 System.out.println("The price amount is: $" + price + ".");
		 }
		 else 
			 if (numSoftware >= 100)
			 {
				 double discount = .50;
				 double price = ((discount * numSoftware) + software);
				 System.out.println("The discount amount is: $" + discount + ".");
				 System.out.println("The price amount is: $" + price + ".");
			 }
 

	}

}
