
public class MatrixMaximum {

	int getMaxMatrix(int[][] matrix) {
		int maxArea = Integer.MIN_VALUE;
		int preprocessed[][] = getPreprocessed(matrix);
		for (int row1 = 0; row1 < matrix.length; row1++) {
			for (int row2 = row1; row2 < matrix.length; row2++) {
				for (int col1 = 0; col1 < matrix.length; col1++) {
					for (int col2 = col1; col2 < matrix.length; col2++) {
						maxArea = Math
								.max(maxArea,
										computeSum(preprocessed, row1, row2,
												col1, col2));
					}
				}
			}
		}
		return maxArea;
	}

	int computeSum(int preprocessed[][], int row1, int row2, int col1, int col2) {
		if (row1 == 0 && col1 == 0)
			return preprocessed[row2][col2];
		else if (row1 == 0)
			return preprocessed[row2][col2] - preprocessed[row2][col1 - 1];
		else if (col1 == 0)
			return preprocessed[row2][col2] - preprocessed[row1 - 1][col2];
		else
			return preprocessed[row2][col2] - preprocessed[row2][col1 - 1]
					- preprocessed[row1 - 1][col2]
					+ preprocessed[row1 - 1][col1 - 1];
	}

	int[][] getPreprocessed(int matrix[][]) {
		int preprocessed[][] = new int[matrix.length][matrix.length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				if (row == 0 && col == 0)
					preprocessed[row][col] = matrix[row][col];
				else if (row == 0)
					preprocessed[row][col] = preprocessed[row][col - 1]
							+ matrix[row][col];
				else if (col == 0)
					preprocessed[row][col] = preprocessed[row - 1][col]
							+ matrix[row][col];
				else
					preprocessed[row][col] = preprocessed[row][col - 1]
							+ preprocessed[row - 1][col]
							- preprocessed[row - 1][col - 1] + matrix[row][col];
			}
		}
		return preprocessed;
	}

	public static void main(String[] args) {
		int matrix[][] = {{1, 5, -8, 10}, {0, 5, 1, -2}, {-4, -2, 9, 1}, {2, 4, -6, 8}};
		MatrixMaximum mm = new MatrixMaximum();
		System.out.println("Maximum sum = " + mm.getMaxMatrix(matrix));

	}

}
