
import java.util.TreeSet;

public class LogicalQues {

	void primeNumber() {
		int number = 11;
		if (number < 2) {
			System.out.println("Not prime");
			return;
		}
		int root = (int) Math.sqrt(number);
		for (int i = 2; i <= root; i++) {
			if (number % i == 0) {
				System.out.println("Not prime");
				return;
			}
		}
		System.out.println("prime number");
	}

	void generatePrime() {
		int max = 500; // prime numbers less equal to 100
		boolean flag[] = new boolean[max + 1];
		for (int i = 2; i <= max; i++) {
			flag[i] = true;
		}

		int prime = 2;
		while (prime != 0) {
			setFalsePrimeFactors(flag, prime);
			prime = getNextPrimeNumber(flag, prime);
		}

		// print prime numbers
		System.out.println("Generating prime numbers below:");
		for (int i = 2; i <= max; i++) {
			if (flag[i] == true)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	void setFalsePrimeFactors(boolean[] flag, int prime) {
		int temp = prime * prime;
		while (temp < flag.length) {
			flag[temp] = false;
			temp = temp + prime;
		}
	}

	int getNextPrimeNumber(boolean[] flag, int prime) {
		int temp = prime + 1;
		while (temp < flag.length) {
			if (flag[temp] == true)
				return temp;
			temp++;
		}
		return 0;
	}

	void multiply(int n1, int n2) {
		int prod = 0;
		int sign = 1;
		if (n1 < 0 && n2 < 0)
			sign = 1;
		else if (n1 < 0 || n2 < 0)
			sign = -1;
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		for (int i = 1; i <= n2; i++) {
			prod += n1;
		}
		System.out.println(prod * sign);
	}

	void subtract(int n1, int n2) {
		int sign = 1;
		if(n1 < n2)
			sign = -1;
		int large = Math.max(n1, n2);
		int small = Math.min(n1, n2);
		int i = 0;
		int sum = small;
		while(sum <= large) {
			sum = small + i;
			if(sum == large) {
				System.out.println(i * sign);
				break;
			}
			i++;
		}
	}

	void divide(int n1, int n2) {
		int i = 0;
		int div = 0;
		int sign = 1;
		if (n1 < 0 && n2 < 0)
			sign = 1;
		else if (n1 < 0 || n2 < 0)
			sign = -1;
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		while (div <= n1) {
			div += n2;
			i++;
		}
		System.out.println((i - 1) * sign);
	}

	void generateKthMagicNumber() {
		int k = 11;
		if (k < 1) {
			System.out.println("incorrect number");
			return;
		}
		int val = 1;
		TreeSet<Integer> treeSet = new TreeSet<>();
		addElementsToTreeSet(treeSet, val);

		for (int i = 1; i < k; i++) {
			val = treeSet.pollFirst();
			addElementsToTreeSet(treeSet, val);
		}

		System.out.println("required kth element is: " + val);
	}

	void addElementsToTreeSet(TreeSet<Integer> treeSet, int val) {
		treeSet.add(val * 3);
		treeSet.add(val * 5);
		treeSet.add(val * 7);
	}

	public static void main(String[] args) {
		LogicalQues l = new LogicalQues();
		l.primeNumber();
		l.generatePrime();
		l.multiply(4, 6);
		l.subtract(9, 4);
		l.divide(9, 2);
		l.generateKthMagicNumber();
	}

}
