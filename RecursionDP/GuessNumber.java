
public class GuessNumber {
	public int getMoneyAmount(int n) {
		int dp[][] = new int[n + 1][n + 1];
		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					int curCost = 0;
					if (k == j)
						curCost = k + dp[i][k - 1];
					else
						curCost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
					dp[i][j] = Math.min(dp[i][j], curCost);
				}
			}
		}
		return dp[1][n];
	}

	public static void main(String[] args) {
		GuessNumber gm = new GuessNumber();
		System.out.println(gm.getMoneyAmount(7));
	}
}