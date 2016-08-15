import java.util.HashSet;

public class OddOccurences {
	
	// use XOR -> even occurences cancel each other
	void onlyOneOddNumber(int a[]) {
		int result = 0;
		for(int i : a) {
			result = result ^ i;
		}
		System.out.println(result);
	}
	
	// use HashSet -> for odd occurence add, for even remove
	void multipleOdd(int b[]) {
		HashSet<Integer> hs = new HashSet<>();
		for(int i : b) {
			if(hs.contains(i))
				hs.remove(i);
			else
				hs.add(i);
		}
		for(int j : hs) {
			System.out.print(j + " ");
		}
	}
	
	public static void main(String[] args) {
		OddOccurences o = new OddOccurences();
		int a[] = {4, 7, 2, 2, 5, 3, 5, 7, 7, 3, 4};
		int b[] = {1, 2, 1, 1, 2, 2, 1, 5, 7, 9, 9, 4};
		o.onlyOneOddNumber(a);
		o.multipleOdd(b);

	}

}
