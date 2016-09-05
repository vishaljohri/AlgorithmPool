public class MaximumAmount {

	// a[] is a set of coins.
	// game is played between 2 players.
	// on his turn, player can pick first or last coin from a[]
	// if player1 starts, find how much maximum he can win
	int maximumAmount(int a[]) {
		int dp[][] = new int[a.length][a.length];
		for (int k = 0; k < a.length; k++) {
			int j = k;
			for (int i = 0; i < a.length - k; i++) {
				if (j == i) {
					dp[i][j] = a[i];
				} else if (j == (i + 1)) {
					dp[i][j] = Math.max(a[j], a[i]);
				} else {
					dp[i][j] = Math.max(
							a[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
							a[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}
				j++;
			}
		}
		return dp[0][a.length - 1];
	}

	public static void main(String[] args) {
		MaximumAmount m = new MaximumAmount();
		int a[] = {8, 15, 3, 7};
		System.out.println(m.maximumAmount(a));
	}
}