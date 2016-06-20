
public class LongestIncPathMatrix {
	
	int dp[][];
	int maxLength;
	int longestIncreasingPath(int matrix[][]) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		dp = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dp[i][j] = findPath(matrix, i, j);
			}
		}
		return maxLength;
	}
	
	int findPath(int matrix[][], int i, int j) {
		if(dp[i][j] > 0)
			return dp[i][j];
		
		//get values for all four directions
		int left, right, top, bottom;
		left = right = top = bottom = 0;
		dp[i][j] = 1;
		
		if(matrix[Math.max(0, i - 1)][j] > matrix[i][j])
			top = findPath(matrix, i - 1, j);
		if(matrix[Math.min(i + 1, matrix.length - 1)][j] > matrix[i][j])
			bottom = findPath(matrix, i + 1, j);
		if(matrix[i][Math.max(0, j - 1)] > matrix[i][j])
			left = findPath(matrix, i, j - 1);
		if(matrix[i][Math.min(j + 1, matrix[0].length - 1)] > matrix[i][j])
			right = findPath(matrix, i, j + 1);
		
		dp[i][j] = findMax(left, right, top, bottom) + 1;
		if(dp[i][j] > maxLength)
			maxLength = dp[i][j];
		return dp[i][j];
	} 
	
	int findMax(int a, int b, int c, int d) {
		int m1 = Math.max(a, b);
		int m2 = Math.max(c, d);
		return Math.max(m1, m2);
	}

	public static void main(String[] args) {
		int a[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
		LongestIncPathMatrix l = new LongestIncPathMatrix();
		System.out.println(l.longestIncreasingPath(a));

	}

}
