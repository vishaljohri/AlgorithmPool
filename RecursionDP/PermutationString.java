
import java.util.ArrayList;

public class PermutationString {
	
	ArrayList<String> permutationString(String s) {
		
		if(s == null) {
			return null;
		}
		ArrayList<String> allCombinations = new ArrayList<>();
		//base case
		if(s.length() == 0) {
			allCombinations.add("");
			return allCombinations;
		}
		
		char first = s.charAt(0);
		String sub = s.substring(1);
		ArrayList<String> words = permutationString(sub);
		for(String word : words) {
			for(int i = 0; i <= word.length(); i++) {
				String st = insertChartAtPosition(word, first, i);
				allCombinations.add(st);
			}
		}
		
		return allCombinations;
	}
	
	String insertChartAtPosition(String word, char first, int i) {
		String s = word.substring(0, i);
		s = s + first;
		s = s + word.substring(i);
		return s;
		
	}

	public static void main(String[] args) {
		PermutationString ps = new PermutationString();
		System.out.println(ps.permutationString("abc"));

	}

}
