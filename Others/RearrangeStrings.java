package leetcode.ques;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeStrings {

	// rearrange string such that same characters are at least k distance
	public String rearrangeString(String str, int k) {
		HashMap<Character, Integer> hm = new HashMap<>();
		buildMap(str, hm);
		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>(10,
				new Comparator<Entry<Character, Integer>>() {
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
		pq.addAll(hm.entrySet());
		java.util.Queue<Entry<Character, Integer>> waitingQueue = new LinkedList<>();
		StringBuilder result = new StringBuilder();
		while (!pq.isEmpty()) {
			Entry<Character, Integer> node = pq.poll();
			result.append(node.getKey());
			node.setValue(node.getValue() - 1);
			waitingQueue.add(node);
			if (waitingQueue.size() >= k) {
				Entry<Character, Integer> first = waitingQueue.poll();
				if (first.getValue() != 0)
					pq.add(first);
			}
		}
		if (result.length() == str.length())
			return String.valueOf(result);
		else
			return "";
	}

	void buildMap(String str, HashMap<Character, Integer> hm) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!hm.containsKey(ch))
				hm.put(ch, 0);
			hm.put(ch, hm.get(ch) + 1);
		}
	}

	public static void main(String[] args) {
		RearrangeStrings r = new RearrangeStrings();
		System.out.println(r.rearrangeString("abb", 2));
	}
}
