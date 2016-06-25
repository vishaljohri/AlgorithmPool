
import java.util.ArrayList;

public class StringCombination {
	ArrayList<StringBuilder> list = new ArrayList<>();
	StringBuilder s = new StringBuilder();
	
	void generateCombinations(String str, int start) {
		for(int i = start; i < str.length(); i++) {
			s.append(str.charAt(i));
			System.out.print(s + " ");
			if(i < str.length() - 1) {
				generateCombinations(str, i + 1);
			}
			s.setLength(s.length() - 1);
		}
	}
	

	public static void main(String[] args) {
		String str = "wxyz";
		StringCombination sb = new StringCombination();
		sb.generateCombinations(str, 0);

	}

}
