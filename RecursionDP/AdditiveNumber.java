
public class AdditiveNumber {

	public boolean isAdditiveNumber(String s) {

		if (s.length() <= 2)
			return false;

		for (int i = 1; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				long l1 = parse(s.substring(0, i));
				long l2 = parse(s.substring(i, j));
				if (l1 == -1 || l2 == -1)
					continue;
				if (helperAdditive(s.substring(j), l1, l2, false))
					return true;
			}
		}
		return false;
	}

	long parse(String s) {
		if (!s.equals("0") && s.startsWith("0"))
			return -1;
		long result = 0;
		try {
			result = Long.parseLong(s);
		} catch (NumberFormatException n) {
			result = -1;
		}
		return result;
	}

	boolean helperAdditive(String str, long first, long second, boolean flag) {
		if (str.length() == 0 && flag == true)
			return true;

		for (int i = 1; i <= str.length(); i++) {
			String suffix = str.substring(0, i);
			long suf = parse(suffix);
			if (suf == -1)
				continue;
			if (first + second == suf
					&& helperAdditive(str.substring(i), second, suf, true))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		AdditiveNumber a = new AdditiveNumber();
		System.out.println(a.isAdditiveNumber("199100199"));

	}

}
