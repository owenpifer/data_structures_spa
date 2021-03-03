package assignment6;

public class assign6Methods {
	//i copied the palindrome stuff from https://www.baeldung.com/java-palindrome
	public boolean isPalindromeRecursive(String text){
		//splits up inputed text and puts it in lower case the calls actual method
	    String clean = text.replaceAll("\\s+", "").toLowerCase();
	    return recursivePalindrome(clean,0,clean.length()-1);
	}

	private boolean recursivePalindrome(String text, int forward, int backward) {
	    if (forward == backward) {
	        return true;
	        //returns true if it's a one or two letter word
	        //this is also a base case for words that have an odd number of letters
	    }
	    if ((text.charAt(forward)) != (text.charAt(backward))) {
	        return false;
	        //returns false if the front letter and back letter aren't equal
	    }
	    if (forward < backward + 1) {
	        return recursivePalindrome(text, forward + 1, backward - 1);
	        /*this is what does the recursion -- it looks at letters further in and then checks
	         *  them with the above if statement, and if it's a palindrome and doesn't satisfy
	         *   the above if statement for one letter words, then the true is returned
	         *    by the return statement on the bottom of the method
	         */
	    }

	    return true;
	}
	public int recursiveArraySearch(int startInt, int targetInt, int[]array) {
		//startInt is also an index of sorts
		if(array[startInt]==targetInt) {
			return startInt;
		}
		else if(startInt==array.length-1 && array[startInt]!=targetInt) {
			return 70000;
			//shouldn't return that but i couldn't return null so...
		}
		else {
			recursiveArraySearch(startInt+1, targetInt, array);
		}
		return startInt;
		
		
		/*basically with this method I used a startInt which doubles as an index
		 * , a target integer, and the given array. It checks if the value at the
		 * index in the array is equal to the target int, then if that doesn't return,
		 * checks if it's on the last number in the array and then checks if that number
		 * isn't equal to the target number (this is so it will end if the number doesn't
		 * appear.
		 */
	}
	
	

}
