
import java.util.ArrayList;
import java.util.HashSet;

public class ParanthesesCombination {

	HashSet<String> parentheses(int number) {
		HashSet<String> allComb = new HashSet<>();
		if (number == 0) {
			allComb.add("");
			return allComb;
		}

		HashSet<String> prev = parentheses(number - 1);
		for (String str : prev) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					String newString = insertParentheses(str, i);
					allComb.add(newString);
				}
			}
			allComb.add("()" + str);
		}
		
		return allComb;
	}

	String insertParentheses(String str, int i) {
		String prefix = str.substring(0, i + 1);
		String suffix = str.substring(i + 1);
		return prefix + "()" + suffix;
	}
	
	ArrayList<String> optimized(int count) {
		char []str = new char[2*count];
		ArrayList<String> list = new ArrayList<>();
		optimizedImplementation(list, count, count, str, 0);
		return list;
	}
	
	void optimizedImplementation(ArrayList<String> list, int leftRemaining, int rightRemaining, char[]str, int count) {
		if(rightRemaining < leftRemaining || leftRemaining < 0)
			return;
		
		if(leftRemaining == 0 && rightRemaining == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else {
			if(leftRemaining > 0) {
				str[count] = '(';
				optimizedImplementation(list, leftRemaining-1, rightRemaining, str, count+1);
			}
			
			if(rightRemaining > leftRemaining) {
				str[count] = ')';
				optimizedImplementation(list, leftRemaining, rightRemaining-1, str, count+1);
			}
		}
	}

	public static void main(String[] args) {
		ParanthesesCombination pc = new ParanthesesCombination();
		System.out.println(pc.parentheses(3));
		System.out.println("optimized implementation: " + pc.optimized(3));
	}

}
