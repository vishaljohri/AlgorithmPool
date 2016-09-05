class Matrix {
	int dimensionFirst;
	int dimensionSecond;
	public Matrix(int dimensionFirst, int dimensionSecond) {
		this.dimensionFirst = dimensionFirst;
		this.dimensionSecond = dimensionSecond;
	}
}

public class MatrixMultiplication {
	
	// return minimum cost to multiply chain of matrices
	int minCost(Matrix matrix[]) {
		int dp[][] = new int[matrix.length][matrix.length];
		
		for (int l = 0; l < matrix.length; l++) {
			int j = l;
			for (int i = 0; i < matrix.length - l; i++) {
				if (i == j) {
					j++;
					continue;
				}
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]
							+ matrix[i].dimensionFirst
							* matrix[k].dimensionSecond
							* matrix[j].dimensionSecond + dp[k + 1][j]);
				}
				j++;
			}
		}
		return dp[0][matrix.length - 1];
	}

	public static void main(String[] args) {
		MatrixMultiplication m = new MatrixMultiplication();
		Matrix matrix[] = {new Matrix(2, 3), new Matrix(3, 6), new Matrix(6, 4), new Matrix(4, 5)};
		System.out.println(m.minCost(matrix));
	}
}