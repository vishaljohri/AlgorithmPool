
import java.util.ArrayList;
import java.util.HashMap;

class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	public SuffixTree(String s) {
		for(int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}
	
	ArrayList<Integer> search(String s) {
		return root.search(s);
	}
}

class SuffixTreeNode {
	HashMap<Character, SuffixTreeNode> children = new HashMap<>();
	char value;
	ArrayList<Integer> indexes = new ArrayList<>();
	
	public void insertString(String s, int index) {
		indexes.add(index);
		if(s != null && s.length() > 0) {
			value = s.charAt(0);
			SuffixTreeNode child = null;
			if(children.containsKey(value))
				child = children.get(value);
			else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			String remainder = s.substring(1);
			child.insertString(remainder, index);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		if(s == null || s.length() == 0) {
			return indexes;
		}
		else {
			char first = s.charAt(0);
			if(children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).search(remainder);
			}
		}
		
		return null;
	}
}

public class PatternMatch {

	public static void main(String[] args) {
		SuffixTree s = new SuffixTree("bibs");
		System.out.println(s.search("ib"));

	}

}
