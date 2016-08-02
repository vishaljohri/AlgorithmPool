
public class SplitCandies {
	
	int totalCandies(int a[]) {
		int n = a.length;
		if(n <= 1)
			return n;
		int candies[] = new int[n];
		candies[0] = 1;
		
		//left -> right, if element is greater than left give more candies.
		for(int i = 1; i < n; i++) {
			if(a[i] > a[i - 1])
				candies[i] = candies[i - 1] + 1;
			else
				candies[i] = 1;
		}
		
		//right -> left, if element is greater than right give more candies
		for(int i = n - 2; i >= 0; i--) {
			if(a[i] > a[i + 1]) {
				if(candies[i] <= candies[i + 1])  //if not true, condition is already satisfied by previous traversal
					candies[i] = candies[i + 1] + 1;
			}
				
		}
		
		int result = 0;
		//sum all the candies
		for(int i = 0; i < n; i++) {
			result += candies[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		SplitCandies s = new SplitCandies();
		int a[] = {4, 2, 3, 4, 1};
		System.out.println(s.totalCandies(a));

	}

}
