package assignment2;

public class MyStack {
	int[] arrayStack;
	public MyStack(int[] startArray) {
		this.arrayStack = startArray;
	}
	public int pop() {
		int x = arrayStack[arrayStack.length-1];
    	int[]tempInt = new int[arrayStack.length-1];
       
        for(int i = 0; i<arrayStack.length-1;i++){
            tempInt[i] = arrayStack[i];
          
        }
        
        arrayStack = tempInt;
        return x;
    }
	public void push(int newInt){
        int[]tempInt = new int[arrayStack.length+1];
        
        for(int i = 0; i<arrayStack.length;i++){
            tempInt[i] = arrayStack[i];
          

        }
        tempInt[tempInt.length-1] = newInt;
        arrayStack = tempInt;

    }
	
	public int length() {
		return arrayStack.length;
	}
	 public void printStack() {
	    	for(int i = 0; i<arrayStack.length;i++) {
	    		System.out.print(" "+arrayStack[i]);
	    		
	    	}
	    	System.out.println();
	 }
	public static void main(String[] args) {
		int[] array1 = new int[] {1,2,3,4,5};
		MyStack stack1 = new MyStack(array1);
		stack1.pop();
		stack1.printStack();
		stack1.push(7);
		stack1.printStack();
	}
}
