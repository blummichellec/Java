/*
User inputs student information.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import java.util.Scanner;

public class Student  {
	private String firstName;
	private String lastName;
	private int ID, gRadeLevel;  
	private double gpa;
Scanner key = new Scanner(System.in);
	
	public Student() {
		firstName = "None";
		lastName = "None";
		ID++;
		gpa = 0.0;
		gRadeLevel = 0;
	}
	

    public Student(String firstName, String lastName, int gradeLevel, double GPA) {
System.out.println("What is your first name?");
        firstName = key.nextLine();
System.out.println("What is your last name?");
        lastName = key.nextLine();
System.out.println("What is your grade level?");
        gRadeLevel = key.nextInt();
        if (gRadeLevel < 0 || gRadeLevel > 12)
        {
        	gRadeLevel = 0;
        }
System.out.println("What is your GPA?");
        gpa = key.nextDouble();
        if (gpa < 0.0 || gpa > 4.5)
        {
        	gpa = 0.0;
        }
    }
    
String GPA = Double.toString(gpa);
String id = Integer.toString(ID);
String gradeLevel = Integer.toString(gRadeLevel);


	public String toString() {
		return lastName + ", " + firstName + "\nGPA:" + GPA + "\nGrade Level: " + gradeLevel +
				"id # " + id;
	}
	
	}

