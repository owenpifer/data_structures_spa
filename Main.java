package miniproject;

public class Main {
	
	/* https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a
	 * -- used this to find out about charAt(), which treats the string like an array and lets you find a char at a specific position in the string "array"
	 */
	
	//this doesn't work idk why
	public static String addNumsToString(String s) {
		String tempString = "";
		for(int i = 0; i<s.length(); i++) {
			
			if(s.charAt(i)==('0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9')) {
				tempString+=s.charAt(i);
			}
			else if(s.charAt(i)!=('0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9')&&tempString!="") {
				// https://www.geeksforgeeks.org/string-to-integer-in-java-parseint/ ---- used this for parseInt()
				int tempInt = Integer.parseInt(tempString);
				tempInt+=9;
				tempString = Integer.toString(tempInt);
				s = s.substring(0,i-tempString.length())+tempString+s.substring(i,s.length());
				tempString = "";
			}
		}
		return s;
	}
	
	public static void main(String[]args) {
		String string1 = "this is a string with 12 and also 4";
		String newString = addNumsToString(string1);
		System.out.println(newString);
	}

}
