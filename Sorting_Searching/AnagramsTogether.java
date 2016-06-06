
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class AnagramsTogether {

	void sortString(String []array) {
		HashMap<String, LinkedList<String>> hm = new HashMap<>();

		for(String s : array) {
			char []a = s.toCharArray();
			Arrays.sort(a);
			String key = new String(a);
			if(!hm.containsKey(key)) {
				hm.put(key, new LinkedList<String>());
				LinkedList<String> l = hm.get(key);
				l.add(s);
			}
			else {
				LinkedList<String> l = hm.get(key);
				l.add(s);
			}

		}

		for(String key : hm.keySet()) {
			LinkedList<String> l = hm.get(key);
			for(String str : l) {
				System.out.print(str + " ");
			}
		}
	}

	public static void main(String[] args) {
		String array[] = {"car", "rac", "aid", "got", "to", "ot"};
		AnagramsTogether a = new AnagramsTogether();
		a.sortString(array);

	}

}
