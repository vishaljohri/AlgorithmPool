
public class EggDrop {
	
	int minDropsUsingRecursion(int n, int k) {
		if(n == 0 || k == 0)
			return 0;
		if(n == 1)
			return k;
		
		int min = k;
		for(int i = 1; i <= k; i++) {
			int res = Math.max(minDropsUsingRecursion(n - 1, i - 1), minDropsUsingRecursion(n, k - i));
			if(res < min)
				min = res;
		}
		return 1 + min;
		
	}
	
	int minDropsUsingDP(int n, int k) {
		int minMatrix[][] = new int[n + 1][k + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= k; j++) {
				if(i == 0 || j == 0)
					minMatrix[i][j] = 0;
				else if(i == 1)
					minMatrix[i][j] = j;
				else {
					int min = Integer.MAX_VALUE;
					for(int x = 1; x <= j; x++) {
						int res = Math.max(minMatrix[i - 1][x - 1], minMatrix[i][j - x]);
						if(res < min)
							min = res;
					}
					minMatrix[i][j] = min + 1;
				}
			}
		}
		return minMatrix[n][k];
	}

	public static void main(String[] args) {
		EggDrop e = new EggDrop();
		System.out.println(e.minDropsUsingDP(2, 100));

	}

}
