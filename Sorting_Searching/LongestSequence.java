
import java.util.Arrays;
import java.util.LinkedList;

public class LongestSequence {
	
	void longestSequence(int a[]) {
		int n = a.length;
		if(n == 0) {
			System.out.println("nothing in the array");
			return;
		}
		if(n == 1) {
			System.out.println(1);
		}
		int r[] = new int[n];
		int sequence[] = new int[n];
		for(int i = 0; i < r.length; i++) {
			r[i] = 1;
			sequence[i] = -1;
		}
		int maximum = 0;
		int bestEnd = 0;
		
		for(int i = 1; i < n; i++) {
			
			for(int j = i; j >= 0; j--) {
				if(a[i] > a[j] && r[i] < r[j] + 1) {
					r[i] = r[j] + 1;
					sequence[i] = j;
				}
			}
			if(r[i] > maximum) {
				maximum = r[i];
				bestEnd = i;
			}
		}
		
		System.out.println(Arrays.toString(r));
		System.out.println(maximum);
		System.out.println(Arrays.toString(sequence));
		
		int i = bestEnd;
		LinkedList<Integer> finalSequence = new LinkedList<>();
		//find sequence
		while(sequence[i] != -1) {
			finalSequence.addFirst(a[i]);
			i = sequence[i];
		}
		finalSequence.addFirst(a[i]);
		System.out.println("final sequence: " + (finalSequence));
	}

	public static void main(String[] args) {
		int a[] = {13, 14, 10, 11, 12};
		int a2[]=  { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		LongestSequence ls = new LongestSequence();
		ls.longestSequence(a);
		ls.longestSequence(a2);

	}

}
