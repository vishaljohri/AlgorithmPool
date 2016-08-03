
public class Count2s {
	
	void countNumberOf2sBruteForce(int n) {
		int count = 0;
		for(int i = 2; i <= n; i++) {
			count += count2sForNumber(i);
		}
		
		System.out.println(count);
	}
	
	int count2sForNumber(int n) {
		int count = 0;
		
		while(n != 0) {
			if(n % 10 == 2)
				count++;
			n = n / 10;
		}
		return count;
	}
	
	void countOptimized(int n) {
		int count = 0;
		int len = String.valueOf(n).length();
		for(int d = 0; d < len; d++) {
			count += count2sOptimizedHelper(n, d);
		}
		System.out.println(count);
	}
	
	int count2sOptimizedHelper(int n, int d) {
		int pow10 = (int) Math.pow(10, d);
		int nextPow10 = pow10 * 10;
		
		int roundDown = n - n % nextPow10;
		int roundUp = roundDown + nextPow10;
		int right = n % pow10 + 1;
		int digit = (n / pow10) % 10;
		if(digit < 2)
			return roundDown / 10;
		else if(digit == 2)
			return roundDown / 10 + right;
		else
			return roundUp / 10;
	}

	public static void main(String[] args) {
		Count2s c = new Count2s();
		c.countNumberOf2sBruteForce(25);
		c.countOptimized(61523);

	}

}
