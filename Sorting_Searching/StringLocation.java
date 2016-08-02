
public class StringLocation {

	int location(String str[], String key) {
		for (int i = 0; i < str.length; i++) {
			if (key.equals(str[i]))
				return i;
		}
		return -1;
	}

	int locationBinary(String str[], int start, int end, String key) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (str[mid].equals("")) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end)
					return -1;
				else if (left >= start && !str[left].equals("")) {
					mid = left;
					break;
				} else if (right <= end && !str[right].equals("")) {
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		
		if (str[mid].equals(key))
			return mid;
		if (str[mid].compareTo(key) > 0) {
			return locationBinary(str, start, mid - 1, key);
		} else
			return locationBinary(str, mid + 1, end, key);

	}

	public static void main(String[] args) {
		StringLocation sl = new StringLocation();
		String str[] = { "at", "", "", "", "ball", "", "", "car", "", "",
				"dad", "", "" };
		System.out.println("location: " + sl.location(str, "ba"));
		System.out.println("location using modified binary search: "
				+ sl.locationBinary(str, 0, str.length - 1, "ball"));

	}

}
