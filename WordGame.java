import java.util.Scanner;
public class WordGame {

	public static void main(String[] args) {
		String name, age, city, college, job, animal, pet;
		Scanner keyboard = new Scanner(System.in);
System.out.println("What is your name?");
name = keyboard.nextLine();
System.out.println("How old are you?");
age = keyboard.nextLine();
System.out.println("Where do you live?");
city = keyboard.nextLine();
System.out.println("Where do you want to go to college?");
college = keyboard.nextLine();
System.out.println("What do you want to do for a living?");
job = keyboard.nextLine();
System.out.println("What is your favorite type of animal?");
animal = keyboard.nextLine();
System.out.println("What would you name this animal?");
pet = keyboard.nextLine();
System.out.println("There was once a person named " + name + " who lived in " + city 
		            + ". At the age of " + age + ", " + name + " went to college at " +
		           college + ". " + name + " graduated and went to work as a " + job + ". Then, "
		            + name + " adopted a(n) " + animal + " named" + pet + 
		            ". They both lived happily ever after!"); 
	}

}
