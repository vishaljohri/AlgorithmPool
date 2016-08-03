
import java.util.Arrays;
import java.util.HashMap;

public class MinimumWindow {

	int minimumWindow(String str, String substring) {
		int minimum = Integer.MAX_VALUE;
		if (str.length() < substring.length())
			return -1;

		char c[] = substring.toCharArray();
		Arrays.sort(c);
		substring = new String(c);

		for (int i = 0; i <= str.length() - substring.length(); i++) {
			String s = "";
			for (int j = i; j < str.length(); j++) {
				s += str.charAt(j);
				if (j - i + 1 < substring.length())
					continue;
				String newString = s;
				char ch[] = newString.toCharArray();
				Arrays.sort(ch);
				newString = new String(ch);

				int subPointer = 0;
				for (int k = 0; k < newString.length(); k++) {
					if (subPointer >= substring.length())
						break;
					if (newString.charAt(k) == substring.charAt(subPointer))
						subPointer++;
				}
				if (subPointer == substring.length()) {
					if (newString.length() < minimum)
						minimum = newString.length();
					break;
				}
			}
		}
		return minimum;
	}

	int minimumWindowEfficient(String source, String target) {
		HashMap<Character, Integer> tm = new HashMap<>();
		int minWindow = Integer.MAX_VALUE;
		for (int i = 0; i < target.length(); i++) {
			if (tm.containsKey(target.charAt(i))) {
				tm.put(target.charAt(i), tm.get(target.charAt(i)) + 1);
			} else {
				tm.put(target.charAt(i), 1);
			}
		}
		HashMap<Character, Integer> backupTarget = new HashMap<>(tm);
		HashMap<Character, Integer> sm = new HashMap<>();
		int matchingChars = target.length();
		int count = 0;
		int start = 0;
		boolean flag = false;
		for (int i = 0; i < source.length(); i++) {
			if (backupTarget.containsKey(source.charAt(i))) {
				if (!flag) {
					start = i;
					flag = true;
				}
				if (sm.containsKey(source.charAt(i)))
					sm.put(source.charAt(i), sm.get(source.charAt(i)) + 1);
				else
					sm.put(source.charAt(i), 1);
				if(tm.get(source.charAt(i)) > 0) {
					count++;
					tm.put(source.charAt(i), tm.get(source.charAt(i)) - 1);
				}
			}

			if (start < source.length() && count >= matchingChars) {
					HashMap<Character, Integer> temp = new HashMap<>(sm);
					while (start < source.length() && (!temp.containsKey(source.charAt(start))
							|| temp.get(source.charAt(start)) > backupTarget
							.get(source.charAt(start)))) {
						if(temp.containsKey(source.charAt(start)))
								temp.put(source.charAt(start), temp.get(source.charAt(start)) - 1);
						start++;
					}
					sm = new HashMap<>(temp);
				if (minWindow > i + 1 - start)
					minWindow = i + 1 - start;
			}
		}
		return minWindow;
	}
	
	public String minWindowMoreEfficient(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(hm.containsKey(t.charAt(i)))
                hm.put(t.charAt(i), hm.get(t.charAt(i)) + 1);
            else
                hm.put(t.charAt(i), 1);
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int minSize = Integer.MAX_VALUE;
        boolean found = false;
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) >= 0)
                    count++;
                while(count == t.length()) {
                    found = true;
                    int curSize = end - start + 1;
                    if(curSize < minSize) {
                        minSize = curSize;
                        windowStart = start;
                        windowEnd = end;
                    }
                    if(hm.containsKey(s.charAt(start))) {
                        hm.put(s.charAt(start), hm.get(s.charAt(start)) + 1);
                        if(hm.get(s.charAt(start)) > 0) {
                            count--;
                        }
                    }
                    start++;
                }
            }
            end++;
        }
        if(found)
            return s.substring(windowStart, windowEnd + 1);
        else
            return "";
    }

	public static void main(String[] args) {
		MinimumWindow mw = new MinimumWindow();
		System.out.println(mw.minimumWindow("ABBACBAA", "ABBCB"));
		System.out.println("efficient implementation : " + mw.minimumWindowEfficient("ABBACBAA", "ABBCB"));

	}

}
