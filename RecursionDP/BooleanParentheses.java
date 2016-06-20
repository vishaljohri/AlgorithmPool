
public class BooleanParentheses {
	
	int count(String exp, boolean result, int start, int end) {
		if(start == end) {
			if(exp.charAt(end) == '1' && result)
				return 1;
			else if(exp.charAt(end) == '0' && !result)
				return 1;
			return 0;
		}
		int c = 0;
		if(result) {
			for(int i = start+1; i <= end; i++) {
				char op = exp.charAt(i);
				if(op == '&') {
					c += count(exp, true, start, i-1) * count(exp, true, i+1, end);
				}
				else if(op == '|') {
					c += count(exp, true, start, i-1) * count(exp, false, i+1, end);
					c += count(exp, false, start, i-1) * count(exp, true, i+1, end);
					c += count(exp, true, start, i-1) * count(exp, true, i+1, end);
				}
				else if(op == '^') {
					c += count(exp, true, start, i-1) * count(exp, false, i+1, end);
					c += count(exp, false, start, i-1) * count(exp, true, i+1, end);
				}
			}
		} else {
			for(int i = start+1; i <= end; i++) {
				char op = exp.charAt(i);
				if(op == '&') {
					c += count(exp, false, start, i-1) * count(exp, false, i+1, end);
					c += count(exp, true, start, i-1) * count(exp, false, i+1, end);
					c += count(exp, false, start, i-1) * count(exp, true, i+1, end);
				}
				else if(op == '|') {
					c += count(exp, false, start, i-1) * count(exp, false, i+1, end);
				}
				else if(op == '^') {
					c += count(exp, true, start, i-1) * count(exp, true, i+1, end);
					c += count(exp, false, start, i-1) * count(exp, false, i+1, end);
				}
			}
		}
		
		return c;
	}

	public static void main(String[] args) {
		BooleanParentheses bp = new BooleanParentheses();
		String str = "1^0|0|1";
		System.out.println("number of ways true: " + bp.count(str, true, 0, str.length()-1));
		System.out.println("number of ways false: " + bp.count(str, false, 0, str.length()-1));
	}

}
