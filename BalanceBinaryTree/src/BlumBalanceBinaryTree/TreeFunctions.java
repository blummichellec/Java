package BlumBalanceBinaryTree;

import java.time.Duration; //needed for timing purposes
import java.time.Instant; //needed for timing purposes
import java.util.ArrayList; //needed to use Array List

class TreeFunctions<param> {
	
	//Create parameter param to use in Node class
	@SuppressWarnings("hiding")
	class Node<param> {
		
		param word;
		Node<param> leftChild;
		Node<param> rightChild;
		
		public Node(param word) {
			this.word = word;
			leftChild = null;
			rightChild = null;
		}
		
		public param getword() {
			return word;
		}
	}
	
	Node<param> root;
	
	public TreeFunctions() {
		root = null;
	}
	
	public boolean isNull() {
		return root == null;
	}
	
	//Takes array list input from main function
	//Searches for user input linearly using this list
	public void linearSearch(ArrayList<String> search, String input) {
		
		int size = search.size();
		
		//Time searching in array list
		Instant start1 = Instant.now();
		//Searches for user inputed word in array list
		for (int i = 0; i < size; i++) {
			if (search.get(i).equals(input)) {
				Instant finish1 = Instant.now();
				long timeElapsed1 = Duration.between(start1, finish1).toNanos();
				System.out.println("Linear search (in ns): " + timeElapsed1);
			}
		}
	}
	
	//Takes text file input and places words into node array list
	//This array list will be used to construct the tree, versus the one
	//above, which is used solely for linear search purposes
	public Node<param> TreeConvert(Node<param> root) {
		
		ArrayList<Node<param>> list = new ArrayList<Node<param>>();
		addNode(root, list);
		
		int size = list.size();
		
		return TreeConstruct(list, 0, size - 1);
	}
	
	//Function for adding the nodes to the tree
	public void addNode(Node<param> root, ArrayList<Node<param>> list) {
		
		if (root == null) {
			return;
		}
		
		addNode(root.leftChild, list);
		list.add(root);
		addNode(root.rightChild, list);
	}
	
	//Constructs the initial unbalanced tree
	public Node<param> TreeConstruct(ArrayList<Node<param>> list, int first, int last) {
		
		if (first > last) {
			return null;
		}
		
		int middle = (first + last) /2;
		Node<param> node = list.get(middle);
		
		node.leftChild = TreeConstruct(list, first, middle - 1);
		node.rightChild= TreeConstruct(list, middle + 1,last );
		
		return node;
	}
	
	//Balance the tree created in TreeConstruct
	public TreeFunctions<param>.Node<param> insertword (param word){
		
		Node<param> element = new Node<param> (word);
		Node<param> current = null;
		
		@SuppressWarnings("unchecked")
		Comparable<param> comparewords = (Comparable<param>)word;
		
		if (isNull()) {
			root = element;
		}
		
		else {
			current = root;
			boolean inserted = false;
			
			while (!inserted) {
				if (comparewords.compareTo(current.word) == 0) {
					inserted= true;
				}
				else if (comparewords.compareTo(current.word)<0) {
					if (current.leftChild ==null) {
						current.leftChild = element;
						inserted = true;
					}
					else {
						current= current.leftChild;
					}
				}
				else {
					if (current.rightChild == null) {
						current.rightChild = element;
						inserted = true;
					}
					else {
						current= current.rightChild;	
					}
				}
			}
		}
		
		return current;
	}
	
	//Searches for word in balanced binary tree
	@SuppressWarnings("unchecked")
	public Node<param> Treesearch(param Userin){
		
		Node<param> current = root;
		while (current != null) {
			if (((Comparable<param>)Userin).compareTo(current.word) == 0) {
				return current;
			}
			else {
				if (((Comparable<param>)Userin).compareTo(current.word) < 0) {
					current = current.leftChild;
					
				}
				else
					current = current.rightChild;
			}
		}
		
		return null;
	}
	
}
