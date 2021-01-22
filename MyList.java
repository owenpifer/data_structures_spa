package assignment2;


public class MyList{
    int [] currentList;
    public MyList(int[]inputArray){
        this.currentList = inputArray;
    }
    public void append(int newInt){
        int[]tempInt = new int[currentList.length+1];
        
        for(int i = 0; i<currentList.length;i++){
            tempInt[i] = currentList[i];
          

        }
        tempInt[tempInt.length-1] = newInt;
        currentList = tempInt;

    }
    //O(n+3)
    public void pop() {
    	int[]tempInt = new int[currentList.length-1];
       
        for(int i = 0; i<currentList.length-1;i++){
            tempInt[i] = currentList[i];
          
        }
        
        currentList = tempInt;
    }
    // O(n+2)
    public void insert(int newInt, int index) {
    	int[]tempInt = new int[currentList.length+1];
    	for(int i = 0; i<index;i++) {
    		tempInt[i] = currentList[i];
    	}
    	tempInt[index] = newInt;
    	for(int i = index+1;i<tempInt.length; i++) {
    		tempInt[i] = currentList[i-1];
    	}
    	currentList = tempInt;
    }
    // the big O of this is O(2n+2)
    public void remove(int index) {
    	int[]tempInt = new int[currentList.length-1];
    	for(int i = 0; i<index;i++) {
    		tempInt[i] = currentList[i];
    	}
    	for(int i = index;i<tempInt.length; i++) {
    		tempInt[i] = currentList[i+1];
    	}
    	currentList = tempInt;
    	
    }
    // also O(2n+2)
    public void printList() {
    	for(int i = 0; i<currentList.length;i++) {
    		System.out.print(" "+currentList[i]);
    		
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	int[]array1 = new int[]{3,5,7,2,7};
    	MyList list1 = new MyList(array1);
    	list1.append(5);
    	list1.printList();
    	list1.pop();
    	list1.printList();
    	list1.insert(8, 1);
    	list1.printList();
    	list1.remove(1);
    	list1.printList();
    }



}