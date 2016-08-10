
public class SimpleRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i < 20; i++) {
			System.out.println("iteration: " + i + " thread: " + Thread.currentThread().getName());
		}
		
	}
	
	
	public static void main(String[] args) {
		SimpleRunnable r1 = new SimpleRunnable();
		SimpleRunnable r2 = new SimpleRunnable();
		
		Thread t1 = new Thread(r1, "Thread1");
		Thread t2 = new Thread(r2, "Thread2");
		t1.start();
		t2.start();

	}

}
