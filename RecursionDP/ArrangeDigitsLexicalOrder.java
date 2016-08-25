
import java.util.ArrayList;
import java.util.List;

public class ArrangeDigitsLexicalOrder {
	
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			if (i <= n)
				result.add(i);
			lexicalOrderHelper(i, n, result);
		}
		return result;
	}

	void lexicalOrderHelper(int cur, int n, List<Integer> result) {
		for (int i = 0; i <= 9; i++) {
			int temp = cur * 10 + i;
			if (temp > n)
				return;
			result.add(temp);
			lexicalOrderHelper(result.get(result.size() - 1), n, result);
		}
	}

	
	public static void main(String[] args) {
		ArrangeDigitsLexicalOrder a = new ArrangeDigitsLexicalOrder();
		System.out.println(a.lexicalOrder(100));

	}
}