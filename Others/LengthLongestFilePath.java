
public class LengthLongestFilePath {
	
	public int lengthLongestPath(String input) {
		String str[] = input.split("\n");
		int maxLength = 0;
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		
		int count = 0;
		for(String s : str) {
			int beginTabs = 0;
			int p = 0;
			while(s.charAt(p) == '\t') {
				beginTabs++;
				p++;
			}
			if(beginTabs != stack.size()) {
				while(stack.size() != beginTabs) {
					count -= stack.pop();
				}
			}
			if(beginTabs == 0)
				stack.push(s.length() - beginTabs);
			else
				stack.push(s.length() - beginTabs + 1);
			count += stack.peek();
			if(s.contains(".")) {
				maxLength = Math.max(maxLength, count);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LengthLongestFilePath l = new LengthLongestFilePath();
		System.out.println(l.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.txt\n\t\tsubsubdir1"
				+ "\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.txt"));
	}
}