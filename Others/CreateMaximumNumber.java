
import java.util.Arrays;

public class CreateMaximumNumber {
	
	int[] maxArray(int a[], int k) {
		int max[] = new int[k];
		if(k == 0)
			return max;
		max[0] = a[0];
		int top = 0;
		for(int i = 1; i < a.length; i++) {
			while(top >= 0 && a[i] > max[top] && k - top <= a.length - i) top--;
			if(top < k - 1) 
				max[++top] = a[i];
		}
		return max;
	}
	
	int[] merge(int num1[], int num2[], int k) {
		int merged[] = new int[k];
		int location = 0;
		int pointer1 = 0;
		int pointer2 = 0;
		while(pointer1 < num1.length && pointer2 < num2.length) {
			if(num1[pointer1] > num2[pointer2])
				merged[location++] = num1[pointer1++];
			else if(num1[pointer1] < num2[pointer2])
				merged[location++] = num2[pointer2++];
			else {
				int temp1 = pointer1;
				int temp2 = pointer2;
				while(temp1 < num1.length && temp2 < num2.length && num1[temp1] == num2[temp2]) {
					temp1++;
					temp2++;
				}
				if(temp1 == num1.length && temp2 == num2.length) 
					merged[location++] = num1[pointer1++];
				else if(temp1 == num1.length && temp2 < num2.length)
					merged[location++] = num2[pointer2++];
				else if(temp2 == num2.length && temp1 < num1.length)
					merged[location++] = num1[pointer1++];
				else {
					if(num1[temp1] > num2[temp2])
						merged[location++] = num1[pointer1++];
					else
						merged[location++] = num2[pointer2++];
				}
					
			}
		}
		if(pointer2 == num2.length) {
			while(pointer1 < num1.length)
				merged[location++] = num1[pointer1++];
		}
		else if(pointer1 == num1.length) {
			while(pointer2 < num2.length)
				merged[location++] = num2[pointer2++];
		}
		return merged;
	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int result[] = new int[k];
		
		for(int i = Math.max(0, k - n2); i <= k && i <= n1; i++) {
			int candidate[] = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			//compare candidate and result
			int c = 0;
			for(int j = 0; j < k; j++) {
				if(candidate[j] > result[j]) {
					c = 1;
					break;
				}
				else if(result[j] > candidate[j]) {
					break;
				}
			}
			if(c == 1) {
				result = Arrays.copyOf(candidate, k);
			}
		}
		return result;
	}
 
	public static void main(String[] args) {
		int num1[] = {6, 7};
		int num2[] = {6, 0, 4};
		CreateMaximumNumber c = new CreateMaximumNumber();
		System.out.println(Arrays.toString(c.maxNumber(num1, num2, 2)));

	}

}
