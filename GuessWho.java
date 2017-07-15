/**
 * 
 * GUESS WHO FINAL
 */
import java.util.Random;
import java.util.Scanner;
public class GuessWho {
  
  private String[] david = new String[4];
  private String[] carl = new String[4];
  private String[] sabrina = new String[4];
  private String[] lucy = new String[4];
  private String[] jasmine = new String[4];
  private String[] traits = new String[4];
  private Scanner keyboard;
  private String person;
  
  public GuessWho() 
  {
    david[0] = "Gender: boy";
    david[1] = "Eye Color: brown";
    david[2] = "Hair Length: short";
    david[3] = "Glasses: no";
    carl[0] = "Gender: boy";
    carl[1] = "Eye Color: blue";
    carl[2] = "Hair Length: short";
    carl[3] = "Glasses: yes";
    sabrina[0] = "Gender: girl";
    sabrina[1] = "Eye Color: green";
    sabrina[2] = "Hair Length: long";
    sabrina[3] = "Glasses: no";
    lucy[0] = "Gender: girl";
    lucy[1] = "Eye Color: brown";
    lucy[2] = "Hair Length: short";
    lucy[3] = "Glasses: yes";
    jasmine[0] = "Gender: girl";
    jasmine[1] = "Eye Color: blue";
    jasmine[2] = "Hair Length: long";
    jasmine[3] = "Glasses: no";
  }
  
  public void display()
  {
    System.out.println("DAVID:");
    for( int i = 0; i < david.length; i++)
    {
      System.out.println("\t" + david[i]);
    }
    System.out.println("CARL:");
    for( int i = 0; i < carl.length; i++)
    {
      System.out.println("\t" + carl[i]);
    }System.out.println("SABRINA:");
    for( int i = 0; i < sabrina.length; i++)
    {
      System.out.println("\t" + sabrina[i]);
    }System.out.println("LUCY:");
    for( int i = 0; i < lucy.length; i++)
    {
      System.out.println("\t" + lucy[i]);
    }System.out.println("JASMINE:");
    for( int i = 0; i < jasmine.length; i++)
    {
      System.out.println("\t" + jasmine[i]);
    }
  }
  
  public String computerSelection()
  {
    String[] names = { "david", "carl", "sabrina", "lucy", "jasmine"};
    person = (names[new Random().nextInt(names.length)]);
    if (person.equals(names[0]))
    {
      for (int i = 0; i < david.length; i++)
      {
        traits[i] = david[i];
      }
    }
    else if (person.equals(names[1]))
    {
      for (int i = 0; i < carl.length; i++)
      {
        traits[i] = carl[i];
      }
    }
    else if (person.equals(names[2]))
    {
      for (int i = 0; i < sabrina.length; i++)
      {
        traits[i] = sabrina[i];
      }
    }
    else if (person.equals(names[3]))
    {
      for (int i = 0; i < lucy.length; i++)
      {
        traits[i] = lucy[i];
      }
    }
    else if (person.equals(names[4]))
    {
      for (int i = 0; i < jasmine.length; i++)
      {
        traits[i] = jasmine[i];
      }
    }
    return person;
}
  
  public void hint()
  {
    String response1, response;
    keyboard = new Scanner(System.in);
    System.out.println("Would you like a hint?");
    response1 = keyboard.nextLine();
    response = response1.toLowerCase();
    if (response.equals("yes"))
    {
      String clue = (traits[new Random().nextInt(traits.length)]);
      System.out.println(clue);
      hint();
    }
    else if (response.equals("no"))
    {
      String guess, guess1;
      System.out.println("Enter your guess.");
      guess1 = keyboard.nextLine();
      guess = guess1.toLowerCase();
      if (guess.equals(person))
      {
        System.out.println("You win!");
      }
      else
      {
        System.out.println("Try again.");
        hint();        
      }
    }
    else 
    {
      hint();
    }

}
}
