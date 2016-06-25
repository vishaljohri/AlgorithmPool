package programming.interviews.exposed.book;

public class StringToInteger {
	
	int convert(String str) {
		int cur = 0;
		boolean negativeFlag = false;
		if(str.charAt(cur) == '-') {
			negativeFlag = true;
			cur++;
		}
		int number = 0;
		while(cur < str.length()) {
			number = number * 10;
			number += (str.charAt(cur) - '0');
			cur++;
		}
		if(negativeFlag)
			number = -number;
		return number;
	}

	public static void main(String[] args) {
		String str = "-145720";
		StringToInteger s = new StringToInteger();
		System.out.println(s.convert(str));
		

	}

}
