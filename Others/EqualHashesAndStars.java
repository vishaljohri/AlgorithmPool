
import java.util.HashMap;

public class EqualHashesAndStars {
	
	void maximumSubstringWithEqualHashesStars(String s) {
		int a[] = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '*')
				a[i] = 1;
			else
				a[i] = -1;
		}
		
		// store the first occurence of an integer
		// add all values of a[i], such that a[i] = a[i] + a[i - 1]
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, -1);
		hm.put(a[0], 0);
		for(int i = 1; i < a.length; i++) {
			a[i] = a[i] + a[i - 1];
			if(!hm.containsKey(a[i]))
				hm.put(a[i], i);
		}
		
		// iterate over a[] and check for longest substring,
		// if there is a match between a[i] and hm
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for(int i = 0; i < a.length; i++) {
			if(hm.containsKey(a[i]) && i > hm.get(a[i])) {
				if(max < i - hm.get(a[i])) {
					max = i - hm.get(a[i]);
					start = hm.get(a[i]) + 1;
					end = i;
				}
			}
		}
		
		System.out.println(s.substring(start, end + 1));
	}

	public static void main(String[] args) {
		EqualHashesAndStars e = new EqualHashesAndStars();
		String s = "#########*##*";
		e.maximumSubstringWithEqualHashesStars(s);
	}
}
