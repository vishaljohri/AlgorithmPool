
public class SimpleThread extends Thread{
	
	@Override
	public void run() {
		for(int i = 1; i < 20; i++) {
			System.out.println("iteration: " + i + " thread: " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		SimpleThread st1 = new SimpleThread();
		st1.setName("Thread1");
		SimpleThread st2 = new SimpleThread();
		st2.setName("Thread2");
		st1.start();
		st2.start();

	}

}
