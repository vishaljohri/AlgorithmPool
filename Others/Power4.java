package leetcode.ques;

public class Power4 {

	public boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		while (num != 1) {
			int remNum = num / 4;
			if (remNum * 4 != num)
				return false;
			num = remNum;
		}
		return true;
	}

	public boolean isPowerOfFourWithoutLoop(int num) {
		return (num > 0) && ((num & (num - 1)) == 0)
				&& ((num & (0x55555555)) == num);
	}

	public static void main(String[] args) {
		Power4 p = new Power4();
		System.out.println(p.isPowerOfFourWithoutLoop(16));

	}

}
