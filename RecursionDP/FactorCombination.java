import java.util.ArrayList;
import java.util.List;

public class FactorCombination {
	
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		getFactorsHelper(n, n, 2, 1, list, result);
		return result;
	}
	
	void getFactorsHelper(int originalN, int n, int cur, int prod, List<Integer> list, List<List<Integer>> result) {
		if(prod == originalN) {
			result.add(new ArrayList<>(list));
			return;
		}

		for(int i = cur; i <= originalN / 2; i++) {
			if(n % i == 0) {
				list.add(i);
				getFactorsHelper(originalN, n / i, i, prod * i, list, result);
				list.remove(list.size() - 1);
			}
		}
		
	}

	public static void main(String[] args) {
		FactorCombination fc = new FactorCombination();
		System.out.println(fc.getFactors(12));
	}
}
