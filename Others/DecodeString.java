public class DecodeString {
	
	public String decodeString(String s) {
		java.util.Stack<String> stack = new java.util.Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ']') {
				String subString = "";
				while(!stack.peek().equals("[")) {
					subString = stack.pop() + subString;
				}
				stack.pop();
				String repString = "";
				while(stack.size() > 0) {
					try {
						repString = Integer.parseInt(stack.peek()) + repString;
						stack.pop();
					}
					catch(NumberFormatException ex) {
						break;
					}
				}
				int rep = Integer.parseInt(repString);
				
				String newSequence = "";
				while(rep > 0) {
					newSequence += subString;
					rep--;
				}
				stack.push(newSequence);
			}
			else {
				stack.push(String.valueOf(s.charAt(i)));
			}
		}
		
		String result = "";
		while(stack.size() != 0) {
			result = stack.pop() + result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		DecodeString d = new DecodeString();
		System.out.println(d.decodeString("100[leetcode5[code]]"));
	}
}