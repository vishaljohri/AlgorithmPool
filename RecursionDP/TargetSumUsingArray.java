import java.util.Arrays;

public class TargetSumUsingArray {
	
	// find if elements in array sum up to target
	boolean targetSum(int a[], int n) {
		boolean dp[][] = new boolean[a.length + 1][n + 1];
		Arrays.sort(a);
		
		// to achieve target 0, always true
		for(int i = 0; i <= a.length; i++) {
			dp[i][0] = true;
		}
		
		// target >= 1 and set is empty, always false;
		for(int i = 1; i <= n; i++) {
			dp[0][i] = false;
		}
		
		// fill up the remaining cells
		for(int i = 1; i <= a.length; i++) {
			for(int j = 1; j <= n; j++) {
				if(j < a[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
				}
			}
			// print numbers, return true once dp[i][n] == true
			if(dp[i][n] == true) {
				int sum = 0;
				int iter = n;
				while(sum != n) {
					if(dp[i - 1][iter] == false) {
						System.out.print(a[i - 1] + " ");
						sum += a[i - 1];
						iter = iter - a[i - 1];
						i--;
					}
					else {
						i--;
					}
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TargetSumUsingArray t = new TargetSumUsingArray();
		int a[] = {1, 2, 3, 5, 7, 10};
		System.out.println(t.targetSum(a, 14));
	}
}