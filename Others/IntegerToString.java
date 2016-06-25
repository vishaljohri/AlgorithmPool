
public class IntegerToString {
	
	String convert(int number) {
		boolean isNegative = false;
		if(number < 0) {
			isNegative = true;
			number = -number;
		}
		String str = "";
		while(number != 0) {
			str = number % 10 + str;
			number = number / 10;
		}
		if(isNegative)
			str = "-" + str;
		return str;
	}

	public static void main(String[] args) {
		int number = 14;
		IntegerToString is = new IntegerToString();
		System.out.println(is.convert(number));

	}

}
