public class IntegerReplacement {
	
	public int integerReplacement(int n) {
		
		if (n == Integer.MAX_VALUE)
			return 32;
		
		return integerReplacementHelper(n, 0);
	}

	int integerReplacementHelper(int n, int repl) {
		
		if ((n & (n - 1)) == 0) {
			int count = repl;
			while (n != 1) {
				n = n >> 1;
				count++;
			}
			return count;
		} else {
			if (n % 2 == 0)
				return integerReplacementHelper(n / 2, repl + 1);
			else {
				return(Math.min(integerReplacementHelper(n - 1, repl + 1),
						integerReplacementHelper(n + 1, repl + 1)));
			}
		}
	}

	public static void main(String[] args) {
		IntegerReplacement i = new IntegerReplacement();
		System.out.println(i.integerReplacement(9));
	}
}