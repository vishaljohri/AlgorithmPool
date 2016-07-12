
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class SmallestPairs {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		HashMap<Integer, List<int[]>> hm = new HashMap<>();
		for(int i = 0; i < Math.min(nums1.length, k); i++) {
			for(int j = 0; j < Math.min(nums2.length, k); j++) {
				int sum = nums1[i] + nums2[j];
				if(!hm.containsKey(sum))
					hm.put(sum, new ArrayList<int[]>());
				int pair[] = {nums1[i], nums2[j]};
				hm.get(sum).add(pair);
			}
		} 
		
		List<Integer> list = new ArrayList<>(hm.keySet());
		Collections.sort(list);
		for(int i : list) {
			if(k == 0)
				break;
			List<int[]> l = hm.get(i);
			for(int[] pair : l) {
				if(k == 0)
					break;
				result.add(pair);
				k--;
			}
		}
		
		return result;
	}
	
	class Pair {
		int row;
		int col;
		int val;
		Pair(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
	
	public List<int[]> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k) {
		boolean visited[][] = new boolean[nums1.length][nums2.length]; 
		List<int[]> result = new ArrayList<>();
		if(nums1.length == 0 || nums2.length == 0) 
		    return result;
		Queue<Pair> queue = new PriorityQueue<>(10, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val - o2.val;
			}
		});
		queue.add(new Pair(0, 0, nums1[0] + nums2[0]));
		
		while(k > 0 && !queue.isEmpty()) {
			Pair p = queue.poll();
			int e[] = {nums1[p.row], nums2[p.col]}; 
			result.add(e);
			k--;
			// visit neighbors of p => (row + 1, col) and (row, col + 1) if not visited
			if(p.row < nums1.length - 1 && !visited[p.row + 1][p.col]) {
				queue.add(new Pair(p.row + 1, p.col, nums1[p.row + 1] + nums2[p.col]));
				visited[p.row + 1][p.col] = true;
			}
			if(p.col < nums2.length - 1 && !visited[p.row][p.col + 1]) {
				queue.add(new Pair(p.row, p.col + 1, nums1[p.row] + nums2[p.col + 1]));
				visited[p.row][p.col + 1] = true;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		SmallestPairs sp = new SmallestPairs();
		int nums1[] = {1, 2, 4, 5};
		int nums2[] = {1, 1, 2, 4};
		List<int[]> r = sp.kSmallestPairsOptimized(nums1, nums2, 2);
		for(int[] p : r) {
			System.out.println(Arrays.toString(p));
		}
	}
}
