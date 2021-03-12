package setenceGenerator;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;

public class RandomSentence {
	
	
	public static ArrayList<String> uploadFile(String filename) throws FileNotFoundException{
	    

	    String token1 = "";

	    Scanner inFile1 = new Scanner(new File(filename));
	    ArrayList<String> temps = new ArrayList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.next();
	      temps.add(token1);
	    }
	    
	    inFile1.close();
	    temps.add(token1.replaceAll("[\\p{Punct}&&[^.]]+", "").replaceAll("â€™", ""));



	    return temps;
	    	    
	  }
	
	public static HashMap<String, ArrayList<String>> trainData(ArrayList<String> text){
		HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();
		
		for(int i =0; i<text.size()-1;i++) {
			String currentWord = text.get(i);
			String nextWord = text.get(i+1);
			dictionary.putIfAbsent(currentWord, new ArrayList<String>());
			dictionary.get(currentWord).add(nextWord);
		}
		
		
		return dictionary;
	}
	public static boolean isEndWord(String word) {
		if(word.substring(word.length() - 1)=="."){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static ArrayList<String> getStartWords(HashMap<String, ArrayList<String>> dictionary){
		ArrayList<String>startWords = new ArrayList<String>();
		ArrayList<String>keysAsArray = new ArrayList<String>(dictionary.keySet());
		
		for(int i=0;i<dictionary.size(); i++) {
			if(isEndWord(keysAsArray.get(i))==true) {
				for(int b = 0; b<dictionary.get(keysAsArray.get(i)).size();b++) {
					startWords.add(dictionary.get(keysAsArray.get(i)).get(b));
				}
			}
		}
		
		return startWords;
		
	}
 	
	public static String generateSentenceProcess(HashMap<String, ArrayList<String>> dictionary, ArrayList<String>startWords) {
		String result = "";
		Random r = new Random();
		String currentWord = startWords.get(r.nextInt(startWords.size()));
		String nextWord;
		result += currentWord+" ";
		
		do {
			nextWord = dictionary.get(currentWord).get(r.nextInt(dictionary.get(currentWord).size()));
			currentWord = nextWord;
			result += currentWord+" ";
		}while(isEndWord(currentWord)==false);
		
		
		return result;
	}
	public static void generateAndPrint(HashMap<String, ArrayList<String>> dictionary, ArrayList<String>startWords) {
		for(int i =0; i<1; i++) {
			System.out.println(generateSentenceProcess(dictionary, startWords));
		}
	}
	

	
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String>bookText = uploadFile("hp1.txt");
		HashMap<String, ArrayList<String>> dictionary = trainData(bookText);
		ArrayList<String>startWords = getStartWords(dictionary);
		generateAndPrint(dictionary,startWords);
		
		
	}

}
