
import java.util.Arrays;

public class WiggleMaximum {
	
	public int wiggleMaxLength(int[] nums) {
		if(nums.length < 2)
			return nums.length;
		int current = 0;
		while(current < nums.length - 1 && nums[current] == nums[current + 1]) {
			current++;
		}
		if(current == nums.length - 1)
			return 1;
		boolean isSmallNext = nums[current] < nums[current + 1];
		int resultLength = 0;
		nums[resultLength++] = nums[current];
		nums[resultLength++] = nums[current + 1];
		current += 2;
		
		while(current < nums.length) {
			if(isSmallNext) {
				if(nums[current] < nums[resultLength - 1]) {
					nums[resultLength++] = nums[current];
					isSmallNext = !isSmallNext;
				}
				else {
					nums[resultLength - 1] = nums[current];
				}
			}
			else {
				if(nums[current] > nums[resultLength - 1]) {
					nums[resultLength++] = nums[current];
					isSmallNext = !isSmallNext;
				}
				else {
					nums[resultLength - 1] = nums[current];
				}
			}
			current++;
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, resultLength)));
		return resultLength;
	}
	
	public static void main(String[] args) {
		WiggleMaximum wm = new WiggleMaximum();
		int a[] = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
		System.out.println(wm.wiggleMaxLength(a));

	}

}
