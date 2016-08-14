
import java.util.Stack;

public class ValidParenthese {
	
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i < s.length()) {
			if(s.charAt(i) == '(')
				stack.push(i);
			else {
				if(stack.size() >= 1 && s.charAt(stack.peek()) == '(') {
					stack.pop();
				}
				else
					stack.push(i);
			}
			i++;
		}
		int maxLength = 0;
		int last = s.length() - 1;
		if(stack.size() == 0)
			return s.length();
		while(stack.size() >= 1) {
			int temp = stack.pop();
			if(maxLength < last - temp)
				maxLength = last - temp;
			last = temp - 1;
		}
		if(maxLength < last + 1)
			maxLength = last + 1;
		
		return maxLength;
	
	}

	public static void main(String[] args) {
		ValidParenthese vp = new ValidParenthese();
		System.out.println(vp.longestValidParentheses("(()"));

	}

}
