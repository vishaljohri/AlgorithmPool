
public class MaximumOnesInRow {
	
	// find row containing maximum no of 1s
	// each row has first 0s and then 1s
	void maximumOnes(int a[][]) {
		int resultRow = -1;
		int maxCount = 0;
		int row = 0;
		int column = a[0].length - 1;
		int count = 0;
		while(row < a.length && column >= 0) {
			while(column >= 0 && a[row][column] == 1) {
				count++;
				column--;
			}
			if(count > maxCount) {
				maxCount = count;
				resultRow = row;
			}
			row++;
		}
		System.out.println(resultRow + " " + maxCount);
	}

	public static void main(String[] args) {
		MaximumOnesInRow m = new MaximumOnesInRow();
		int a[][] = {{0, 0, 0, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
		m.maximumOnes(a);
	}
}
