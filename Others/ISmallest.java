
public class ISmallest {

	int partition(int[] a, int left, int right, int pivot) {
		while (left <= right) {
			while (a[left] < pivot)
				left++;
			while (a[right] > pivot)
				right--;
			if (left <= right) {
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}
		}
		return left - 1;
	}
	
	int rank(int a[], int left, int right, int rank) {
		int pivot = (left + right) / 2;
		int leftEnd = partition(a, left, right, a[pivot]);
		int leftSize = leftEnd - left + 1;
		
		if(leftSize == rank)
			return max(a, left, leftEnd);
		else if(leftSize > rank)
			return rank(a, left, leftEnd, rank);
		else 
			return rank(a, leftEnd + 1, right, rank - leftSize);
	}
	
	int max(int a[], int left, int LeftEnd) {
		int max = a[left];
		for(int i = left + 1; i <= LeftEnd; i++) {
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int a[] = { 0, 2, 1, 4, 6, 7, 5, 8 };
		ISmallest i = new ISmallest();
		System.out.println(i.rank(a, 0, a.length-1, 6));
		for(int j = 0; j < 6; j++) {
			System.out.println(a[j]);
		}
		

	}

}
