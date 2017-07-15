/*
Shows how to use the pop-up box in java.
© 2015 MICHELLE BLUM ALL RIGHTS RESERVED
*/

import javax.swing.JOptionPane;

public class DialogViewerer 
{
	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog("What is your name?");
		System.out.print("Hello, ");
		System.out.print(name);
		System.exit(0);
	}
}
