import java.util.HashMap;

public class MaximumSubArraySumK {
	
	public int maxSubArrayLen(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(sum == k)
				maxLength = i + 1;
			else if(hm.containsKey(sum - k))
				maxLength = Math.max(maxLength, i - hm.get(sum - k));
			if(!hm.containsKey(sum))
				hm.put(sum, i);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		MaximumSubArraySumK m = new MaximumSubArraySumK();
		int nums[] = {-2, -1, 2, 1};
		System.out.println(m.maxSubArrayLen(nums, 1));
	}
}