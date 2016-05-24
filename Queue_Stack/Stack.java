
public class Stack {
	private int maxSize;
	private int []stack;
	private int []minElement;
	private int top;

	Stack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
		minElement = new int[this.maxSize];
		top = -1;
	}
	
	void push(int n) {
		if((top+1) == this.maxSize) {
			System.out.println("stack overflow");
			return;
		}
		stack[++top] = n;
		if(top == 0) {
			minElement[top] = n;
		}
		else{
			minElement[top] = Math.min(minElement[top-1], n);
		}
	}
	
	int pop() {
		if(top == -1) {
			System.out.println("stack underflow");
			return 0;
		}
		return(stack[top--]);
	}
	
	void minimum() {
		if(top == -1) {
			System.out.println("stack underflow");
			return;
		}
		System.out.println("minimum element is: " + minElement[top]);
	}
	
	public static void main(String[] args) {
		Stack st = new Stack(5);
		st.push(7);
		st.push(4);
		st.push(6);
		st.push(2);
		st.push(5);
		st.minimum();
		System.out.println(st.pop());
		st.minimum();
		System.out.println(st.pop());
		st.minimum();
		System.out.println(st.pop());
		st.minimum();
		System.out.println(st.pop());
		st.minimum();
		System.out.println(st.pop());
		st.minimum();
		//st.push(5);

	}

}
