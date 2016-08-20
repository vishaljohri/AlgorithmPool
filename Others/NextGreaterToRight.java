import java.util.Stack;

public class NextGreaterToRight {
	
	// find next greater element on the right of each element
	void findNextGreaterOnRight(int a[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(a[0]);
		for(int i = 1; i < a.length; i++) {
			while(stack.size() > 0 && a[i] > stack.peek()) {
				System.out.println(stack.pop() + " -> " + a[i]);
			}
			stack.push(a[i]);
		}
		while(stack.size() != 0) {
			System.out.println(stack.pop() + " -> -1");
		}
	}

	public static void main(String[] args) {
		NextGreaterToRight n = new NextGreaterToRight();
		int a[] = {4, 5, 2, 1, 25};
		n.findNextGreaterOnRight(a);
	}
}