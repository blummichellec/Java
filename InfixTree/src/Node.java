//Defines nodes for the binary tree

class Node
{
    public String data;
    //Each node can have 2 children
    public Node leftChild;
    public Node rightChild;
 
    //Create a node containing character data
    public Node(String x)
    {
        data = x;
    }
 
    //Print the character data within the node
    public void displayNode()
    {
        System.out.print(data + " ");
    }
}