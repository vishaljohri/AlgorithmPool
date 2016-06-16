
public class MagicIndex {
	
	int magicNumber(int a[], int start, int end) {
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(mid == a[mid])
			return mid;
		if(a[mid] < mid)
			return magicNumber(a, mid+1, end);
		else
			return magicNumber(a, start, mid-1);
		
	}
	
	int magicRepetitionAllowed(int a[], int start, int end) {
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(mid == a[mid])
			return mid;
		
		//search left
		int left =  magicRepetitionAllowed(a, start, Math.min(mid-1, a[mid]));
		if(left >= 0)
			return left;
		
		//search right
		int right = magicRepetitionAllowed(a, Math.max(mid+1, a[mid]), end);
		return right;
		
	}

	public static void main(String[] args) {
		MagicIndex m = new MagicIndex();
		int []a = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		System.out.println("Magic number: " + m.magicNumber(a, 0, a.length-1));
		
		int r[] = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println("Magic number with repetition allowed: " + m.magicRepetitionAllowed(r, 0, r.length-1));

	}

}
