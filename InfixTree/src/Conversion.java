//This class creates an output string in Postfix notation that can be used to 
//create the Expression Tree

import java.util.Stack; //to use string Stack

class Conversion
{
    private Stack<String> s;
    private String[] input;
    private String output = "";
 
    public Conversion(String str)
    {
        input = str.split("\\s+");
        s = new Stack<>();
    }
 
    public String inToPost()
    {
    	int checkOperators = 0;
    	int checkOperands = 0;
    	int checkParen1 = 0;
    	int checkParen2 = 0;
    	
    	//Check a single token from string input
    	//Use switch case to assign priority level to each operator
        for (int i = 0; i < input.length; i++)
        {
        	//Convert string input to array of tokens
            String token = input[i];
            
            //Input validation
            if (checkOperators == 2 || checkOperands == 2) {
            	System.out.println("Error: 2 operators or 2 operands in succession.");
            	System.exit(3); //Error code 3 for doubles
            }
           
            switch (token)
            {
            	//Lowest priority (+,-)
                case "+":
                case "-":
                	//Decide what to do with it
                    gotOperator(token, 1);
                    checkOperators += 1;
                    checkOperands = 0;
                    //Input validation
                    if (i == (input.length-1) || i == 0) {
                    	System.out.println("Error: Expression incomplete.");
                    	System.exit(7); //Exit code 7 for begins or ends with operator
                    }
                    break;
                //Medium priority (*,/,%)
                case "*":
                case "/":
                case "%":
                	//Decide what to do with it
                    gotOperator(token, 2);
                    checkOperators += 1;
                    checkOperands = 0;
                    //Input validation
                    if (i == (input.length-1) || i == 0) {
                    	System.out.println("Error: Expression incomplete.");
                    	System.exit(7); //Exit code 7 for begins or ends with operator
                    }
                    break;
                //Highest priority is () 
                //Since highest priority, immediately push onto stack when seen
                case "(":
                    s.push(token);
                    //Input validation
                    if (checkOperators != 1) {
                    	System.out.println("Error: Parentheses used incorrectly.");
                    	System.exit(4); //Error code 4 for parentheses misuse
                    }
                    checkParen1 += 1;
                    break;
                //Validate closing parentheses present
                case ")":
                    gotParenthesis();
                    //Input validation
                    if (checkOperands != 1) {
                    	System.out.println("Error: Parentheses used incorrectly.");
                    	System.exit(4); //Error code 4 for parentheses misuse    
                    }
                    checkParen2 += 1;
                    break;
                //Operand
                //Immediately added to output string
                default:
                	//Input validation
                	if (token.contains("-")) {
                		System.out.println("Error: Expression contains a negative value.");
                		System.exit(1); } //Exit code 1 for negative values
                	try { Double.parseDouble(token); }
                	catch (NumberFormatException ex) {
                		System.out.println("Error: Invalid token found in input.");
                		System.exit(6); } //Error code 6 for invalid tokens
                    output = output + " " + token;
                    checkOperands += 1;
                    checkOperators = 0;
            }
        }
        
        //Place remaining operators in stack onto end of output string
        while (!s.isEmpty())
            output = output + " " + s.pop();
        
        //Input validation
        if (checkParen1 != checkParen2) {
        	System.out.println("Error: Mismatched parentheses.");
        	System.exit(5); //Error code 5 for mismatch
        }
        
        //Input validation
        if (output.contains("0 /")) {
        	System.out.println("Error: Expression tries to divide by 0."); 
        	System.exit(2); //Exit code 2 for divide by 0
        }
    
        return output;
    }
 
    private void gotOperator(String op_current, int priority1)
    {
        while (!s.isEmpty())
        {
        	//Pop operator from stack (will  be of higher priority than op_current or a '(')
            String opTop = s.pop();
            //If popped element is an open parentheses, push back onto stack to ensure full 
            //expression inside will be read and because highest priority (creating priority ordered stack)
            if (opTop.equals("("))
            {
                s.push(opTop);
                break;
            } else
            {
            	//Compare current priority level to previous priority level
                int priority2;
                if (opTop.equals("+") || opTop.equals("-"))
                    priority2 = 1;
                else //'*', '/', '%'
                    priority2 = 2;
                //If previous is higher priority, push it onto the stack
                if (priority2 < priority1)
                {
                    s.push(opTop);
                    break;
                //If current is higher priority, add to output string
                } else
                    output = output + " " + opTop;
            }
        }
        //The current character is pushed onto stack to be evaluated as the next 'previous' character
        s.push(op_current);
    }
 
    private void gotParenthesis()
    {
        while (!s.isEmpty())
        {
            String token = s.pop();
          //If the previous element on the stack is an open parentheses, expression was empty
            if (token == "(")
                break;
            else //Expression was not empty and should be immediately added to output string
                output = output + " " + token;
        }
    }
}