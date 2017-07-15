import java.util.Scanner;
public class Packet {

	public static void main(String[] args) {

int miles, gallons;
Scanner keyboard = new Scanner(System.in);
System.out.println("How many miles have you driven?");
miles = keyboard.nextInt();
System.out.println("How many gallons of gas have you used?");
gallons = keyboard.nextInt();
int MPG = miles/gallons;
System.out.println("Miles Per Gallon: " + MPG);
	}

}
