import java.util.HashMap;
import java.util.LinkedList;

class CharNode {
	char key;
	public CharNode(char key) {
		this.key = key;
	}
}
public class FirstNonRepeatingCharacter {
	
	// find fist non-repeating character in stream of characters
	void firstNonRepeatingCharacter(char c[]) {
		HashMap<Character, CharNode> hm = new HashMap<>();
		LinkedList<CharNode> list = new LinkedList<>();
		for(int i = 0; i < c.length; i++) {
			if(hm.containsKey(c[i])) {
				CharNode node = hm.get(c[i]);
				if(node != null) {
					list.remove(node);
					node = null;
				}
			}
			else {
				CharNode node = new CharNode(c[i]);
				hm.put(c[i], node);
				list.add(node);
			}
		}
		if(list.size() > 0)
			System.out.println(list.get(0).key);
		else
			System.out.println(-1);
	}
	
	public static void main(String[] args) {
		FirstNonRepeatingCharacter f = new FirstNonRepeatingCharacter();
		char c[] = {'b', 'a', 'c', 'b', 'c', 'd'};
		f.firstNonRepeatingCharacter(c);
	}
}