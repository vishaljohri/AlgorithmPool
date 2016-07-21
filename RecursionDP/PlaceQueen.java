
import java.util.ArrayList;
import java.util.Arrays;

public class PlaceQueen {
	
	void keepQueen(Integer []columns, int row, ArrayList<Integer[]> results) {
		
		//found the valid placement
		if(row == 8) {
			results.add(columns.clone());
		}
		else {
			for(int col = 0; col < 8; col++) {
				if(isValid(columns, row, col)) {
					columns[row] = col;
					keepQueen(columns, row+1, results);
				}
			}
		}
		
	}
	
	boolean isValid(Integer []columns, int row1, int col1) {
		
		for(int row2 = 0; row2 < row1; row2++) {
			int col2 = columns[row2];
			
			//Check if row2,col2 invalidates row1,col1
			
			//same column
			if(col1 == col2)
				return false;
			
			//diagonal same
			int columnDistance = Math.abs(col1 - col2);
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		PlaceQueen pq = new PlaceQueen();
		Integer columns[] = new Integer[8];
		ArrayList<Integer[]> results = new ArrayList<>();
		pq.keepQueen(columns, 0, results);
		
		int count = 0;
		for(Integer[] a : results) {
			count++;
			System.out.println(Arrays.toString(a));
		}
		System.out.println("number of combinations are: " + count);
		

	}

}
