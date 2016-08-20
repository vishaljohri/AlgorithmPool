public class SubsetSumLessThanK {
	
	// find number of subsets with sum < k and >= k
	void numberSubsets(int a[], int k) {
		int dp[][] = new int[a.length + 1][k + 1];
		
		// fill first row and column with 1s
		for(int i = 0; i <= k; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i <= a.length; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= a.length; i++) {
			for(int j = 1; j <= k; j++) {
				// can't include this element
				if(a[i - 1] >= j) {
					dp[i][j] = dp[i - 1][j];
				}
				// can include
				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
				}
			}
		}
		
		int totalSets = (int) Math.pow(2, a.length);
		System.out.println("No of subsets with < k = " + dp[a.length][k]);
		System.out.println("No of subsets with >= k = " + (totalSets - dp[a.length][k]));
		
	}

	public static void main(String[] args) {
		SubsetSumLessThanK s = new SubsetSumLessThanK();
		int a[] = {1, 2, 3, 4, 5};
		s.numberSubsets(a, 5);
	}
}
