
// perform minimum insertions to make string palindrome
public class FormPalindrome {

	// using recursion
	int findMinInsertions(String s) {
		return findMinInsertionsHelper(s, 0, s.length() - 1);
	}

	int findMinInsertionsHelper(String s, int startIndex, int endIndex) {
		if (startIndex >= endIndex)
			return 0;
		if (s.charAt(startIndex) == s.charAt(endIndex))
			return findMinInsertionsHelper(s, startIndex + 1, endIndex - 1);
		else
			return 1 + Math.min(
					findMinInsertionsHelper(s, startIndex + 1, endIndex),
					findMinInsertionsHelper(s, startIndex, endIndex - 1));
	}

	// using dp
	int findMinInsertionsDP(String s) {

		int dp[][] = new int[s.length()][s.length()];
		for (int l = 0; l < s.length(); l++) {
			int j = l;
			for (int i = 0; i < s.length() - l; i++) {
				dp[i][j] = Integer.MAX_VALUE;
				if (i == j) {
					dp[i][j] = 0;
				} else {
					if (s.charAt(i) == s.charAt(j))
						dp[i][j] = dp[i + 1][j - 1];
					else
						dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
				}
				j++;
			}
		}
		return dp[0][s.length() - 1];
	}

	public static void main(String[] args) {
		FormPalindrome fp = new FormPalindrome();
		System.out.println(fp.findMinInsertions("abcde"));
		System.out.println(fp.findMinInsertionsDP("abcde"));
	}
}