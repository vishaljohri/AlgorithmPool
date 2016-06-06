
public class SearchRotated {
	
	int search(int a[], int start, int end, int k) {
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(a[mid] == k)
			return mid;
		
		if(a[start] < a[mid]) { //left side is normally ordered
			if(k >= a[start] && k <= a[mid])
				return search(a, start, mid-1, k);
			else
				return search(a, mid+1, end, k);
		}
		else if(a[start] > a[mid]) { //right side is normally ordered
			if(k >= a[mid] && k <= a[end])
				return search(a, mid+1, end, k);
			else
				return search(a, start, mid-1, k);
		}
		else {
			if(a[mid] != a[end]) {
				return search(a, mid+1, end, k);
			}
			else {
				int result = search(a, start, mid-1, k);
				if(result == -1)
					return search(a, mid+1, end, k);
				else 
					return result;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int a2[] = {2, 2, 2, 3, 4, 2};
		SearchRotated sr = new SearchRotated();
		System.out.println(sr.search(a, 0, a.length-1, 25));
		System.out.println(sr.search(a2, 0, a2.length-1, 4));

	}

}
