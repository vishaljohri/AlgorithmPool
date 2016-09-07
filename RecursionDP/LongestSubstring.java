import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstring {

	// find longest substring such that all chars are repeated at least k times
	int result = Integer.MIN_VALUE;
	public int longestSubstring(String s, int k) {
		longestSubstringHelper(s, k);
		return result;
	}
	
	public void longestSubstringHelper(String s, int k) {
		if (s.length() == 0)
			return;
		List<Integer> list = getMinimumOcuringCharLocs(s);
		if (list.size() >= k) {
			result = Math.max(result, s.length());
		}

		for (int i = 0; i < list.size(); i++) {
			if (i == 0)
				longestSubstring(s.substring(0, list.get(i)), k);
			else
				longestSubstring(s.substring(list.get(i - 1) + 1, list.get(i)),k);
		}
		longestSubstring(s.substring(list.get(list.size() - 1) + 1), k);
	}

	List<Integer> getMinimumOcuringCharLocs(String s) {
		HashMap<Character, List<Integer>> hm = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), new ArrayList<Integer>());
			hm.get(s.charAt(i)).add(i);
		}

		int minSize = Integer.MAX_VALUE;
		char minKey = ' ';
		for (char k : hm.keySet()) {
			if (hm.get(k).size() < minSize) {
				minSize = hm.get(k).size();
				minKey = k;
			}
		}
		return hm.get(minKey);
	}

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.longestSubstring("hadccccccddddcccccddddddccccccccdddddddeeffgglhkj", 7));
	}
}