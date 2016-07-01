
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sum4 {
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashSet<ArrayList<Integer>> hs = new HashSet<>();
		if(num.length == 0)
			return result;
		Arrays.sort(num);
		
		for(int i = 0; i < num.length; i++) {
			for(int j = i + 1; j < num.length; j++) {
				int k = j + 1;
				int l = num.length - 1;
				while(k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if(sum > target) {
						l--;
					}
					else if(sum < target) {
						k++;
					}
					else {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
						if(hs.add(temp))
							result.add(temp);
						k++;
						l--;
					}
				}
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		Sum4 s = new Sum4();
		int a[] = {1, 0, -1, 0, -2, 2};
		System.out.println(s.fourSum(a, 0));

	}

}
