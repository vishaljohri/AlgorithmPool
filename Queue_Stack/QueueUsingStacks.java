
public class QueueUsingStacks {
	private java.util.Stack<Integer> stackNewest;
	private java.util.Stack<Integer> stackOldest;
	int size;
	
	public QueueUsingStacks(int n) {
		size = n;
		stackNewest = new java.util.Stack<Integer>();
		stackOldest = new java.util.Stack<Integer>();
	}
	
	public void enqueue(int n) {
		stackNewest.push(n);
	}
	
	public int dequeue() {
		if(stackOldest.empty()) {
			while(!stackNewest.empty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
		if(stackOldest.empty()) {
			System.out.println("no element");
			return 0;
		}
		else {
			System.out.println("returning element");
			return stackOldest.pop();
		}
	}
	

	public static void main(String[] args) {
		QueueUsingStacks qs = new QueueUsingStacks(5);
		qs.enqueue(7);
		qs.enqueue(4);
		qs.enqueue(6);
		qs.enqueue(2);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		qs.enqueue(5);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());

	}

}
