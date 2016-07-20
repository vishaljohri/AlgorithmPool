
import java.util.HashMap;

public class WordFrequency {
	
	HashMap<String, Integer> buildTable(String []book) {
		HashMap<String, Integer> hm = new HashMap<>();
		for(String word : book) {
			word = word.toLowerCase();
			if(word.trim() != "") {
				if(hm.get(word) == null)
					hm.put(word, 1);
				else
					hm.put(word, hm.get(word)+1);
			}
		}
		return hm;
	}
	
	int getFrequency(HashMap<String, Integer>hm, String word) {
		if(hm == null || word == null)
			return -1;
		word = word.toLowerCase();
		if(hm.containsKey(word)) {
			return hm.get(word);
		}
		return 0;
	}
 
	public static void main(String[] args) {
		String book[] = {"this", "is", "a", "book", "this", ".", "the", "is", "is", "id", "is", "there"};
		WordFrequency w = new WordFrequency();
		HashMap<String , Integer> hm = w.buildTable(book);
		System.out.println(w.getFrequency(hm, "this"));
		System.out.println(w.getFrequency(hm, "is"));
		System.out.println(w.getFrequency(hm, "."));
		System.out.println(w.getFrequency(hm, "hello"));

	}

}
