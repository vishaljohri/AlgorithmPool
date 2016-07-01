
public class SquareRoot {
	
	int sqroot(int n) {
		
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		//use binary search algo
		int start = 1;
		int end = n;
		int squareRoot = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(mid * mid == n)
				return mid;
			if(mid * mid < n) {
				start = mid + 1;
				squareRoot = mid;
			}
			else {
				end = mid - 1;
			}
		}
		return squareRoot;
	}

	public static void main(String[] args) {
		SquareRoot sr = new SquareRoot();
		System.out.println(sr.sqroot(19));

	}

}
