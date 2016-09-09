import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class CharNode {
	char ch;
	int freq;
	public CharNode(char ch, int freq) {
		this.ch = ch;
		this.freq = freq;
	}
}
public class RearrangeStrings {
	
	// rearrange string such that same characters are at least k distance
	public String rearrangeString(String str, int k) {
		/*HashMap<Character, Integer> hm = new HashMap<>();
		buildMap(str, hm);
		List<Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				if(o1.getValue() < o2.getValue())
					return 1;
				else if(o1.getValue() > o2.getValue())
					return -1;
				else
					return 0;
			}
		});
		
		StringBuilder result = new StringBuilder();
		while(result.length() != str.length()) {
			int count = 0;
			while(count < k) {
				if(list.size() <= count)
					return "";
				char ch = list.get(count).getKey();
				result.append(ch);
				list.get(count).setValue(list.get(count).getValue() - 1);
				count++;
			}
			removeZeroFreqChars(list);
		}
		*/
		PriorityQueue<CharNode> pq = new PriorityQueue<>(10, new Comparator<CharNode>() {
			@Override
			public int compare(CharNode o1, CharNode o2) {
				if(o1.freq < o2.freq)
					return 1;
				else if(o1.freq > o2.freq)
					return -1;
				else
					return 0;
			}
		});
		buildQueue(str, pq);
		StringBuilder result = new StringBuilder();
		
		return String.valueOf(result);
	}
	
	void buildQueue(String str, PriorityQueue<CharNode> pq) {
		
	}
	void buildMap(String str, HashMap<Character, Integer> hm) {
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!hm.containsKey(ch))
				hm.put(ch, 0);
			hm.put(ch, hm.get(ch) + 1);
		}
	}
	
	void removeZeroFreqChars(List<Entry<Character, Integer>> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getValue() == 0) {
				list.remove(i);
				i--;
			}
		}
	}

	public static void main(String[] args) {
		RearrangeStrings r = new RearrangeStrings();
		System.out.println(r.rearrangeString("aaadbbcc", 2));
	}
}
