package homework2_OS;

import java.util.Scanner;

public class test {
    private static int Number_of_Cars;
    private static deadlock_process[] processes;
    public static semaphore[] semaphores;
    public static Logger logger = new Logger();
	private static Scanner scanner;

    public static void main(String[] args) {
        init();

        for (deadlock_process process : processes) {
            process.start();
        }

        try {
            Thread.sleep(20000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.flush();
        System.exit(0);
    }

    /* ***********************************************************************************************************
     * This function is the main function that is supposed to create a deadlock and fix the deadlock while using *
     * semaphores																								 *
     *************************************************************************************************************/
    private static void init() {		
        Number_of_Cars = getNumberOfCars();					//This acquires the number of cars in a line

        processes = new deadlock_process[Number_of_Cars];	//This creates the number of processes based on the number of cars
        semaphores = new semaphore[Number_of_Cars - 1];	  // This creates the number of semaphores based off the number of cars

        for (int i = 0; i < processes.length; i++) {	 //This creates the loop that creates the deadlock condition based on the number of processes
            processes[i] = new deadlock_process(i);
        }

        for (int i = 0; i < semaphores.length; i++) {	//This is the loop that generates the semaphores
            semaphores[i] = new semaphore(i);
        }

        int j = semaphores.length / 2;
        for (int i = 0; i < processes.length; i++) {
            processes[i].setCurrentSemaphore(semaphores[j]);
            if (i > 0 && i % 2 == 0) {
                j++;
            }
        }
    }
  
    /* *****************************************************************************************************************
     * This is the function that gets the number of car inputs from the user and takes care of any user error during   *
     * the inputing process  																						   *
     * *************************************************************************************************************** */
    private static int getNumberOfCars() {
        int Number_of_Cars = 0;

        while (Number_of_Cars == 0) {
            try {
            	Number_of_Cars = Integer.parseInt(getLine());

                if (Number_of_Cars < 1) {					
                    System.out.println("The number of cars should be a positive number.");
                    Number_of_Cars = 0;
                }
                else if (!isCorrectNumberofCars(Number_of_Cars)) {
                    System.out.println("The number of cars should be 2, 4, 8, 16...");
                    Number_of_Cars = 0;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("You should enter a number.");
            }
        }

        return Number_of_Cars;
    }

    private static boolean isCorrectNumberofCars(int Number_of_Cars) {
        while (Number_of_Cars % 2 == 0) {
        	Number_of_Cars /= 2;
        }

        if (Number_of_Cars != 1) {
            return false;
        }

        return true;
    }

    private static String getLine() {
        System.out.println("Please enter the number of cars: ");
        System.out.print(" > ");
        scanner = new Scanner(System.in);
		return scanner.nextLine();
    }
}