package assignment2;


public class DumbQueue {
	
	MyStack s;
	public DumbQueue(MyStack inStack){
		s = inStack;
	}
	public void queue(int inInt) {
		int[] tempInt = new int[s.length()+1];
		
		for(int i = 0; i<s.length();i++) {
			tempInt[i] = s.pop();
		}
		tempInt[s.length()]=inInt;
		for(int i = s.length()-1; i>0;i--) {
			s.push(tempInt[i]);
		}
		
	}
	// The big O of this is either O(n+2) or O(2n+2) -- I'm not sure if it becomes 2n if you have to loops
	
	public void dequeue() {
		int[] tempInt = new int[s.length()];
		for(int i = 0; i<s.length();i++) {
			tempInt[i] = s.pop();
		}
		for(int i = s.length()-2; i>0;i--) {
			s.push(tempInt[i]);
		}
	}
	// the big O of this is O(n+1)

}
