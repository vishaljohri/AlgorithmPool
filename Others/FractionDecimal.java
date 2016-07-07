
import java.util.HashMap;

public class FractionDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		
		//add sign
		if((numerator > 0) ^ (denominator > 0))
			sb.append("-");
		long num = Math.abs((long)numerator);
		long denom = Math.abs((long)denominator);
		
		//add integer part
		long intPart = num / denom;
		sb.append(intPart);
		
		num = num % denom;
		if(num == 0)
			return new String(sb);
		sb.append(".");
		
		//fractional part
		HashMap<Long, Integer> hm = new HashMap<>();
		hm.put(num, sb.length());
		while(num != 0) {
			num = num * 10;
			long fracPart = num / denom;
			sb.append(fracPart);
			num = num % denom;
			
			//check if num is already present
			if(!hm.containsKey(num)) {
				hm.put(num, sb.length());
			}
			else {
				int locPrev = hm.get(num);
				sb.insert(locPrev, "(");
				sb.append(")");
				break;
			}
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		FractionDecimal fd = new FractionDecimal();
		System.out.println(fd.fractionToDecimal(1, 9));

	}

}
