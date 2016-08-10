
public class DeadlockDemo {
	
	public void method1() {
		synchronized (String.class) {
			System.out.println("Acquired lock on string class");
			
			synchronized (Integer.class) {
				System.out.println("Acquired lock on integer class");
				
			}
			
		}
	}
	
	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Acquired lock on integer class");
			
			synchronized (String.class) {
				System.out.println("Acquired lock on string class");
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
