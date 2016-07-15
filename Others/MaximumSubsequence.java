
public class MaximumSubsequence {
	
	void bruteForce(int []a) {
		int max = 0;
		int start = 0;
		int end = 0;
		int sum;
		for(int i = 0; i < a.length; i++) {
			sum = 0;
			for(int j = i; j < a.length; j++) {
				sum += a[j];
				if(sum > max) {
					max = sum;
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("Maximum Subsequence has value: " + max + " start index: " + start + " end index: " + end);
	}
	
	void singleIteration(int []a) {
		int maxSum = 0;
		int sum = 0;
		int start = 0;
		int maxEnd = 0;
		int maxStart = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			if(sum < 0) {
				sum = 0;
				start = i + 1;
			}
			else if(sum > maxSum) {
				maxSum = sum;
				maxEnd = i;
				maxStart = start;
			}
		}
		System.out.println("Maximum Subsequence has value: " + maxSum + " start index: " + maxStart + " end index: " + maxEnd);
		
	}
	
	public static void main(String[] args) {
		int a[] = {2, -8, 3, -2, 4, -10};
		MaximumSubsequence m = new MaximumSubsequence();
		m.bruteForce(a);
		m.singleIteration(a);

	}

}
