
public class MatrixSearch {
	
	boolean searchMatrix(int a[][], int key) {
		int row = 0;
		int col = a[0].length - 1;
		
		while(row <= a.length-1 && col >= 0) {
			if(a[row][col] == key)
				return true;
			if(a[row][col] > key)
				col--;			
			else
				row++;
		}
		return false;
	}

	public static void main(String[] args) {
		int a[][] = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
		MatrixSearch ms = new MatrixSearch();
		System.out.println(ms.searchMatrix(a, 55));

	}

}
