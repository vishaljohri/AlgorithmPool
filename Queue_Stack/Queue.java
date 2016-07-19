
public class Queue {
	int front;
	int rear;
	int []queue;
	int maxSize;
	int count;
	
	Queue(int maxSize) {
		this.maxSize = maxSize;
		queue = new int[this.maxSize];
		front = -1;
		rear = -1;
	}
	
	void enqueue(int n) {
		if(((rear+1)%maxSize) == front) {
			System.out.println("queue overflow");
			return;
		}
		int newRear = (rear+1)%maxSize;
		rear = newRear;
		if(front == -1) {
			front++;
			queue[rear] = n;
			count++;
			return;
		}
		queue[rear] = n;
		count++;
	}
	
	int dequeue() {
		if(count == 0 || front == -1) {
			System.out.println("can't dequeue, queue is empty");
			return -1;
		}
		int element = queue[front];
		count--;
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		else {
			front = (front + 1) % maxSize;
		}
		return element;	
	}
	
	void reverseQueueFirstKElements(int k) {
		java.util.Stack<Integer> tempStack = new java.util.Stack<>();
		for(int i = 1; i <= k; i++) {
			tempStack.push(this.dequeue());
		}
		while(!tempStack.empty()) {
			this.enqueue(tempStack.pop());
		}
		
		for(int i = 1; i <= count-k; i++) {
			int x = this.dequeue();
			this.enqueue(x);
		}
		
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		System.out.println(q.dequeue());
		q.enqueue(9);
		q.enqueue(1);
		q.enqueue(14);
		q.enqueue(6);
		q.enqueue(2);
		System.out.println(q.dequeue());
		
		Queue q2 = new Queue(5);
		q2.enqueue(4);
		q2.enqueue(5);
		q2.enqueue(6);
		q2.enqueue(7);
		q2.reverseQueueFirstKElements(2);

	}

}
