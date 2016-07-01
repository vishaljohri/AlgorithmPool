
public class MatrixSearch {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)
			return false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		int end = rows * cols - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			int i = mid / cols;
			int j = mid % cols;
			if(matrix[i][j] == target)
				return true;
			else if(matrix[i][j] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int a[][] = {{0, 3, 5, 7}, {10, 11, 16, 20}, {23, 31, 34, 50}};
		MatrixSearch m = new MatrixSearch();
		System.out.println(m.searchMatrix(a, 7));
	}

}
