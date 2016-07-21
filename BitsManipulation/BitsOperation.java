package bits.manipulation;

import java.util.ArrayList;
import java.util.BitSet;

public class BitsOperation {

	void insertMToN() {
		int n = 2048;
		int m = 19;
		int start = 2;
		int end = 6;
		m = m << start;
		System.out.println(m);
		// create mask
		int allOnes = ~0;
		System.out.println(allOnes);
		int left = allOnes << (end + 1);
		System.out.println(left);
		int right = (1 << start) - 1;
		System.out.println(right);
		int mask = left | right;

		System.out.println(mask);
		int cleared = n & mask;
		System.out
				.println("final answer of inserting M to N: " + (cleared | m));
	}

	void BinaryRepresentationOfDecimal() {
		double n = 0.125;
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (n > 0) {
			if (binary.length() >= 32) {
				System.out.println("error");
				return;
			}

			double r = n * 2;
			if (r >= 1) {
				binary.append(1);
				n = r - 1;
			} else {
				binary.append(0);
				n = r;
			}
		}

		System.out.println("Binary Representattion of Double = " + binary);
	}

	void bitsFlip() {
		int n1 = 29;
		int n2 = 15;

		int x = n1 ^ n2;
		int count = 0;
		for (int i = x; i != 0; i = i >> 1) {
			count = count + (i & 1);
		}

		System.out.println("number of bits reqd to flip = " + count);
	}

	void swapOddAndEven() {
		int x = 9;
		System.out.println("swapped number = "
				+ (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1)));
	}

	void getNextWithSame1s() {
		int number = 2;
		int c0 = 0;
		int c1 = 0;
		int c = number;

		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c = c >> 1;
		}

		while (((c & 1) == 1) && (c != 0)) {
			c1++;
			c = c >> 1;
		}

		if ((c0 + c1) == 31 || (c0 + c1) == 0)
			return;

		int p = c0 + c1;
		// flip 0 at p position
		number = number | (1 << p);
		// clear all bits to right of p
		int allOnes = ~0;
		int mask = allOnes << p;
		number = number & mask;
		// insert c1-1 ones on the right
		int a = 1 << (c1 - 1);
		a = a - 1;
		number = number | a;

		System.out.println("the next number is: " + number);
	}

	void getPreviousWithSame1s() {
		int number = 2;
		int c0 = 0;
		int c1 = 0;
		int c = number;

		while (((c & 1) == 1) && (c != 0)) {
			c1++;
			c = c >> 1;
		}

		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c = c >> 1;
		}

		int p = c0 + c1;

		// flip 1 at p and make all right 0s => make all 0s from p onwards
		int allOnes = ~0;
		int mask = allOnes << (p + 1);
		number = number & mask;

		// insert c1+1 ones right of p
		int a = 1 << (c1 + 1);
		int b = a - 1;
		int x = b << (c0 - 1);
		number = number | x;
		System.out.println("the previous number with same 1s is: " + number);

	}

	void decimalToBinary() {
		int number = 11;
		int temp = number;
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		while (temp != 0) {
			stack.push(temp % 2);
			temp = temp / 2;
		}
		System.out.print("binary representation: ");
		while (stack.size() != 0) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	void binaryToDecimal() {
		int ar[] = { 1, 1, 1, 0, 1, 0 };
		int decimal = 0;
		int power = 0;
		for (int i = ar.length - 1; i >= 0; i--) {
			decimal += ar[i] * Math.pow(2, power++);
		}
		System.out.println("decimal representation: " + decimal);
	}

	int findMissing(ArrayList<BitSet> list) {
		return missingHelper(list, 0);
	}

	int missingHelper(ArrayList<BitSet> list, int column) {
		// asuming numbers are represented with 8 bits
		if (column >= 8 || list.size() == 0)
			return 0;
		ArrayList<BitSet> oneBits = new ArrayList<>();
		ArrayList<BitSet> zeroBits = new ArrayList<>();
		for (BitSet b : list) {
			if (b.get(column))
				oneBits.add(b);
			else
				zeroBits.add(b);
		}

		if (zeroBits.size() <= oneBits.size()) {
			int v = missingHelper(zeroBits, column + 1);
			return (v << 1) | 0;
		} else {
			int v = missingHelper(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}

	public static void main(String[] args) {

		BitsOperation op = new BitsOperation();
		op.insertMToN();
		op.BinaryRepresentationOfDecimal();
		op.bitsFlip();
		op.swapOddAndEven();
		op.getNextWithSame1s();
		op.getPreviousWithSame1s();
		op.decimalToBinary();
		op.binaryToDecimal();

		ArrayList<BitSet> list = new ArrayList<>();
		list.add(BitSet.valueOf(new byte[] { 0 }));
		list.add(BitSet.valueOf(new byte[] { 1 }));
		list.add(BitSet.valueOf(new byte[] { 2 }));
		list.add(BitSet.valueOf(new byte[] { 3 }));
		list.add(BitSet.valueOf(new byte[] { 4 }));
		list.add(BitSet.valueOf(new byte[] { 6 }));
		list.add(BitSet.valueOf(new byte[] { 7 }));
		list.add(BitSet.valueOf(new byte[] { 8 }));
		System.out.println(op.findMissing(list));

	}

}
