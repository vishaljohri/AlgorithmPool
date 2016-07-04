package leetcode.ques;

public class CoinExchange {

	public int coinChange(int[] coins, int amount) {
		if(coins == null || amount <= 0 || coins.length == 0)
			return 0;
		int numberCoins = coins.length;
		int coinMatrix[] = new int[amount + 1];
		
		for(int i = 1; i <= amount; i++) {
			coinMatrix[i] = Integer.MAX_VALUE;
			for(int j = 0; j < numberCoins; j++) {
				if(coins[j] <= i && coinMatrix[i - coins[j]] != Integer.MAX_VALUE) {
					coinMatrix[i] = Math.min(coinMatrix[i], 1 + coinMatrix[i - coins[j]]);
				}
			}
		}
		if(coinMatrix[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return coinMatrix[amount];
	}

	public static void main(String[] args) {
		int coins[] = {5, 4, 2, 1};
		CoinExchange c = new CoinExchange();
		System.out.println(c.coinChange(coins, 10));

	}

}
