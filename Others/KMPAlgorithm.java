
public class KMPAlgorithm {
	int matchingIndex(String text, String pattern) {
		if(text.length() == 0)
			return -1;
		int lps[] = longestPrefixAndSuffix(pattern);
		int j = 0;
		int i = 0;
		while(i < text.length()) {
			if(j < pattern.length() && text.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
				if(j == pattern.length()) {
					System.out.println("pattern found");
					return i - j;
				}
				continue;
			}
			//no match is found
			if(j != 0 )
				j = lps[j -1];
			else
				i++;
		}
		return -1;
	}
	
	int[] longestPrefixAndSuffix(String pattern) {
		int lps[] = new int[pattern.length()];
		if(pattern.length() == 0)
			return lps;
		lps[0] = 0;
		int i = 1;
		int j = 0;
		while(i < pattern.length()) {
			if(pattern.charAt(i) == pattern.charAt(j)) {
				lps[i] = j + 1;
				j++;
			}
			else {
				while(j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
					j = lps[j - 1];
				}
				if(pattern.charAt(i) == pattern.charAt(j)) {
					lps[i] = j + 1;
					j++;
				}
				else {
					lps[i] = 0;
				}
			}
			i++;
		}
		return lps;
	}
	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		KMPAlgorithm k = new KMPAlgorithm();
		System.out.println(k.matchingIndex(text, pattern));
	}
}
