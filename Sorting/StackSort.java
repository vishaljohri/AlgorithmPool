
public class StackSort {
	
	java.util.Stack<Integer> sortStack(java.util.Stack<Integer> givenStack) {
		java.util.Stack<Integer> tempStack = new java.util.Stack<>();
		while(!givenStack.empty()) {
			int i = givenStack.pop();
			while(!tempStack.empty() && i < tempStack.peek()) {
				givenStack.push(tempStack.pop());
			}
			tempStack.push(i);
		}
		return tempStack;
	}

	public static void main(String[] args) {
		StackSort ss = new StackSort();
		java.util.Stack<Integer> newStack = new java.util.Stack<>();
		newStack.push(7);
		newStack.push(4);
		newStack.push(6);
		newStack.push(2);
		newStack.push(5);
		System.out.println("stack before sorting elements: " + newStack);
		newStack = ss.sortStack(newStack);
		System.out.println("Stack after sorting elements: " + newStack);

	}

}
