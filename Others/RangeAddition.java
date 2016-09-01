import java.util.Arrays;

public class RangeAddition {
	// update array of size length by incrementing it's elements 
	// by number and range given in updates[][]
	 public int[] getModifiedArray(int length, int[][] updates) {
		 int a[] = new int[length];
		 for(int i[] : updates) {
			 int start = i[0];
			 int end = i[1];
			 int increment = i[2];
			 a[start] += increment;
			 if(end < length)
				 a[end + 1] -= increment; 
		 }
		 
		 for(int i = 1; i < length; i++) {
			 a[i] += a[i - 1];
		 }
		 return a;
	 }

	public static void main(String[] args) {
		RangeAddition r = new RangeAddition();
		int updates[][] = {{1, 3, 2}, {2, 3, 3}};
		System.out.println(Arrays.toString(r.getModifiedArray(5, updates)));
	}
}