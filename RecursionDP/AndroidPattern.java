package leetcode.ques;

public class AndroidPattern {

	int result = 0;

	public int numberOfPatterns(int m, int n) {
		/*
		 * for(int i = 0; i < 3; i++) { for(int j = 0; j < 3; j++) { boolean
		 * visited[][] = new boolean[3][3]; countCombinations(i, j, -1, -1, m,
		 * n, 1, visited); System.out.println("done"); } }
		 */
		// 1, 3, 7, 9 are symmetric and 2, 4, 6, 8 are symmetric
		int finalCount = 0;
		boolean visited[][] = new boolean[3][3];
		countCombinations(0, 0, -1, -1, m, n, 1, visited);
		finalCount = result * 4;

		result = 0;
		visited = new boolean[3][3];
		countCombinations(0, 1, -1, -1, m, n, 1, visited);
		finalCount += result * 4;

		result = 0;
		visited = new boolean[3][3];
		countCombinations(1, 1, -1, -1, m, n, 1, visited);
		finalCount += result;
		return finalCount;
	}

	void countCombinations(int curRow, int curCol, int prevRow, int prevCol,
			int m, int n, int curLength, boolean visited[][]) {
		if (curRow == -1 || curCol == -1 || curRow == 3 || curCol == 3
				|| curLength > n || visited[curRow][curCol])
			return;

		if (prevRow != -1) {
			// same row
			if (prevRow == curRow && Math.abs(prevCol - curCol) != 1
					&& !visited[curRow][1])
				return;

			// same col
			if (prevCol == curCol && Math.abs(prevRow - curRow) != 1
					&& !visited[1][curCol])
				return;

			// same diagonal
			if (((Math.abs(prevRow - prevCol) == Math.abs(curRow - curCol)) || (prevRow
					+ prevCol == curRow + curCol))
					&& prevRow != 1 && curRow != 1 && !visited[1][1])
				return;
		}

		visited[curRow][curCol] = true;

		if (curLength >= m && curLength <= n) {
			result++;
		}

		// visit all other cells
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				countCombinations(i, j, curRow, curCol, m, n, curLength + 1,
						visited);
			}
		}
		visited[curRow][curCol] = false;
	}

	public static void main(String[] args) {
		AndroidPattern ap = new AndroidPattern();
		System.out.println(ap.numberOfPatterns(2, 2));
	}
}