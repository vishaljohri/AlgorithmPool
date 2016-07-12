package leetcode.ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDoll {

	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes.length == 0)
			return 0;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < envelopes.length; i++) {
			list.add(envelopes[i]);
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int dp[] = new int[envelopes.length];
		dp[0] = 1;
		int maxEn = 1; 
		for(int i = 1; i < envelopes.length; i++) {
			dp[i] = 1;
			for(int j = i - 1; j >= 0; j--) {
				if(list.get(i)[0] > list.get(j)[0] && list.get(i)[1] > list.get(j)[1])
					dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
			maxEn = Math.max(maxEn, dp[i]);
		}
		return maxEn;
	}

	public static void main(String[] args) {
		RussianDoll rd = new RussianDoll();
		int envelopes[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 }, {7, 9} };
		System.out.println(rd.maxEnvelopes(envelopes));
	}
}