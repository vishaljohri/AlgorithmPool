import java.util.Arrays;


public class HeapSort {
	
	void heapify(int a[], int i, int size) {
		//assumes that subtree of ith node is having heap structure
		//creates max-heap with biggest element at top
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if(left < size && a[left] > a[largest]) {
			largest = left;
		}
		if(right < size && a[right] > a[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			//swap largest and i
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			
			//now position largest has smallest value, so call method recursively
			heapify(a, largest, size);
		}
	}
	
	void buildHeap(int []a) {
		//construct heap in bottom-up manner, leaving last half of array which will be leaves
		for(int i = (a.length-1)/2; i >= 0; i--) {
			heapify(a, i, a.length);
		}
	}
	
	void heapSort(int []a) {
		int n = a.length;
		buildHeap(a);
		
		int size = a.length-1;
		for(int i = n-1; i >= 1; i--) {
			//swap 0 and ith element
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			
			//call heapify to reconstruct heap
			heapify(a, 0, size--);
		}
		
		System.out.println("sorted array: " + Arrays.toString(a));
	}

	public static void main(String[] args) {
		int a[] = {4, 10, 3, 5, 1, 9, 0, 4, 15, 17, 8};
		HeapSort h = new HeapSort();
		h.heapSort(a);

	}

}
