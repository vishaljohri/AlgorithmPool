
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumber {
	// check if number is same if rotated by 180 degrees
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> hm = new HashMap<>();
		hm.put('0', '0');
		hm.put('1', '1');
		hm.put('6', '9');
		hm.put('8', '8');
		hm.put('9', '6');
		int start = 0;
		int end = num.length() - 1;
		while (start <= end) {
			if (!hm.containsKey(num.charAt(end))
					|| hm.get(num.charAt(end)) != num.charAt(start))
				return false;
			start++;
			end--;
		}
		return true;

	}

	// return all strobogrammatic nos till n
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		HashMap<Character, Character> togetherHm = new HashMap<>();
		togetherHm.put('0', '0');
		togetherHm.put('1', '1');
		togetherHm.put('6', '9');
		togetherHm.put('8', '8');
		togetherHm.put('9', '6');
		List<String> initial = new ArrayList<>();
		initial.add("0");
		initial.add("1");
		initial.add("8");
		initial.add("00");
		initial.add("11");
		initial.add("69");
		initial.add("88");
		initial.add("96");
		findStrobogrammaticHelper(n, "", togetherHm, initial, result);
		return result;
	}

	void findStrobogrammaticHelper(int n, String noFormed,
			HashMap<Character, Character> togetherHm, List<String> initial,
			List<String> result) {
		if (noFormed.length() > n)
			return;
		if (noFormed.length() != 0) {
			if(noFormed.length() == 1)
				result.add(noFormed);
			else if(noFormed.charAt(0) != '0')
				result.add(noFormed);
		}
			
		if (noFormed.length() == 0) {
			for (String s : initial) {
				findStrobogrammaticHelper(n, s, togetherHm, initial, result);
			}
		} else {
			for (char k : togetherHm.keySet()) {
				findStrobogrammaticHelper(n, k + noFormed + togetherHm.get(k),
						togetherHm, initial, result);
			}
		}
	}

	public static void main(String[] args) {
		StrobogrammaticNumber s = new StrobogrammaticNumber();
		System.out.println(s.isStrobogrammatic("18696981"));
		System.out.println(s.findStrobogrammatic(4));
	}
}