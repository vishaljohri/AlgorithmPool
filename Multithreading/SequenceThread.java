
class Foo {
	public Foo() {
		
	}
	
	public void first() throws InterruptedException {
		System.out.println("first");
		Thread.sleep(1000);
	}
	
	public void second() throws InterruptedException {
		System.out.println("second");
		Thread.sleep(1000);
	}
	
	public void third() throws InterruptedException {
		System.out.println("third");
		Thread.sleep(1000);
	}
}

class ThreadA extends Thread {
	Foo foo;
	
	public ThreadA(Foo foo) {
		this.foo = foo;
	}
	public void run() {
		try {
			foo.first();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadB extends Thread {
	Foo foo;
	
	public ThreadB(Foo foo) {
		this.foo = foo;
	}
	public void run() {
		try {
			foo.second();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ThreadC extends Thread {
	Foo foo;
	
	public ThreadC(Foo foo) {
		this.foo = foo;
	}
	public void run() {
		try {
			foo.third();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SequenceThread {

	public static void main(String[] args) throws InterruptedException{
		Foo obj = new Foo();
		ThreadA threadA = new ThreadA(obj);
		ThreadB threadB = new ThreadB(obj);
		ThreadC threadC = new ThreadC(obj);
		threadA.start();
		threadA.join();
		threadB.start();
		threadB.join();
		threadC.start();

	}

}
