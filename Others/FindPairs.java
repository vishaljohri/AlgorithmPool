
import java.util.Arrays;
import java.util.HashMap;

public class FindPairs {

	void pairs(int a[], int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!hm.containsKey(a[i]))
				hm.put(a[i], 1);
			else
				hm.put(a[i], hm.get(a[i]) + 1);
		}

		for (int i = 0; i < a.length; i++) {

			int cur = a[i];
			// remove current element from hm
			hm.put(a[i], hm.get(a[i]) - 1);
			// get the diff number to check
			int diff = sum - cur;
			// check if diff number exists in hm with value greater than 0
			if (hm.containsKey(diff) && hm.get(diff) > 0) {
				System.out.println("Pairs: " + cur + " " + diff);
				//remove diff element as well from hm
				hm.put(diff, hm.get(diff) - 1);
			}
		}
	}
	
	void alternatePairs(int a[], int sum) {
		Arrays.sort(a);
		int first = 0; 
		int last = a.length - 1;
		while(first < last) {
			int s = a[first] + a[last];
			if(s == sum) {
				System.out.println(a[first] + " " + a[last]);
				first++;
				last--;
			}
			else {
				if(s < sum)
					first++;
				else 
					last--;
			}
		}
	}

	public static void main(String[] args) {
		int a[] = {2, 2, 1, 0, 5, 4, -5, 6};
		FindPairs f = new FindPairs();
		f.pairs(a, 4);
		f.alternatePairs(a, 4);

	}

}
