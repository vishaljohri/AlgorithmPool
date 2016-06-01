import java.util.Arrays;


public class RadixSort {
	
	void countSort(int []a, int exp) {
		int n = a.length;
		int count[] = new int[10];
		int output[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			count[(a[i] / exp) % 10]++;
		}
		
		for(int i = 1; i < 10; i++) {
			count[i] = count[i-1] + count[i];
		}
		
		//map a->count and count->output
		for(int i = n-1; i >= 0; i--) {
			output[count[(a[i] / exp) % 10]-1] = a[i];
			count[(a[i] / exp) % 10]--;
		}
		
		for(int i = 0; i < n; i++) {
			a[i] = output[i];
		}
	}

	public static void main(String[] args) {
		int a[] = {1, 4, 1, 2, 7, 5, 2};
		RadixSort rs = new RadixSort();
		rs.countSort(a, 1);
		System.out.println(Arrays.toString(a));
		
		//implement radix sort
		int r[] = {170, 45, 75, 90, 802, 24, 2, 66};
		//find max
		int max = r[0];
		for(int i = 1; i < r.length; i++) {
			if(max < r[i])
				max = r[i];
		}
		
		for(int exp = 1; max/exp > 0; exp *= 10) {
			rs.countSort(r, exp);
		}
		System.out.println(Arrays.toString(r));
	}

}
