
public class DivisionInLognTime {
	
	void division(int a, int b) {
		int q = 1;
		while(q * b < a)
			q *= 2;
		System.out.println(binarySeach(q >> 1, q, a, b));
	}
	
	int binarySeach(int start, int end, int a, int b) {
		int mid = (start + end) >> 1;
		if(start >= end)
			return mid;
		if(mid * b == a)
			return mid;
		else if(mid * b > a)
			return binarySeach(start, mid - 1, a, b);
		else
			return binarySeach(mid + 1, end, a, b);
	}

	public static void main(String[] args) {
		DivisionInLognTime d = new DivisionInLognTime();
		d.division(125, 5);

	}
}
