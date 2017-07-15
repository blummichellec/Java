import java.util.Scanner;
public class RunLottery {

	public static void main(String[] args) {
		
		Lottery lottery = new Lottery();
		Lottery.getLotteryNumbers();
		final int NUM_DIGITS = 3;
		int [] myNumbers = new int [NUM_DIGITS];
		Scanner key = new Scanner(System.in);
		
		System.out.println("Enter the first number.");
		myNumbers[0] = key.nextInt();
		while (myNumbers[0] < 0 || myNumbers[0] >3)
		{
			System.out.println("Enter a number between 0 and 3.");
			myNumbers[0] = key.nextInt();
		}
		System.out.println("Enter the second number.");
		myNumbers[1] = key.nextInt();
		while (myNumbers[1] < 0 || myNumbers[1] >3)
		{
			System.out.println("Enter a number between 0 and 3.");
			myNumbers[1] = key.nextInt();
		}
		System.out.println("Enter the third number.");
		myNumbers[2] = key.nextInt();
		while (myNumbers[2] < 0 || myNumbers[2] >3)
		{
			System.out.println("Enter a number between 0 and 3.");
			myNumbers[2] = key.nextInt();
		}
		Lottery.numMatching(myNumbers); 
		
			
		

	}

}
