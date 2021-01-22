package assignment2;


public class DumbQueue {
	
	MyStack s;
	public DumbQueue(MyStack inStack){
		s = inStack;
	}
	public void queue(int inInt) {
		int[] tempInt = new int[s.length()+1];
		
		for(int i = 0; i<tempInt.length-1;i++) {
			tempInt[i] = s.pop();
		}
		tempInt[tempInt.length-1]=inInt;
		for(int i = tempInt.length-1; i>=0;i--) {
			s.push(tempInt[i]);
		}
		
	}
	// The big O of this is either O(n+2) or O(2n+2) -- I'm not sure if it becomes 2n if you have to loops
	
	public void dequeue() {
		int[] tempInt = new int[s.length()];
		for(int i = 0; i<tempInt.length;i++) {
			tempInt[i] = s.pop();
		}
		for(int i = tempInt.length-2; i>=0;i--) {
			s.push(tempInt[i]);
		}
	}
	public void printDumbQueue() {
		s.printStack();
	}
	// the big O of this is O(n+1)
	public static void main(String[] args) {
		int[]array1 = new int[] {1,2,3,4,5};
		MyStack stack1 = new MyStack(array1);
		DumbQueue dumbQ1 = new DumbQueue(stack1);
		dumbQ1.queue(7);
		dumbQ1.printDumbQueue();
		dumbQ1.dequeue();
		dumbQ1.printDumbQueue();
	}
}
