
import java.util.Arrays;

public class RearrangeArray {
	
	void rotateRight(int a[], int start, int end) {
		int temp = a[end];
		for(int i = end; i > start; i--) {
			a[i] = a[i - 1];
		}
		a[start] = temp;
	}
	
	void rearrangeArrayWithAlternateSignedItems(int a[]) {
		int outOfOrderIndex = -1;
		for(int i = 0; i < a.length; i++) {
			if(outOfOrderIndex >= 0) {
				if((a[outOfOrderIndex] < 0 && a[i] >= 0)
						|| (a[outOfOrderIndex] >= 0 && a[i] < 0)) {
					rotateRight(a, outOfOrderIndex, i);
					if(i - outOfOrderIndex >= 2)
						outOfOrderIndex += 2;
					else
						outOfOrderIndex = -1;
				}
			}
			else {
				if((i % 2 == 0 && a[i] >= 0)
						|| (i % 2 == 1 && a[i] < 0)) {
					outOfOrderIndex = i;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		RearrangeArray r = new RearrangeArray();
		int a[] = {-5, -2, -5, 2, 4, 7, 1, 8, 0, -8};
		r.rearrangeArrayWithAlternateSignedItems(a);
		

	}

}
