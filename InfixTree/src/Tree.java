//This class uses the Conversion program to build and traverse through the expression tree

import java.util.Stack; //To use Stack data structure

class Tree
{
    private Node root;
 
    public Tree()
    {
    	//Case of no input, tree root should be empty
        root = null;
    }
 
    public void insert(String s)
    {
    	//Allows for use of functions within Conversion.java
        Conversion c = new Conversion(s);
        //Output string is the infix input in order for postfix notation
        s = c.inToPost();
        //Create a new stack to store nodes
        Stack <Node> stk = new Stack<>();
        //Add '#' onto the end of the inputed string as stopping point
        s = s + " #";
        //'i' and 'symbol' are used to go through each token in original string
        String[] splited = s.trim().split("\\s+");
        int i = 0;
        String symbol = splited[i];
        Node newNode;
        
        //Note: Operands able to immediately be placed into Node stack because
        //output string already in post-fix (bottom of tree will be on bottom of stack - when we pop
        //we will begin with the top of the tree)
        while (!(symbol.equals("#")))
        {
        	//This allows the user to enter expressions with variables and with positive numbers
        	//Are we looking at an operand?
        	boolean isValidDouble = false;
        	try {
        		Double.parseDouble(symbol);
        		isValidDouble = true;
        	}
        	catch (NumberFormatException ex) {
                //Instructed not to include ^ a.k.a exponents
                //Or an operator?
        		if (symbol.equals("+") || symbol.equals("-") || symbol.equals("/")
                    || symbol.equals("*") || symbol.equals("%"))
        		{
        			//When operator reached, as with RPN calculator program (Project #1),
        			//pop 2 elements of stack
        			Node ptr1 = stk.pop();
        			Node ptr2 = stk.pop();
        			//Create a node for this operator and push it onto the node stack
        			//Enough elements on stack to create miniature tree of parent-children nodes
        			//Continue creating miniature trees until full tree is created
        			newNode = new Node(symbol);
        			newNode.leftChild = ptr2;
        			newNode.rightChild = ptr1;
        			stk.push(newNode); 
        		}
            }
            if (isValidDouble == true)
            {
            	//Create a node for this operand and push it onto the node stack
                newNode = new Node(symbol);
                stk.push(newNode); }
            ++i;
            symbol = splited[i];
        }
        //Assign the top of the tree
        root = stk.pop();
    }
 
    //Display each type of traversal
    public void traverse(int type)
    {
        switch (type)
        {
        	//Should match initial input
            case 1:
                System.out.print("Inorder Traversal: ");
                inOrder(root);
                break;
            case 2:
                System.out.print("Preorder Traversal: ");
                preOrder(root);
                break;
            case 3:
                System.out.print("Postorder Traversal: ");
                postOrder(root);
                break;
            default:
                System.out.println("Invalid Choice.");
        }
    }
    
    
    //For the type of traversal, the only line that is changed
    //is the location of displayNode()
 
    private void preOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
 
    private void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }
 
    private void postOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }
}