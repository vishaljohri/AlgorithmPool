
public class MaxNumber {
	
	int flip(int bit) {
		return 1 ^ bit;
	}
	
	//if a is negative return 0 else if a is positive return 1
	int sign(int a) {
		return flip((a >> 31) & 1);
	}
	
	int maxNumber(int a, int b) {
		
		/*int k = sign(a - b);
		int q = flip(k);
		return k*a + q*b;*/
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		//check if signs of a and b are different
		int useSignOfa = sa ^ sb;  // 1 if signs are diff
		int useSignOfc = flip(sa ^ sb); //1 if signs are same
		
		int k = useSignOfa * sa + useSignOfc * sc;
		int q = flip(k);
		return k*a + q*b;
	}

	public static void main(String[] args) {
		MaxNumber m = new MaxNumber();
		System.out.println(m.maxNumber(-70, -5));

	}

}
