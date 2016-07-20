
public class NumberToWords {

	String []digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	String []teens = {"Eleven", "Twelve", "thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String []tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String []bigs = {"", "Thousand", "Million", "Billion"};
	
	String printWords(int n) {
		if(n == 0) {
			return "Zero";
		} else if(n < 0 ) {
			return "Negative " + printWords(-1*n);
		}
		int count = 0;
		String str = "";
		while(n > 0) {
			if(n%1000 != 0) {
				str = numberToString100(n%1000) + bigs[count] + " " + str;
			}
			n = n/1000;
			count++;
		}
		
		return str;
	}
	
	String numberToString100(int n) {
		String str = "";
		if(n > 100) {			
			str += digits[n / 100 - 1] + " Hundred" + " ";
			n = n % 100;
		}
		
		if(n >= 11 && n <= 19) {
			return str + teens[n - 11] + " ";
		}
		else if(n == 10 || n >= 20) {
			str =  str + tens[n / 10 - 1] + " ";
			n = n % 10;
		}
		
		if(n >= 1 && n <= 9) {
			str += digits[n - 1] + " ";
		}
		
		return str;
	}

	public static void main(String[] args) {
		NumberToWords nw = new NumberToWords();
		System.out.println(nw.printWords(19323984));
	}

}
