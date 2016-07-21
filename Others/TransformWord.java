
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TransformWord {
	
	LinkedList<String> transform(String start, String stop, Set<String> dictionary) {
		start = start.toUpperCase();
		stop = stop.toUpperCase();
		Queue<String> wordQueue = new LinkedList<>();
		Set<String> visitedSet = new HashSet<>();
		Map<String, String> backtrackMap = new TreeMap<>();
		wordQueue.add(start);
		visitedSet.add(start);
		
		while(!wordQueue.isEmpty()) {
			String w = wordQueue.poll();
			for(String v : getOneEditWords(w)) {
				if(v.equals(stop)) {
					LinkedList<String> list = new LinkedList<>();
					list.add(v);
					while(w != null) {
						list.add(0, w);
						w = backtrackMap.get(w);
					}
					return list;
				}
				if(dictionary.contains(v)) {
					if(!visitedSet.contains(v)) {
						wordQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
		}
		return null;
	}
	
	TreeSet<String> getOneEditWords(String w) {
		TreeSet<String> words = new TreeSet<>();
		for(int i = 0; i < w.length(); i++) {
			char wordArray[] = w.toCharArray();
			for(char k = 'A'; k <= 'Z'; k++) {
				if(k != w.charAt(i)) {
					wordArray[i] = k;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("DAMP");
		dictionary.add("LAMP");
		dictionary.add("LIMP");
		dictionary.add("LIME");
		dictionary.add("LIKE");
		
		TransformWord tw = new TransformWord();
		System.out.println(tw.transform("DAMP", "LIKE", dictionary));

	}

}
