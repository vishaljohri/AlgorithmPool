
public class StackUsingQueues {
	
	private Queue q1;
	private Queue q2;
	int active;
	int count = 0;
	
	public StackUsingQueues(int size) {
		q1 = new Queue(size);
		q2 = new Queue(size);
		active = 1;
		count = 0;
	}
	
	void push(int n) {
		if(active == 1) {
			q1.enqueue(n);
			count++;
		}
		else {
			q2.enqueue(n);
			count++;
		}
	}
	
	int pop() {
		if(active == 1) {
			for(int i = 1; i < count; i++) {
				q2.enqueue(q1.dequeue());		
			}
			active = 2;
			int x =  q1.dequeue();
			q1.front = -1;
			q1.rear = -1;
			count--;
			return x;
			
		}
			else {
				for(int i = 1; i < count; i++) {
					q1.enqueue(q2.dequeue());
					
			}
				active = 1;
				int x = q2.dequeue();
				q2.front = -1;
				q2.front = -1;
				count--;
				return x;
		}
	}

	public static void main(String[] args) {
		StackUsingQueues sq = new StackUsingQueues(5);
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());

	}

}
