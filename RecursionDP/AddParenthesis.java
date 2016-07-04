
import java.util.ArrayList;
import java.util.List;

public class AddParenthesis {

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int iL : left) {
					for (int iR : right) {
						int val = 0;
						switch (c) {
						case '+':
							val = iL + iR;
							break;
						case '-':
							val = iL - iR;
							break;
						case '*':
							val = iL * iR;
							break;
						}
						res.add(val);
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.valueOf(input));
		return res;
	}

	public static void main(String[] args) {
		AddParenthesis ap = new AddParenthesis();
		System.out.println(ap.diffWaysToCompute("2*3-4*5"));

	}

}
