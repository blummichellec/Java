/**
 * Project: Polymorphism
 * 
 * Submitted by: Michelle Blum
 * Submitted to: Professor Prakash Rao
 * 
 * December 10th, 2018
 * 
 * This project reads in data from a text file and outputs it as a purchase invoice.
 * 
 * Notes:
 * If a fruit or vegetable is found in the list for which there is no class, 
 * this line will not be counted in the total.
 * Line also skipped if only one token present or if blank line.
 * Invoice sorted by classification type and alphabetically within classification.
 */

package FOOD;

import java.util.ArrayList; //to use array list
import java.util.Collections; //to sort array list
import java.util.Comparator; //to sort array list
import java.util.Scanner; //for user input
import java.io.*; //to work with text file
import java.lang.reflect.Constructor; //needed to user shorthand of "15 if-statements"
										//finds appropriate constructor dependent on text file input
import java.lang.reflect.InvocationTargetException; //needed because method explicitly invoked via reflection

//contains main method
public class Polymorphism {
	public static void main( String args[] )
	{
		
		//create array list to hold produce data read in from text file
		ArrayList<Produce> l = new ArrayList<Produce>();
		
		//catches file not found error
		try {
			//read in text file
			Scanner in = new Scanner(new File("data.txt"));
			
			while(in.hasNext()) { //while there is more to be read
				String line = in.nextLine(); //read the whole line
				String[] tokens = line.split("\\s"); //split the line into quantity and produce type
				
				//verifies two pieces of data present (neither missing)
				if (tokens.length != 2) {
					line = in.nextLine();
					tokens = line.split("\\s");
				}
				
				Double quantity = Double.parseDouble(tokens[1]);
				//tries to match produce type to constructor name in Produce.java file
				try {
					@SuppressWarnings("unchecked")
					//ensure matching types on either side of equal sign (produce to produce)
					Constructor <Produce> c=
							(Constructor<FOOD.Produce>) (Class.forName("FOOD." + tokens[0]).getConstructor(Double.TYPE));
					//after appropriate constructor found, add instance of that class to array list
					l.add(c.newInstance(quantity));
				} 
				//covers all other possible exceptions
					//class not found, unable to create new instance, unable to access method, unable to use argument,
					//unable to locate target in method, unable to find method..
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			
			//close scanner to prevent resource leak
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//call method to output the array list data
		output(l);

	}
	
	//method to output the array list data
	public static void output(ArrayList<Produce> l) {

		//initialize value of price/list item and total spent
		double ext_price = 0.00, total = 0.00;
		
		//print invoice here
		System.out.println("Produce Purchase Invoice");
		
		//sort invoice by classification type
		//sort invoice alphabetically within classification type
		Collections.sort(l, new Comparator<Produce>() {

			@Override
			public int compare(Produce o1, Produce o2) {
				
				String x1 = ((Produce) o1).produceClassification();
				String x2 = ((Produce) o2).produceClassification();
				int sComp = x1.compareTo(x2);
				
				if (sComp != 0) {
					return sComp;
				}
				
				return o1.produceType().compareTo(o2.produceType());
			}
		});
		
		for(Produce p:l) {
			
			//price/list item is the quantity purchased multiplied by the price type (a.k.a price per unit)
			ext_price = p.price() * p.getQty();
			//maintain running total by adding the price/list item after each object in list read
			total = total + ext_price;
			
			System.out.println("<" + p.produceType() + "> " + "<" + p.produceClassification() + "> " +
		"<" + p.priceType() + "> " + "<" + p.price() + "> " + "<" + p.getQty() + "> " + "<" + round(ext_price,2) + "> "); }
		
		System.out.println("Total: $" + round(total,2));
	}
	
	//method to round price/list item to at most 2 decimal places
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
