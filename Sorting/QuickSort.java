import java.util.Arrays;


public class QuickSort {

	public static void main(String[] args) {
		int numbers[] = {5, 4, 1, 3, 2, 9, 7, 8, 6};
		System.out.println("before merging: " + Arrays.toString(numbers));
		QuickSort qs = new QuickSort();
		qs.quickSort(numbers, 0, numbers.length-1);
		System.out.println("after merging: " + Arrays.toString(numbers));

	}

	private void quickSort(int[] numbers, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivot = numbers[(start + end)/2];
		int i = start;
		int j = end;
		while(i <= j) {
			while(numbers[i] < pivot) {
				i++;
			}
			while(numbers[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}
			
			quickSort(numbers, start, j);		
			quickSort(numbers, i, end);
	}

}
