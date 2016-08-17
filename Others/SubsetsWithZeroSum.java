
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class SubsetsWithZeroSum {
	
	void findSubsetsWithZeroSum(int ar[]) {
		HashMap<Integer, List<Integer>> hm = new HashMap<>();
		int a[] = new int[ar.length];
		a[0] = ar[0];
		for(int i = 1; i < ar.length; i++) {
			a[i] = a[i - 1] + ar[i];
		}
		
		List<Integer> forZero = new ArrayList<>();
		forZero.add(-1);
		hm.put(0, forZero);
		for(int i = 0; i < a.length; i++) {
			if(!hm.containsKey(a[i]))
				hm.put(a[i], new ArrayList<Integer>());
			else {
				// print subsets
				List<Integer> list = hm.get(a[i]);
				for(int loc : list) {
					System.out.println(Arrays.toString(Arrays.copyOfRange(ar, loc + 1, i + 1)));
				}
				
			}
			hm.get(a[i]).add(i);
		}
	}

	public static void main(String[] args) {
		SubsetsWithZeroSum s = new SubsetsWithZeroSum();
		int ar[] = {2, 1, -1, 0, 2, -1, -1};
		s.findSubsetsWithZeroSum(ar);
	}
}
