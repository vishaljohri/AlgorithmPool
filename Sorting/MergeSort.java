import java.util.Arrays;


public class MergeSort {
	
	int merge(int numbers[], int start, int mid, int end) {
		int firstArray[] = Arrays.copyOfRange(numbers, start, mid+1);
		int secondArray[] = Arrays.copyOfRange(numbers, mid+1, end+1);
		
		int pointerFirst = 0;
		int pointerSecond = 0;
		int i = start;
		while((pointerFirst < firstArray.length) && (pointerSecond < secondArray.length)) {
			if(firstArray[pointerFirst] < secondArray[pointerSecond]) {
				numbers[i++] = firstArray[pointerFirst++];
			}
			else {
				numbers[i++] = secondArray[pointerSecond++];
			}
		}
		
		if(pointerFirst < firstArray.length) {
			for(int j = pointerFirst; j < firstArray.length; j++) {
				numbers[i++] = firstArray[j];
			}
		}
		else {
			for(int j = pointerSecond; j < secondArray.length; j++) {
				numbers[i++] = secondArray[j];
			}
		}
		
		return 1;
	}
	
	void mergeSort(int numbers[], int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(numbers, start, mid);
			mergeSort(numbers, mid+1, end);
			merge(numbers, start, mid, end);
		}
	}

	public static void main(String[] args) {
		int numbers[] = {5, 4, 1, 3, 2, 9, 7, 8, 6};
		System.out.println("before merging: " + Arrays.toString(numbers));
		MergeSort ms = new MergeSort();
		ms.mergeSort(numbers, 0, numbers.length-1);
		System.out.println("after merging: " + Arrays.toString(numbers));
	}

}
