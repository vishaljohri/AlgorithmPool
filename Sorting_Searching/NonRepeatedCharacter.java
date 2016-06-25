package programming.interviews.exposed.book;

import java.util.HashMap;

public class NonRepeatedCharacter {

	String firstNonrepeated(String str) {
		Object seenOnce = new Object();
		Object seenMultiple = new Object();
		HashMap<Integer, Object> hm = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);
			if(hm.containsKey(cp)) {
				hm.put(cp, seenMultiple);
			}
			else {
				hm.put(cp, seenOnce);
			}
		}
		
		for(int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);
			if(hm.get(cp) == seenOnce)
				return new String(Character.toChars(cp));
		}
		return null;
	}
	public static void main(String[] args) {
		String str = "total";
		NonRepeatedCharacter n = new NonRepeatedCharacter();
		System.out.println(n.firstNonrepeated(str));

	}

}
