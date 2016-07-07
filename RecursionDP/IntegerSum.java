package leetcode.ques;

public class IntegerSum {
	
	public int getSum(int a, int b) {
        if(b == 0)
            return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }

	public static void main(String[] args) {
		IntegerSum is = new IntegerSum();
		System.out.println(is.getSum(5, 7));

	}

}
