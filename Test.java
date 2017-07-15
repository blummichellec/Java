import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		int inches = 0, months, years, count = 0;
		Scanner keyboard = new Scanner(System.in);
		
System.out.println("Please enter the number of years.");
years = keyboard.nextInt();

months = years *12;

while (years > 0)
{
	for (int num = 12; num > 0; num--)
	{
		System.out.println("Enter the number of inches.");
		inches = keyboard.nextInt();
		count += inches;
	}
	years--;
}
System.out.println(count);
	}

}
