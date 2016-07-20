
public class SwapNumbers {

	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		System.out.println("before swapping: " + a + " " + b);
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("before swapping: " + a + " " + b);
		
		//using the bit manipulation
		System.out.println("before doing bit manipulation: " + a + " " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("before doing bit manipulation: " + a + " " + b);

	}

}
