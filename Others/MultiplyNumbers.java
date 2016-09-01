
public class MultiplyNumbers {
	
	String multiply(String num1, String num2) {
		int length1 = num1.length();
		int length2 = num2.length();
		int result[] = new int[length1 + length2];
		
		for(int i = length1 - 1; i >= 0; i--) {
			for(int j = length2 - 1; j >= 0; j--) {
				int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int pos1 = i + j;
				int pos2 = i + j + 1;
				
				int sum = mult + result[pos2];
				result[pos1] += sum / 10;
				result[pos2] = sum % 10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int pointer = 0;
		while(pointer < result.length && result[pointer] == 0) {
			pointer++;
		}
		for(int i = pointer; i < result.length; i++) {
			sb.append(result[i]);
		}
		if(sb.length() == 0)
			sb.append("0");
		return sb.toString();
			
	}

	public static void main(String[] args) {
		MultiplyNumbers m = new MultiplyNumbers();
		System.out.println(m.multiply("0", "0"));

	}

}
