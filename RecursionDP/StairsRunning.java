
public class StairsRunning {

	int countWays(int n) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else
			return(countWays(n-1) + countWays(n-2) + countWays(n-3));
	}
	
	int countWaysDP(int n) {
		int a[] = new int[n+1];
		a[0] = 1;
		a[1] = 1;
		a[2] = 2;
		for(int i = 3; i <= n ; i++) {
			a[i] = a[i-1] + a[i-2] + a[i-3];
		}
		return a[n];
	}
	
	
	public static void main(String[] args) {
		StairsRunning sr = new StairsRunning();
		System.out.println("number of possible ways are: " + sr.countWays(4));
		System.out.println("number of possible ways using dp: " + sr.countWaysDP(5));
	}

}
