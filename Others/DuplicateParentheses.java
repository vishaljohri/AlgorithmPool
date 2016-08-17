import java.util.Stack;

public class DuplicateParentheses {
	
	boolean duplicateParentheses(String str) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch != ')') {
				stack.push(ch);
			}
			else {
				char top = stack.pop();
				if(top == '(')
					return true;
				while(top != '(') {
					top = stack.pop();
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DuplicateParentheses d = new DuplicateParentheses();
		System.out.println(d.duplicateParentheses("((a+b)+((c+d)))"));
	}
}