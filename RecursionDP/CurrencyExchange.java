
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
		return makeChange(n, denoms, 0);
	}

	public static void main(String[] args) {
		CurrencyExchange currency = new CurrencyExchange();
		System.out.println("ways: " + currency.change(10));

	}

}
