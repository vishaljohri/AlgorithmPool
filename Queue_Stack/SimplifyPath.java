
public class SimplifyPath {
	
	// simplify path given in unix format
	public String simplifyPath(String path) {
		java.util.Stack<String> stack = new java.util.Stack<>();
		String splitPath[] = path.split("/+");
		for (String s : splitPath) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					if (stack.size() == 1 && stack.get(0).equals(""))
						continue;
					else
						stack.pop();
				}
			} else if (s.equals("."))
				continue;
			else
				stack.push(s);
		}

		StringBuilder sb = new StringBuilder();
		while (stack.size() > 1) {
			sb.insert(0, "/" + stack.pop());
		}
		if (stack.size() == 1)
			sb.insert(0, stack.pop());
		if (path.charAt(0) == '/' && sb.length() == 0)
			sb.insert(0, '/');
		return String.valueOf(sb);
	}

	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/c/d/./../e"));

	}

}
