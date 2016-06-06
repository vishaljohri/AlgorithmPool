
import java.util.Arrays;

public class MergeArays {
	
	void optimizedMerge(int a[], int b[], int lastA, int lastB) {
		int mergedIndex = lastA + lastB + 1;
		
		while(lastB >= 0) {
			if(lastA >= 0 && a[lastA] > b[lastB]) {
				a[mergedIndex] = a[lastA];
				lastA--;
			}
			else {
				a[mergedIndex] = b[lastB];
				lastB--;
			}
			mergedIndex--;
		}
	}

	public static void main(String[] args) {
		int a[] = new int[10];
		a[0] = 2;
		a[1] = 4;
		a[2] = 5;
		a[3] = 7;
		a[4] = 8;
		int b[] = {1, 2, 3, 6, 9};
		MergeArays m = new MergeArays();
				
		m.optimizedMerge(a, b, 4, 4);
		System.out.println("optimized implementation: " + Arrays.toString(a));

	}

}
