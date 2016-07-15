
public class TrailingZeros {
	
	int trailingZeros(int number) {
		if(number < 0)	
			return -1;
		int count = 0;
		for(int i = 5; number/i > 0; i *= 5) {
			count += number/i;
		}
		return count;
	}

	public static void main(String[] args) {
		int number = 90;
		TrailingZeros tz = new TrailingZeros();
		System.out.println("number of factors are: " + tz.trailingZeros(number));

	}

}
