
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer1 implements Runnable {
	BlockingQueue<Integer> bq;
	
	public Producer1(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("producing item: " + i);
			try {
				bq.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer1 implements Runnable {
	BlockingQueue<Integer> bq;
	
	public Consumer1(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("consuming item: " + bq.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		Producer1 p = new Producer1(bq);
		Consumer1 q = new Consumer1(bq);
		Thread t1 = new Thread(p, "Producer");
		Thread t2 = new Thread(q, "Consumer");
		t1.start();
		t2.start();

	}

}
