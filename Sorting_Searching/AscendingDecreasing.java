import java.util.Arrays;

public class AscendingDecreasing {
	
	// sort odd numbered elements in ascending order and even numbered in decreasing order
	void sortInAscendingDecreasing(int a[]) {
		if(a.length % 2 == 0) {
			sortQuick(a, 0, a.length - 2, true);
			sortQuick(a, 1, a.length - 1, false);
		}
		else {
			sortQuick(a, 0, a.length - 1, true);
			sortQuick(a, 1, a.length - 2, false);
		}
		System.out.println(Arrays.toString(a));
	}
	
	void sortQuick(int a[], int start, int end, boolean isAscending) {
		if(start >= end)
			return;
		int pivot = a[start];
		int i = start;
		int j = end;
		while(i <= j) {
			if(isAscending) {
				while(i <=j && a[i] < pivot)
					i += 2;
				while(j >= i && a[j] > pivot)
					j -= 2;
			}
			else {
				while(i <=j && a[i] > pivot)
					i += 2;
				while(j >= i && a[j] < pivot)
					j -= 2;
			}
			if(i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i += 2;
				j -= 2;
			}
		}
		sortQuick(a, start, j, isAscending);
		sortQuick(a, i, end, isAscending);
	}

	public static void main(String[] args) {
		AscendingDecreasing ad = new AscendingDecreasing();
		int a[] = {4, 6, 2, 1, 8, 9, 5};
		ad.sortInAscendingDecreasing(a);
	}
}
