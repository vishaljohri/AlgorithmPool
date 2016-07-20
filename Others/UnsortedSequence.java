
public class UnsortedSequence {
	
	void findIndeces(int []a) {
		
		int leftEnd = findLeftSubsequence(a);
		if(leftEnd == a.length-1) {
			System.out.println("already sorted");
			return;
		}
			
		int rightStart = findRightSubsequence(a);
		
		int minIndex = rightStart;
		int maxIndex = leftEnd;
		for(int i = leftEnd+1; i < rightStart; i++) {
			if(a[i] < a[minIndex])
				minIndex = i;
			if(a[i] > a[maxIndex])
				maxIndex = i;
		}
		
		int leftIndex = shrinkLeft(a, a[minIndex], leftEnd);
		int rightIndex = shrinkRight(a, a[maxIndex], rightStart);
		
		System.out.println("left Index = " + leftIndex + " Right Index = " + rightIndex);
		
	}
	
	int findLeftSubsequence(int a[]) {
		int cur = 0;
		for(int i = 0; i < a.length-1; i++) {
			if(a[i] > a[i+1])
				return cur;
			else
				cur++;
		}
		return cur;
	}
	
	int findRightSubsequence(int []a) {
		int cur = a.length-1;
		for(int i = a.length-1; i >= 1; i--) {
			if(a[i] < a[i-1])
				return cur;
			else
				cur--;
		}
		return cur;
	}
	
	int shrinkLeft(int []a, int minNumber, int leftEnd) {
		int i = leftEnd;
		for(i = leftEnd; i >= 0; i--) {
			if(a[i] > minNumber)
				continue;
			else
				break;
		}
		return i+1;
	}
	
	int shrinkRight(int []a, int maxNumber, int rightStart) {
		int i = rightStart;
		for(i = rightStart; i <= a.length-1; i++) {
			if(a[i] < maxNumber)
				continue;
			else
				break;
		}
		return i-1;
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		UnsortedSequence u = new UnsortedSequence();
		u.findIndeces(a);

	}

}
