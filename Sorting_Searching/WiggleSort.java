package leetcode.ques;
import java.util.Arrays;

public class WiggleSort {
	
	void swap(int a[], int loc1, int loc2) {
		int temp = a[loc1];
		a[loc1] = a[loc2];
		a[loc2] = temp;
	}
	// wiggle sort given array
	void wiggleSort(int a[]) {
		boolean less = true;
		for(int i = 0; i < a.length - 1; i++) {
			if(less) {
				if(a[i] > a[i + 1])
					swap(a, i, i + 1);
			}
			else {
				if(a[i] < a[i + 1])
					swap(a, i, i + 1);
			}
			less = !less;
		}
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		WiggleSort ws = new WiggleSort();
		int a[] = {3, 5, 2, 1, 6, 4};
		ws.wiggleSort(a);
	}
}