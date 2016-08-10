import java.util.ArrayList;
import java.util.List;

public class AbsolutePermutation {
	
	void absolutePerm(int n, int k) {
		if (k == 0) {
			for (int i = 1; i < n; i++) {
				System.out.print(i + " ");
			}
			System.out.println(n);
		} else if (n % 2 != 0) {
			System.out.println(-1);
		} else if (n % (2 * k) == 0) {
			int pointer1 = 1;
			int pointer2 = pointer1 + k;
			List<Integer> list = new ArrayList<>();
			while (pointer2 <= n) {
				for (int i = 1; i <= k; i++) {
					list.add(pointer2++);
				}
				for (int j = 1; j <= k; j++) {
					list.add(pointer1++);
				}
				pointer1 += k;
				pointer2 += k;
			}
			for (int i = 0; i < list.size() - 1; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println(list.get(list.size() - 1) + " ");
		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		AbsolutePermutation ap = new AbsolutePermutation();
		ap.absolutePerm(10, 5);

	}

}
