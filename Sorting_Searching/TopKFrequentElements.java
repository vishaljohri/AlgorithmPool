
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i : nums) {
			if (!hm.containsKey(i)) {
				hm.put(i, 1);
			} else {
				hm.put(i, hm.get(i) + 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() < o2.getValue()) {
					return 1;
				} else if (o1.getValue() == o2.getValue()) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		int count = 0;
		for (Map.Entry<Integer, Integer> e : list) {
			if (count == k)
				break;
			result.add(e.getKey());
			count++;
		}
		return result;
	}
	
	public List<Integer> topKFrequentOptimized(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		List<Integer>[] bucket = new List[nums.length + 1];
		List<Integer> result = new ArrayList<>();
		
		for(int i : nums) {
			if (!hm.containsKey(i)) {
				hm.put(i, 1);
			} else {
				hm.put(i, hm.get(i) + 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
			int value = e.getValue();
			if(bucket[value] == null) {
				bucket[value] = new ArrayList<>();
			}
			bucket[value].add(e.getKey());
		}
		
		int pointer = bucket.length - 1;
		int count = 0;
		while(pointer >= 0 && count < k) {
			while(pointer >= 0 && bucket[pointer] == null) {
				pointer--;
			}
			if(pointer < 0) 
			    break;
			result.addAll(bucket[pointer]);
			count += bucket[pointer].size();
			pointer--;
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = {1, 1, 1, 1, 2, 2, 4};
		TopKFrequentElements t = new TopKFrequentElements();
		System.out.println(t.topKFrequentOptimized(nums, 2));

	}

}
