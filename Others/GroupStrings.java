import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupStrings {
	
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, List<String>> hm = new HashMap<>();
		
		for(String s : strings) {
			StringBuilder key = new StringBuilder("0");
			for(int i = 1; i < s.length(); i++) {
				int diff = s.charAt(i) - s.charAt(i - 1);
				if(diff < 0)
					diff += 26;
				key.append(diff);
			}
			String finalKey = String.valueOf(key);
			if(!hm.containsKey(finalKey)) {
				hm.put(finalKey, new ArrayList<String>());
			}
			hm.get(finalKey).add(s);
		}
		
		for(String k : hm.keySet()) {
			List<String> list = hm.get(k);
			result.add(list);
		}
		
		return result;
	}

	public static void main(String[] args) {
		GroupStrings g = new GroupStrings();
		String strings[] = {"abc", "ba", "a", "bcd","acef", "xyz", "az", "z", "efghi"};
		System.out.println(g.groupStrings(strings));

	}

}
