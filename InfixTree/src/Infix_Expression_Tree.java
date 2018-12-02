/* 
 * Project #2
 * Data Structures and Algorithms Using Java
 * 
 * Submitted by: Michelle Blum
 * Submitted to: Dr Rao
 * 16 November 2018
 * 
 * Convert Infix Notation to Post-fix Notation using Expression Trees
 */

/*
 * Note1:
 * The user enters a string in Infix Notation. The program will then
 * represent this infix notation in expression tree form. An expression tree
 * is a variation of a binary tree where an in-order traversal results in an
 * infix expression, a pre-order traversal in a prefix expression, and a 
 * post-order traversal in a post-fix expression. 
 * 
 * Note2:
 * The user may enter their expression using operands only as numbers, not as variables.
 * 
 * Note3:
 * The user may not enter exponents (^) or negative numbers.
 * 
 * Note4:
 * The user should include white space between each token or element of their expression.
 */

import java.util.Scanner; //For user input
 
public class Infix_Expression_Tree
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        Tree t1 = new Tree();
        
        System.out.println("Enter an expression in Infix Notation:");
        String a = keyboard.nextLine();
        
        //Uses switch case statement in Tree.java for type of traversal
        
        t1.insert(a);
        t1.traverse(1);
        System.out.println("");
        
        t1.traverse(2);
        System.out.println("");
        
        t1.traverse(3);
        System.out.println("");
        
        keyboard.close();
    }
}