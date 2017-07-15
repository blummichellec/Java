import java.util.Scanner;
public class TestingTesting {

	public static void main(String[] args) {
		
		String user; 
		Scanner key = new Scanner(System.in);
		System.out.println("Please enter a word:");
		user = key.nextLine();
		int i = 0;
		while (user.length() > i)
		  {
		  System.out.println(user.charAt(i));
		  i++;
		  }

	}

}
