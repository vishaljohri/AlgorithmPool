
public class MissingIntegerInString {

	boolean hasAll9s(int n) {
		String str = String.valueOf(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '9')
				return false;
		}
		return true;
	}

	int guessNoDigitsInFirst(String s) {
		// start guessing from 1 till s.length() / 2
		for (int i = 1; i < s.length() / 2; i++) {
			int guess = i;
			int pointer = 0;
			int prev = Integer.parseInt(s.substring(pointer, pointer + guess));
			int cur = Integer.parseInt(s.substring(pointer, pointer + guess));
			pointer = guess;
			boolean found = false;
			int missing = -1;
			while (pointer < s.length()) {
				if (hasAll9s(prev))
					guess++;
				cur = Integer.parseInt(s.substring(pointer, pointer + guess));
				if (cur - prev == 1) {
					
				}
				else if (cur - prev == 2 && !found) {
					found = true;
					missing = cur - 1;
				} else {
					break;
				}
				prev = cur;
				pointer = pointer + guess;
			}
			if (pointer == s.length())
				return missing;
		}
		return -1;
	}

	void missingInteger(String s) {
		System.out.println(guessNoDigitsInFirst(s));
	}

	public static void main(String[] args) {
		MissingIntegerInString m = new MissingIntegerInString();
		m.missingInteger("9899100101103104");
	}
}
