
import java.util.Arrays;

public class CurrencyExchange {
	
	int makeChange(int n, int denoms[], int index) {
		if(index == denoms.length-1)
			return 1;
		int ways = 0;
		int denomValue = denoms[index];
		for(int i = 0; i * denomValue <= n; i++) {
			ways += makeChange(n - i * denomValue, denoms, index+1);
		}
		return ways;
	}
	int change(int n) {
		int denoms[] = {25, 10, 5, 1};
		// return makeChange(n, denoms, 0);
		return makeChangeUsingDP(n, denoms);
	}
	
	int makeChangeUsingDP(int n, int denoms[]) {
		Arrays.sort(denoms);
		int dp[][] = new int[denoms.length][n + 1];
		//fill 0th column with 1
		for(int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		//fill first row with 1
		for(int i = 0; i <= n; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j <= n; j++) {
				int currentCurrency = denoms[i];
				if(j < currentCurrency)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - currentCurrency];
			}
		} 
		
		return dp[dp.length - 1][n];
	}

	public static void main(String[] args) {
		CurrencyExchange currency = new CurrencyExchange();
		System.out.println("ways: " + currency.change(10));

	}

}
