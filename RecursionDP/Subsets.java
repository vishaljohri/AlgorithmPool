
import java.util.ArrayList;

public class Subsets {
	
	ArrayList<ArrayList<Integer>> calculateSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int pow = (int)Math.pow(2, set.size());
		
		for(int i = 0; i < pow; i ++) {
			allSubsets.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < pow; i ++) {
			for(int j = 0; j < set.size(); j++) {
				if((i & (1 << j)) != 0) {
					allSubsets.get(i).add(set.get(j));
				}
			}
		}
		return allSubsets;
	}
	
	ArrayList<ArrayList<Integer>> getSubsetsUsingRecursion(ArrayList<Integer> set, int index ) {
		ArrayList<ArrayList<Integer>> allSubsets;
		
		//base case, add empty set
		if(set.size() == index) {
			allSubsets = new ArrayList<>();
			allSubsets.add(new ArrayList<Integer>());
		}
		else {
			allSubsets = getSubsetsUsingRecursion(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
			for(ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		
		return allSubsets;
		
	}

	public static void main(String[] args) {
		Subsets set = new Subsets();
		ArrayList<Integer> originalSet = new ArrayList<>();
		originalSet.add(1);
		originalSet.add(2);
		originalSet.add(3);
		originalSet.add(4);
		
		System.out.println(set.calculateSubsets(originalSet));
		System.out.println(set.getSubsetsUsingRecursion(originalSet, 0));
	}

}
