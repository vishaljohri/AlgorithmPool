
class SquareCell {
	int zerosRight = 0;
	int zerosBelow = 0;
}

public class MatrixPixel {

	void findSubsquare(int[][] matrix) {
		SquareCell[][] processed = processSquare(matrix);
		for (int i = matrix.length; i >= 1; i--) {
			boolean square = findSquareWithSize(processed, i);
			if (square)
				break;
		}
	}

	boolean findSquareWithSize(SquareCell[][] processed, int squareSize) {
		int count = processed.length - squareSize + 1;
		for (int row = 0; row < count; row++) {
			for (int col = 0; col < count; col++) {
				if (isSquare(processed, row, col, squareSize)) {
					System.out.println("square found with start row = " + row
							+ " column = " + col + " and size = " + squareSize);
					return true;
				}
			}
		}
		return false;
	}

	boolean isSquare(SquareCell[][] processed, int row, int col, int squareSize) {
		SquareCell topLeft = processed[row][col];
		SquareCell topRight = processed[row][col + squareSize - 1];
		SquareCell bottomLeft = processed[row + squareSize - 1][col];
		if (topLeft.zerosBelow != squareSize
				|| topLeft.zerosRight != squareSize
				|| topRight.zerosBelow != squareSize
				|| bottomLeft.zerosRight != squareSize)
			return false;
		else
			return true;
	}

	SquareCell[][] processSquare(int[][] matrix) {
		SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];
		for (int row = matrix.length - 1; row >= 0; row--) {
			for (int col = matrix.length - 1; col >= 0; col--) {
				processed[row][col] = new SquareCell();
				if (matrix[row][col] == 0) {
					if (row == matrix.length - 1)
						processed[row][col].zerosBelow = 1;
					else if (row != matrix.length - 1)
						processed[row][col].zerosBelow = processed[row + 1][col].zerosBelow + 1;
					if (col == matrix.length - 1)
						processed[row][col].zerosRight = 1;
					else if (col != matrix.length - 1)
						processed[row][col].zerosRight = processed[row][col + 1].zerosRight + 1;
				}
			}
		}
		return processed;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };
		MatrixPixel mp = new MatrixPixel();
		mp.processSquare(matrix);
		mp.findSubsquare(matrix);
	}

}
