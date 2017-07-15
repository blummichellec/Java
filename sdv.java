import java.util.Scanner;
public class McCormickRainfall {
  
  
  public static void main(String[] args) { 
    
    int years, years2 = 1, month = 1;
    double rainfall, totalRainfall;
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Enter the years.");
    years = keyboard.nextInt();
    
    while (years < 1)
    {
       System.out.println("Enter the years.");
       years = keyboard.nextInt();
    }
    
    while (years > 0 )
    {
     while (month <= (years*2))
     {
       System.out.print("Enter the inches of rainfall.");
       System.out.print("Year: " + years2 + "Month: " + month);
       rainfall = keyboard.nextDouble();
       while (rainfall < 0)
       {
         System.out.print("Enter the inches of rainfall.");
         System.out.print("Year: " + years2 + "Month: " + month);
         rainfall = keyboard.nextDouble();
       }
       while (rainfall >0)
       {
         System.out.print("Enter the inches of rainfall.");
         System.out.print("Year: " + years2 + "Month: " + month);
         rainfall = keyboard.nextDouble();
         month++;
         totalRainfall += rainfall;
       }
     }
     years--;
     years2++;
    }
    System.out.println(years2 *12);
    System.out.println(totalRainfall);
    System.out.println(totalRainfall/(years2*12));
  
         
         
  }
  
  
}

