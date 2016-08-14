
public class Derangements {
	
	int derangement(int n) {
		if(n == 1)
			return 0;
		if(n == 0)
			return 1;
		if(n == 2)
			return 1;
		return (n - 1) * (derangement(n - 1) + derangement(n - 2));
	}

	public static void main(String[] args) {
		Derangements d = new Derangements();
		System.out.println(d.derangement(4));

	}

}
