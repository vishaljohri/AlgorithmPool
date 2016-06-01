
public class BinarySearch {
	
	int binarySearchIterative(int a[], int k) {
		int n = a.length - 1;
		int start = 0;
		int end = n;
		int mid;
		while(start <= end) {
			mid = (start + end)/2;
			if(a[mid] == k)
				return mid;
			else if(a[mid] < k) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return -1;
		
	}
	
	int binarySearchRecursive(int a[], int start, int end, int k) {
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		if(a[mid] == k) {
			return mid;
		}
		else if(a[mid] < k) {
			return binarySearchRecursive(a, mid+1, end, k);
		}
		else {
			return binarySearchRecursive(a, start, mid-1, k);
		}
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 6, 2, 7, 5, 9};
		BinarySearch bs = new BinarySearch();
		System.out.println("Iterartive: " + bs.binarySearchIterative(a, 5));
		System.out.println("Iterartive: " + bs.binarySearchRecursive(a, 0, a.length-1, 5));
	}

}
