
import java.util.LinkedList;

class Producer extends Thread {
	LinkedList<Integer> list;

	public Producer(LinkedList<Integer> list) {
		super("Producer");
		this.list = list;
	}

	@Override
	public void run() {

		for (int i = 0; i < 6; i++) {
			synchronized (list) {
				while (list.size() >= 1) {
					System.out.println("queue is full. Producer is waiting");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("producing: " + i);
				list.add(i);
				list.notify();
			}
		}
	}
}

class Consumer extends Thread {
	LinkedList<Integer> list;

	public Consumer(LinkedList<Integer> list) {
		super("Consumer");
		this.list = list;
	}

	public void run() {
		while(true) {
			synchronized(list) {
				while(list.size() == 0) {
					System.out.println("queue is empty. Consumer is waiting.");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consuming element: " + list.poll());
				list.notify();
			}
		}
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Producer p = new Producer(list);
		Consumer c = new Consumer(list);
		p.start();
		c.start();

	}

}
