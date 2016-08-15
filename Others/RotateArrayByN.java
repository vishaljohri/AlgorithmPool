import java.util.Arrays;


public class RotateArrayByN {
	
	void reverse(int a[], int start, int end) {
		while(start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
 		}
	}
	
	void rotateArray(int a[], int n) {
		if(n > a.length)
			return;
		reverse(a, 0, a.length - 1);
		reverse(a, 0, n - 1);
		reverse(a, n, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		RotateArrayByN r = new RotateArrayByN();
		int a[] = {0, 1, 2, 4, 5, 6, 7};
		r.rotateArray(a, 5);
	}
}
