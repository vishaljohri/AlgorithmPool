package leetcode.ques;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
	
	boolean cycleFound = false;
	public String alienOrder(String[] words) {
		if (words.length == 0)
			return "";
		HashMap<Character, Set<Character>> hm = new HashMap<>();
		HashSet<Character> uniqueChars = new HashSet<>();
		String result = "";
		int maxLength = 0;
		for (String s : words) {
			if (s.length() > maxLength)
				maxLength = s.length();
			for (int i = 0; i < s.length(); i++) {
				uniqueChars.add(s.charAt(i));
			}
		}
		for (int i = 0; i < maxLength; i++) {
			for (int j = 1; j < words.length; j++) {
				if (i >= words[j].length() || i >= words[j - 1].length())
					continue;
				if (words[j].substring(0, i).equals(
						words[j - 1].substring(0, i))
						&& words[j].charAt(i) != words[j - 1].charAt(i)) {
					if (!hm.containsKey(words[j - 1].charAt(i)))
						hm.put(words[j - 1].charAt(i), new HashSet<Character>());
					hm.get(words[j - 1].charAt(i)).add(words[j].charAt(i));
				}
			}
		}

		Stack<Character> stack = new Stack<>();
		Set<Character> visited = new HashSet<>();
		for (char c : uniqueChars) {
			if(cycleFound)
				return "";
			if (!visited.contains(c)) {
				Stack<Character> cycle = new Stack<>();
				dfsTopological(c, hm, stack, visited, cycle);
			}
		}
		while (!stack.isEmpty()) {
			result = result + stack.pop();
		}
		return result;
	}

	void dfsTopological(char ch, HashMap<Character, Set<Character>> hm,
			Stack<Character> stack, Set<Character> visited, Stack<Character> cycle) {
		visited.add(ch);
		cycle.push(ch);
		if (hm.containsKey(ch)) {
			for (char neighbor : hm.get(ch)) {
				if(cycle.contains(neighbor)) {
					cycleFound = true;
					return;
				}
				if (!visited.contains(neighbor))
					dfsTopological(neighbor, hm, stack, visited, cycle);
			}
		}
		cycle.pop();
		stack.push(ch);
	}

	public static void main(String[] args) {
		AlienDictionary ad = new AlienDictionary();
		String words[] = {"wrt", "wrf", "er", "ett", "rftt"};
		// String words[] = {"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"};
		System.out.println(ad.alienOrder(words));
	}
}