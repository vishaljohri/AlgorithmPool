
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubsetProblem {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums.length == 0)
			return result;
		Arrays.sort(nums);
		int dp[] = new int[nums.length];
		int loc[] = new int[nums.length];
		int maxSize = 1;
		int endLoc = 0;
		dp[0] = 1;
		loc[0] = -1;
		for(int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			loc[i] = -1;
			for(int j = 0; j < i; j++) {
				if((nums[i] % nums[j] == 0) && ((1 + dp[j]) > dp[i])) {
					dp[i] = 1 + dp[j];
					loc[i] = j;
				}
			}
			if(dp[i] > maxSize) {
				maxSize = dp[i];
				endLoc = i;
			}
		}		
		while(loc[endLoc] != -1) {
			result.add(nums[endLoc]);
			endLoc = loc[endLoc];
		}
		result.add(nums[endLoc]);
		return result;
	}

	public static void main(String[] args) {
		LargestDivisibleSubsetProblem l = new LargestDivisibleSubsetProblem();
		int nums[] = {1, 2, 4, 8, 12, 24};
		System.out.println(l.largestDivisibleSubset(nums));
	}
}
