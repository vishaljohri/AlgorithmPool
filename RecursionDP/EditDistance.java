
public class EditDistance {

	int minDistanceUsingRecursion(String str1, String str2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return minDistanceUsingRecursion(str1, str2, m - 1, n - 1);
		else {
			return 1 + minUtility(
					minDistanceUsingRecursion(str1, str2, m, n - 1), // Insert
					minDistanceUsingRecursion(str1, str2, m - 1, n), // Remove
					minDistanceUsingRecursion(str1, str2, m - 1, n - 1)); // Replace
		}
	}
	
	int minUtility(int a, int b, int c) {
		int min = Math.min(a, b);
		return Math.min(min, c);
	}
	
	int minDistanceUsingDP(String str1, String str2, int m, int n) {
		int minMatrix[][] = new int[m + 1][n + 1];
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0)
					minMatrix[i][j] = j;
				else if(j == 0)
					minMatrix[i][j] = i;
				else if(str1.charAt(i - 1) == str2.charAt(j - 1))
					minMatrix[i][j] = minMatrix[i - 1][j - 1];
				else {
					minMatrix[i][j] = 1 + minUtility(minMatrix[i][j - 1], minMatrix[i - 1][j], minMatrix[i - 1][j - 1]);
				}
			}
		}
		return minMatrix[m][n];
	}

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String str1 = "dinitrophenylhydrazine";
		String str2 = "benzalphenylhydrazone";
		System.out.println(ed.minDistanceUsingDP(str1, str2, str1.length(), str2.length()));

	}

}
