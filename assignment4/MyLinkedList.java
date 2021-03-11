package assignment4;

public class MyLinkedList {
	public Node headNode;
	public MyLinkedList(Node n) {
		this.headNode = n;
	}
	public void printList(){
		Node currentNode = this.headNode;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public void remove(int index) {
		Node tempNode = this.headNode;
		for(int i = 0; i<index-1; i++) {
			tempNode = tempNode.next;
		}
		Node next = tempNode.next.next;
		tempNode.next  = next;
	}
	public void add(int k) {
		Node newNode = new Node(k);
		newNode.next = this.headNode;
		this.headNode = newNode;
	}
	
	//used geeks for geeks video for reverse
	
	public void reverse() {
		Node previous = null;
		Node current = this.headNode;
		Node next = current.next;
		
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		this.headNode = previous;
	}
	public void insert(Node insertNode, int index) {
		Node baseNode = this.headNode;
		Node tempNode = baseNode;
		for(int i = 0; i<index-1; i++) {
			tempNode = tempNode.next;
		}
		Node next = tempNode.next;
		tempNode.next = insertNode;
		insertNode.next = next;
		this.headNode = baseNode;
	}
	
	public Node findNode(int index) {
		Node tempNode = this.headNode;
		for(int i = 0; i<index-1; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	public int length() {
		Node tempNode = this.headNode;
		Node next = tempNode.next;
		int returnInt=1;
		while(next!=null) {
			tempNode = tempNode.next;
			returnInt+=1;
			
		}
		
		return returnInt;
	}
	
	//copied this from https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
	public void swapNodes(int x, int y) { 
       
        if (x == y) return; 
  
        
        Node prevX = null, currX = this.headNode; 
        //searches for the x node
        while (currX != null && currX.data != x) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
         
        Node prevY = null, currY = this.headNode; 
        //searches for the y node
        while (currY != null && currY.data != y) 
        { 
            prevY = currY; 
            currY = currY.next; 
        } 
  
        // checks to make sure there is legitimate x and y values 
        if (currX == null || currY == null) 
            return; 
  
        // checks to see if  x is the headnode
        if (prevX != null) 
            prevX.next = currY; 
        else //then if not makes y the headnode
            this.headNode = currY; 
  
        // does the same thing as above but switches y and x
        if (prevY != null) 
            prevY.next = currX; 
        else  
            this.headNode = currX; 
  
        // makes sure the .next pointers are correct
        Node temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
    } 

}
