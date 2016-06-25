
import java.util.HashSet;

public class RemoveCharacters {
	
	String removeChars(String str, String remove) {
		char[] r = remove.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		for(int i = 0; i < r.length; i++) {
			hs.add(r[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(!hs.contains(str.charAt(i)))
				sb.append(str.charAt(i));
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		String str = "Battle of the vowels : Hawaii vs. Grozny";
		RemoveCharacters rc = new RemoveCharacters();
		System.out.println(rc.removeChars(str, "aeiou"));

	}

}
