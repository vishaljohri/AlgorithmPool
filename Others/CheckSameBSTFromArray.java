
import java.util.ArrayList;
import java.util.List;

public class CheckSameBSTFromArray {
	
	List<Integer> smaller(List<Integer> a, int cur) {
		List<Integer> list = new ArrayList<>();
		for(int i : a) {
			if(i < cur)
				list.add(i);
		}
		return list;
	}
	
	List<Integer> greater(List<Integer> a, int cur) {
		List<Integer> list = new ArrayList<>();
		for(int i : a) {
			if(i > cur)
				list.add(i);
		}
		return list;
	}
	
	// find if BSTs formed by given arrays are same
	boolean isSame(List<Integer> a1, List<Integer> a2) {
		return isSameHelper(a1, a2);
	}
	
	// first element of numbers smaller than cur should be same in both lists, same for numbers greater
	boolean isSameHelper(List<Integer> l1, List<Integer> l2) {
		if(l1.size() != l2.size())
			return false;
		if(l1.size() == 0)
			return true;
		List<Integer> l1Left = new ArrayList<>();
		List<Integer> l1Right = new ArrayList<>();
		List<Integer> l2Left = new ArrayList<>();
		List<Integer> l2Right = new ArrayList<>();
		if(l1.size() >= 1) {
			if(l1.get(0) != l2.get(0))
				return false;
			l1Left = smaller(l1, l1.get(0));
			l1Right = greater(l1, l1.get(0));
			l2Left = smaller(l2, l2.get(0));
			l2Right = greater(l2, l2.get(0));
		}
		
		return isSameHelper(l1Left, l2Left) && isSameHelper(l1Right, l2Right);
	}

	public static void main(String[] args) {
		CheckSameBSTFromArray c = new CheckSameBSTFromArray();
		List<Integer> l1 = new ArrayList<>();
		l1.add(8);
		l1.add(3);
		l1.add(6);
		l1.add(1);
		l1.add(4);
		l1.add(7);
		l1.add(10);
		l1.add(14);
		l1.add(13);
		List<Integer> l2 = new ArrayList<>();
		l2.add(8);
		l2.add(10);
		l2.add(14);
		l2.add(3);
		l2.add(6);
		l2.add(4);
		l2.add(1);
		l2.add(7);
		l2.add(13);
		System.out.println(c.isSame(l1, l2));
	}
}
