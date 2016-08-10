
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick {
	Lock lock;
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public boolean pickup() {
		return lock.tryLock();
	}
	
	public void putDown() {
		lock.unlock();
	}
}

public class DiningPhilosopher extends Thread{
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;
	
	public DiningPhilosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}
	
	public void eat() {
		if(pickUp()) {
			chew();
			putDown();
		}
	}
	
	public void chew() {
		
	}
	
	public boolean pickUp() {
		if(!left.pickup()) {
			return false;
		}
		if(!right.pickup()) {
			left.putDown();
			return false;
		}
		return true;
	}

	public void putDown() {
		left.putDown();
		right.putDown();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
