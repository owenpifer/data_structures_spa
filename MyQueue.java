package assignment2;

public class MyQueue {
	int[] arrayQueue;
	public MyQueue(int[] startArray) {
		this.arrayQueue = startArray;
	}
	public void queue(int newInt) {
		int[]tempInt = new int[arrayQueue.length+1];
		
    	for(int i = 1; i<arrayQueue.length+1;i++) {
    		tempInt[i] = arrayQueue[i-1];
    	}
    	tempInt[0]= newInt;
    	arrayQueue = tempInt;
	}
	public void dequeue() {
		int[]tempInt = new int[arrayQueue.length-1];
		for(int i = 0; i<arrayQueue.length-1;i++) {
			
			tempInt[i] = arrayQueue[i+1];
			
		
			
    		
    	}
		arrayQueue=tempInt;	
	}
	public void printQueue() {
    	for(int i = 0; i<arrayQueue.length;i++) {
    		System.out.print(" "+arrayQueue[i]);
    		
    	}
    	System.out.println();
	}
	public static void main(String[] args) {
		int[] array1 = new int[] {1,2,3,4,5};
		MyQueue queue1 = new MyQueue(array1);
		queue1.queue(7);
		queue1.printQueue();
		queue1.dequeue();
		queue1.printQueue();
	}

}
