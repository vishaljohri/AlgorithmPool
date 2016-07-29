
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1(int x) {
		val = x;
	}
}

class DescComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}

class AscComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() - s2.length() >= 0)
			return 1;
		else
			return -1;
	}
}

public class General {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> list = new ArrayList<>();
		if (intervals.size() == 0) {
			list.add(newInterval);
			return list;
		}
		boolean flag = false;
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.end < newInterval.start)
				list.add(cur);
			else if (!flag) {
				Interval startInterval = intervals.get(i);
				while (i < intervals.size()
						&& intervals.get(i).end <= newInterval.end) {
					i++;
				}
				int startNew = Math.min(startInterval.start, newInterval.start);
				int endNew = 0;
				if (i < intervals.size())
					endNew = Math.max(intervals.get(i).end, newInterval.end);
				else
					endNew = newInterval.end;
				list.add(new Interval(startNew, endNew));
				flag = true;
			} else {
				list.add(cur);
			}
		}
		return list;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		HashMap<String, LinkedList<String>> hm = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char c[] = strs[i].toCharArray();
			Arrays.sort(c);
			String temp = new String(c);
			if (hm.containsKey(temp)) {
				hm.get(temp).add(strs[i]);
			} else {
				hm.put(temp, new LinkedList<String>());
				hm.get(temp).add(strs[i]);
			}
		}

		for (String key : hm.keySet()) {
			List<String> anagrams = new ArrayList<>();
			LinkedList<String> anagramList = hm.get(key);
			for (int i = 0; i < anagramList.size(); i++) {
				anagrams.add(anagramList.get(i));
			}
			list.add(anagrams);
		}
		return list;
	}

	public String reverseWords(String s) {
		String trimmed = s.trim();
		if (trimmed.length() == 0)
			return "";
		String str[] = trimmed.split(" +");
		s = "";
		for (int i = str.length - 1; i >= 1; i--) {
			s = s + str[i] + " ";
		}
		return s + str[0];
	}

	public String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder();
		char ch[] = path.toCharArray();
		sb.append('/');
		for (int i = 1; i < ch.length; i++) {

			if (i < ch.length - 1 && ch[i] == '.' && ch[i + 1] == '/') {
				i++;
				continue;
			}
			if (i < ch.length - 1 && ch[i] == '.' && ch[i + 1] == '.') {
				i++;
				if (sb.length() >= 3)
					sb.delete(sb.length() - 2, sb.length());
				continue;

			}
			if (i < ch.length - 1 && ch[i] == '/' && ch[i + 1] != '/') {
				if (sb.charAt(sb.length() - 1) != '/')
					sb.append('/');
				continue;
			}
			if (ch[i] != '.') {
				sb.append(ch[i]);
				continue;
			}

		}
		if (sb.length() > 1 && sb.charAt(0) == '/' && sb.charAt(1) == '/')
			sb.deleteCharAt(0);
		if (sb.length() != 1 && sb.charAt(sb.length() - 1) == '/')
			sb.deleteCharAt(sb.length() - 1);
		String str = new String(sb);
		return str;
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!hs.add(nums[i]))
				return false;
		}
		return true;
	}

	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		int primes[] = { 2, 3, 5 };
		for (int p : primes) {
			while (num % p == 0) {
				num = num / p;
			}
		}
		if (num == 1)
			return true;
		else
			return false;
	}

	void duplicates(int n[]) {
		for (int i = 0; i < n.length; i++) {
			if (n[Math.abs(n[i])] < 0) {
				System.out.println("duplicate element = " + Math.abs(n[i]));
				return;
			}
			n[Math.abs(n[i])] = -n[Math.abs(n[i])];
		}
		System.out.println("no duplicates");
	}

	int catalanNumber(int n) {
		if (n == 0 || n == 1)
			return 1;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += catalanNumber(i - 1) * catalanNumber(n - i);
		}
		return count;
	}

	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		if (s.charAt(0) == '0')
			return 0;
		int ways[] = new int[s.length()];
		ways[0] = 1;
		if (s.length() == 1)
			return 1;
		int firstTwo = Integer.parseInt(s.substring(0, 2));
		if (firstTwo != 10 && firstTwo != 20 && firstTwo >= 11
				&& firstTwo <= 26)
			ways[1] = 2;
		else
			ways[1] = 1;

		for (int i = 2; i < s.length(); i++) {
			ways[i] = Integer.MIN_VALUE;
			if (s.charAt(i) >= '1' && s.charAt(i) <= '9')
				ways[i] = ways[i - 1];
			if (Integer.parseInt(s.substring(i - 1, i + 1)) >= 10
					&& Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
				if (ways[i] == Integer.MIN_VALUE)
					ways[i] = ways[i - 2];
				else
					ways[i] += ways[i - 2];
			}

		}
		if (ways[s.length() - 1] == Integer.MIN_VALUE)
			return 0;
		else
			return ways[s.length() - 1];
	}

	int bs(int listA[], int x, int n) {
		int i, j, k;
		i = 0;
		j = n - 1;
		do {
			k = (i + j) / 2;
			if (x <= listA[k])
				j = k - 1;
			if (listA[k] <= x)
				i = k + 1;
		} while (i <= j);
		if (listA[k] == x)
			return (k);
		else
			return -1;
	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0)
				nums[i] = nums.length + 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i]) <= nums.length) {
				nums[Math.abs(nums[i]) - 1] = -Math
						.abs(nums[Math.abs(nums[i]) - 1]);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				return i + 1;
		}
		return nums.length + 1;
	}

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Integer> sourceMap = new HashMap<>();
		Map<Character, Integer> targetmap = new HashMap<>();
		for (Integer i = 0; i < s.length(); ++i)
			if (sourceMap.put(s.charAt(i), i) != targetmap.put(t.charAt(i), i))
				return false;
		return true;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0)
			return -1;
		int gasCopy[] = Arrays.copyOf(gas, gas.length);
		for (int start = 0; start < gas.length; start++) {
			gas = Arrays.copyOf(gasCopy, gasCopy.length);
			int len = gas.length;
			int carry = 0;
			boolean flag = true;

			if (gas[start] < cost[start]) {
				flag = false;
				continue;
			} else {
				carry = gas[start] - cost[start];
			}
			int next = (start + 1) % len;
			while (next != start) {
				gas[next] += carry;
				if (gas[next] < cost[next]) {
					flag = false;
					break;
				} else {
					carry = gas[next] - cost[next];
				}
				next = (next + 1) % len;
			}
			if (flag)
				return start;
		}
		return -1;

	}

	public int[] removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums;
		int cur = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[cur] != nums[i]) {
				nums[++cur] = nums[i];
			}
		}
		nums = Arrays.copyOf(nums, cur + 1);
		return nums;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0 || nums.length == 1)
			return false;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				int prevIndex = hm.get(nums[i]);
				if (i - prevIndex <= k)
					return true;
			}
			hm.put(nums[i], i);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0 || nums.length == 1)
			return false;
		TreeSet<Long> ts = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			long leftBoundary = (long) nums[i] - t;
			long rightBoundary = (long) nums[i] + t + 1;

			SortedSet<Long> subset = ts.subSet(leftBoundary, rightBoundary);
			if (!subset.isEmpty())
				return true;
			ts.add((long) nums[i]);
			if (i >= k)
				ts.remove((long) nums[i - k]);
		}
		return false;
	}

	public int minPath(int grid[][]) {
		int rows = grid.length;
		int cols = grid[0].length;
		int dp[][] = new int[rows][cols];

		dp[0][0] = grid[0][0];

		// first row
		for (int i = 1; i < cols; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}

		// first column
		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		// remaining cells
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		// final answer is last cell
		return dp[rows - 1][cols - 1];
	}

	public int maxProdInSubArray(int a[]) {
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return a[0];
		int posMax = Math.max(0, a[0]);
		int negMax = Math.min(0, a[0]);
		int globalMax = posMax;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == 0) {
				posMax = 0;
				negMax = 0;
			} else if (a[i] > 0) {
				posMax = Math.max(1, posMax) * a[i];
				negMax = negMax * a[i];
			} else {
				int temp = negMax;
				negMax = Math.max(1, posMax) * a[i];
				posMax = temp * a[i];
			}
			if (posMax > globalMax)
				globalMax = posMax;
		}

		return globalMax;
	}

	public ListNode1 insertionSortList(ListNode1 head) {
		if (head == null)
			return null;
		ListNode1 newHead = head;
		ListNode1 headPrev = head;
		head = head.next;
		while (head != null) {
			ListNode1 cur = newHead;
			ListNode1 prev = null;
			while (cur != null && cur.val < head.val) {
				prev = cur;
				cur = cur.next;
			}
			if (prev == null) {
				headPrev.next = head.next;
				head.next = newHead;
				newHead = head;
				head = headPrev.next;
			} else {
				if (cur == head) {
					headPrev = head;
					head = head.next;
					continue;
				} else {
					prev.next = head;
					headPrev.next = head.next;
					head.next = cur;
					head = headPrev.next;
				}
			}
		}
		return newHead;
	}

	public int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.length() == 0)
			return 0;
		String str[] = s.split(" +");
		System.out.println(Arrays.toString(str));
		return str[str.length - 1].length();
	}

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<Integer> finalList = new ArrayList<>();
		if (n == 0) {
			finalList.add(0);
			return finalList;
		}

		list.add("0");
		list.add("1");
		for (int i = 2; i <= n; i++) {
			ArrayList<String> revList = new ArrayList<>();
			for (int j = list.size() - 1; j >= 0; j--) {
				revList.add(list.get(j));
			}

			for (int j = 0; j < list.size(); j++) {
				list.set(j, "0" + list.get(j));
			}

			for (int j = 0; j < revList.size(); j++) {
				revList.set(j, "1" + revList.get(j));
			}

			for (int j = 0; j < revList.size(); j++) {
				list.add(revList.get(j));
			}
		}
		for (String s : list) {
			finalList.add(Integer.parseInt(s, 2));
		}
		return finalList;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return null;
		int n = nums.length;
		int maxWindow[] = new int[n - k + 1];
		int count = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(10,
				new DescComparator());
		for (int i = 0; i < n; i++) {
			queue.add(nums[i]);
			if (queue.size() == k) {
				maxWindow[count] = queue.peek();
				queue.remove(nums[count]);
				count++;
			}
		}
		return maxWindow;
	}

	public int hammingWeight(int n) {
		int wt = 0;
		for (int i = 0; i < 32; i++) {
			wt += n & 1;
			n = n >> 1;
		}
		return wt;
	}

	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String temp1 = new String(c1);
		String temp2 = new String(c2);
		if (!temp1.equals(temp2))
			return false;

		int n = s1.length();
		for (int i = 1; i < n; i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, n);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, n);
			if (isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(0, n - i);
			s22 = s2.substring(n - i, n);
			if (isScramble(s11, s22) && isScramble(s12, s21))
				return true;
		}
		return false;
	}

	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
		boolean dp[] = new boolean[nums.length];

		dp[0] = true;
		int max = nums[0];

		for (int i = 1; i < nums.length - 1; i++) {
			max--;
			if (max <= 0 && nums[i] <= 0)
				return false;
			if (nums[i] > max)
				max = nums[i];
		}
		return true;
	}

	public int jump(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		int cur = 1;
		int i = 0;
		while (cur < n) {
			int steps = nums[i];
			cur = i + 1;
			while (cur < n && steps > 0) {
				dp[cur] = Math.min(dp[i] + 1, dp[cur]);
				steps--;
				cur++;
			}
			i++;
		}
		return dp[n - 1];
	}

	int appleWeeks(int p, int a) {
		int count = 0;
		int weeks = 0;
		while (count < p) {
			weeks++;
			count = a * (weeks) * (weeks + 1) / 2;
		}
		return weeks;
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(1);
		int count = 0;
		int cur = 0;
		while (true) {
			cur = ts.pollFirst();
			count++;
			for (int i = 0; i < primes.length; i++) {
				ts.add(cur * primes[i]);
			}
			if (count == n)
				break;
		}
		return cur;
	}

	public String removeDuplicateLetters(String s) {
		TreeMap<Character, ArrayList<Integer>> tm = new TreeMap<>();
		ArrayList<Character> al = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (!tm.containsKey(s.charAt(i))) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				tm.put(s.charAt(i), list);
				al.add(s.charAt(i));
			} else {
				tm.get(s.charAt(i)).add(i);
			}
		}
		Collections.sort(al);
		String result = "";
		while (!tm.isEmpty()) {
			for (int i = 0; i < al.size(); i++) {
				boolean flag = true;
				Character c = al.get(i);
				int index = tm.get(c).get(0);
				for (Character ch : tm.keySet()) {
					ArrayList<Integer> temp = tm.get(ch);
					if (index > temp.get(temp.size() - 1)) {
						flag = false;
					}
				}

				if (flag == true) {
					result += c;
					tm.remove(c);
					al.remove(c);
					for (Character ch : tm.keySet()) {
						ArrayList<Integer> temp = tm.get(ch);
						while (temp.get(0) < index) {
							temp.remove(0);
						}
						tm.put(ch, temp);
					}
					break;
				}
			}
		}
		return result;
	}

	public boolean isHappy(int n) {
		boolean flag = false;
		HashSet<Integer> hs = new HashSet<>();
		while (true) {
			int sum = 0;
			while (n != 0) {
				int d = n % 10;
				sum += d * d;
				n = n / 10;
			}
			if (sum == 1) {
				flag = true;
				break;
			}
			n = sum;
			if (!hs.add(n))
				break;
		}
		return flag;
	}

	public boolean isValidSerialization(String preorder) {
		String str[] = preorder.split(",");
		int diff = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("#"))
				diff++;
			else
				diff--;
			if (diff == 1 && i != str.length - 1)
				return false;
		}
		if (diff == 1)
			return true;
		else
			return false;
	}

	public String shortestPalindrome(String s) {
		if (s.length() == 0)
			return s;
		int len = s.length();
		String matchingString = "";
		for (int i = len - 1; i >= 0; i--) {
			matchingString += s.charAt(i);
			for (int j = 0; j < matchingString.length(); j++) {

			}
		}
		return matchingString;
	}

	void StairCase(int n) {
		int i;
		int j;
		for (i = n - 1, j = 1; j <= n; i--, j++) {
			int ri = 1;
			int rj = 1;
			while (ri <= i) {
				System.out.print(" ");
				ri++;
			}
			while (rj <= j) {
				System.out.print("#");
				rj++;
			}
			System.out.println();
		}
	}

	String closestNumbers(int len, String s) {
		String[] str = s.split(" ");

		// array to store int representation of numbers
		int a[] = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(str[i]);
		}

		// sorting the array of numbers
		Arrays.sort(a);

		int min = Integer.MAX_VALUE;

		// using StringBuilder to avoid creation of multiple String objects
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < len - 1; i++) {
			if (Math.abs(a[i] - a[i + 1]) < min) {
				min = Math.abs(a[i] - a[i + 1]);
				// clear the contents of StringBuilder
				res.setLength(0);
				res = res.append(a[i] + " " + a[i + 1]);
			} else if (Math.abs(a[i] - a[i + 1]) == min) {
				res = res.append(" " + a[i] + " " + a[i + 1]);
			}
		}

		// return the output String
		return new String(res);
	}

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		partitionHelper(s, temp, list);
		return list;
	}

	void partitionHelper(String s, List<String> temp, List<List<String>> list) {
		if (s.equals("")) {
			list.add(new ArrayList<>(temp));
			// temp.clear();
			return;
		}

		for (int i = 1; i <= s.length(); i++) {
			if (s.substring(0, i).equals(
					new StringBuilder(s.substring(0, i)).reverse().toString())) {
				temp.add(s.substring(0, i));
				partitionHelper(s.substring(i), temp, list);
				temp.remove(temp.size() - 1);
			}
		}

	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s.equals(""))
			return true;
		int len = s.length();
		boolean dp[] = new boolean[len];

		for (int i = 0; i < len; i++) {
			if (dp[i] == false && wordDict.contains(s.substring(0, i + 1)))
				dp[i] = true;
			if (dp[i] == true) {
				if (i == len - 1)
					return true;
				for (int j = i + 1; j < len; j++) {
					if (dp[j] == false
							&& wordDict.contains(s.substring(i + 1, j + 1)))
						dp[j] = true;
				}
			}
		}
		return dp[len - 1];

	}

	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			count++;
		}

		return m << count;
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		return isInterleaveHelper(s1, s2, s3);
	}

	boolean isInterleaveHelper(String s1, String s2, String s3) {
		if (s1.length() == 0 && s2.length() == 0)
			return true;
		if (s1.length() > 0 && s2.length() > 0) {
			if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0))
				return isInterleaveHelper(s1.substring(1), s2, s3.substring(1))
						|| isInterleaveHelper(s1, s2.substring(1),
								s3.substring(1));
			else if (s1.charAt(0) == s3.charAt(0))
				return isInterleaveHelper(s1.substring(1), s2, s3.substring(1));
			else if (s2.charAt(0) == s3.charAt(0))
				return isInterleaveHelper(s1, s2.substring(1), s3.substring(1));
			else
				return false;
		}

		else if (s1.length() > 0) {
			if (s1.charAt(0) == s3.charAt(0))
				return isInterleaveHelper(s1.substring(1), s2, s3.substring(1));
			else
				return false;
		}

		else {
			if (s2.charAt(0) == s3.charAt(0))
				return isInterleaveHelper(s1, s2.substring(1), s3.substring(1));
			else
				return false;
		}

	}

	List<String> result = new LinkedList<>();
	HashMap<String, PriorityQueue<String>> hm = new HashMap<>();

	public List<String> findItinerary(String[][] tickets) {
		if (tickets.length == 0)
			return result;

		for (int i = 0; i < tickets.length; i++) {
			if (hm.containsKey(tickets[i][0]))
				hm.get(tickets[i][0]).add(tickets[i][1]);
			else {
				PriorityQueue<String> temp = new PriorityQueue<>();
				temp.add(tickets[i][1]);
				hm.put(tickets[i][0], temp);
			}
		}
		visitDfs("JFK");
		return result;
	}

	void visitDfs(String departure) {
		PriorityQueue<String> arrivals = hm.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			visitDfs(arrivals.poll());
		}
		result.add(0, departure);
	}

	boolean isRotation(String s1, String s2) {
		String f = s2 + s2;
		if (f.contains(s1))
			return true;
		else
			return false;
	}

	public long reverse(long a) {
		long reverse = 0;
		for (int i = 0; i < 32; i++) {
			reverse = reverse | a & 1;
			a = a >> 1;
			reverse = reverse << 1;
		}
		return reverse / 2;
	}

	public String convertToTitle(int n) {
		if (n == 0)
			return "";
		String title = "";
		while (n != 0) {
			n--;
			title = Character.toString((char) (n % 26 + 'A')) + title;
			n = n / 26;
		}
		return title;
	}

	int solutionFrog(int A[], int N, int X, int D) {
		// take bank array, initially with no leaf
		int bank[] = new int[X + 1];
		int curPosition = 0;

		// if frog can jump without any leaf, return 0;
		if (X - curPosition <= D)
			return 0;

		// iterate over leaf array and see if jump is possible
		for (int i = 0; i < A.length; i++) {
			int leafPos = A[i];

			// validate leaf position
			if (leafPos > X)
				continue;

			int pointer = leafPos - 1;
			int jumpTo = 0;

			// populate previous bank positions with the current leaf recognized
			// from the populated positions, frog can jump to current leaf
			// location
			while (pointer >= curPosition && jumpTo < D) {
				// modify bank array only when higher position can be reached by
				// fallen leaf
				if (bank[pointer] < leafPos)
					bank[pointer] = leafPos;
				pointer--;
				jumpTo++;
			}

			// jump the frog till curPosition of bank is non-zero
			while (bank[curPosition] != 0) {
				curPosition = bank[curPosition];
			}

			// check if it can cross the bank
			if (X - curPosition <= D)
				return i;
		}
		return -1;
	}

	int maxProd(int a[]) {
		int n = a.length;
		int temp[] = new int[n];
		temp[n - 1] = Integer.MIN_VALUE;
		int maxRight = a[n - 1];

		// check if it is a decreasing sequence, in that case return -1
		int j = 0;
		for (j = 0; j < n - 1; j++) {
			if (a[j] < a[j + 1])
				break;
		}
		if (j == n - 1)
			return -1;

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] >= maxRight) {
				temp[i] = Integer.MIN_VALUE;
				maxRight = a[i];
			} else {
				temp[i] = maxRight;
			}
		}

		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxProduct = Math.max(maxProduct, a[i] * temp[i]);
		}

		return maxProduct;
	}

	public int numTrees(int n) {
		if (n == 0)
			return 0;

		int dp[] = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = dp[i] + dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0)
			return result;
		int top = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;
		int left = 0;
		while (true) {

			// top row
			for (int j = left; j <= right; j++) {
				result.add(matrix[top][j]);
			}
			top++;
			if (isBoundaryCrossed(top, right, bottom, left))
				break;

			// right column
			for (int j = top; j <= bottom; j++) {
				result.add(matrix[j][right]);
			}
			right--;
			if (isBoundaryCrossed(top, right, bottom, left))
				break;

			// bottom row
			for (int j = right; j >= left; j--) {
				result.add(matrix[bottom][j]);
			}
			bottom--;
			if (isBoundaryCrossed(top, right, bottom, left))
				break;

			// left column
			for (int j = bottom; j >= top; j--) {
				result.add(matrix[j][left]);
			}
			left++;
			if (isBoundaryCrossed(top, right, bottom, left))
				break;
		}

		return result;
	}

	boolean isBoundaryCrossed(int top, int right, int bottom, int left) {
		if (top > bottom || left > right)
			return true;
		else
			return false;
	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if (rowIndex < 0)
			return result;
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			temp = result;
			result = new ArrayList<>();
			for (int j = 0; j <= temp.size(); j++) {
				if (j == 0)
					result.add(temp.get(j));
				else if (j == temp.size())
					result.add(temp.get(j - 1));
				else
					result.add(temp.get(j) + temp.get(j - 1));
			}
		}
		return result;
	}

	public List<Integer> getRow1(int rowIndex) {
		Integer a[] = new Integer[rowIndex + 1];
		Arrays.fill(a, 0);
		a[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				a[j] = a[j] + a[j - 1];
			}
		}
		return Arrays.asList(a);
	}

	int recur(int a[], int n) {
		int t;
		if (n == 1)
			return a[0];
		else {
			t = recur(a, n - 1);
			if (t < a[n - 1])
				return a[n - 1];
			else
				return t;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode cur = head;
		ListNode tail = head;
		ListNode prevTail = null;
		while (tail.next != null) {
			prevTail = tail;
			tail = tail.next;
		}

		while (cur != tail && cur.next != tail) {
			tail.next = cur.next;
			cur.next = tail;
			cur = tail.next;
			tail = prevTail;
			prevTail = cur;
			while (prevTail != tail && prevTail.next != tail) {
				prevTail = prevTail.next;
			}
		}
	}

	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < len; i++) {
			hm.put(nums[i], 1);
		}
		int longestSequence = 1;
		int max = 0;
		int min = 0;
		int curSequence = 1;
		for (int val : hm.keySet()) {
			min = val;
			max = val;
			curSequence = 1;
			// check if keys making sequence exist
			// to consider value it should be 1, otherwise it's already used in
			// previous sequence
			while (((hm.get(min - 1) != null) && (hm.get(min - 1) == 1))
					|| ((hm.get(max + 1) != null) && (hm.get(max + 1) == 1))) {
				if ((hm.get(min - 1) != null) && (hm.get(min - 1) == 1)) {
					hm.put(min - 1, hm.get(min - 1) - 1);
					min--;
					curSequence++;
				}
				if ((hm.get(max + 1) != null) && (hm.get(max + 1) == 1)) {
					hm.put(max + 1, hm.get(max + 1) - 1);
					max++;
					curSequence++;
				}
				if (curSequence > longestSequence)
					longestSequence = curSequence;
			}
		}
		return longestSequence;
	}

	public boolean isValid(String s) {
		HashMap<Character, Character> hm = new HashMap<>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i)))
				stack.push(s.charAt(i));
			else {
				if (stack.size() >= 1 && s.charAt(i) == hm.get(stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.size() != 0)
			return false;
		return true;
	}

	public boolean isSelfCrossing(int[] x) {
		for (int i = 3; i < x.length; i++) {
			// if current line crosses 3 lines ahead of it
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
				return true;

			// if current line meets 4 lines ahead of it
			if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] == x[i - 2])
				return true;

			// if current line crosses 5 lines ahead of it
			if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2]
					&& x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3])
				return true;
		}
		return false;
	}

	int findMinHelper(int nums[], int start, int end) {
		while (start < end) {
			if (nums[start] < nums[end])
				return nums[start];
			int mid = (start + end) / 2;
			if (nums[mid] > nums[start]) {
				start = mid + 1;
			} else if (nums[mid] < nums[start]) {
				end = mid;
			} else {
				if (nums[mid] > nums[end])
					start = mid + 1;
				else {
					// check which side to proceed
					boolean left = false;
					boolean right = false;
					int tempBegin = mid - 1;
					int tempEnd = mid + 1;
					while (tempBegin >= start || tempEnd <= end) {
						if (tempBegin >= start) {
							if (nums[tempBegin] < nums[mid]) {
								left = true;
								break;
							}
							tempBegin--;
						}
						if (tempEnd <= end) {
							if (nums[tempEnd] < nums[mid]) {
								right = true;
								break;
							}
							tempEnd++;
						}
					}
					if (left)
						end = mid;
					else if (right)
						start = mid + 1;
					else
						return nums[mid];
				}
			}
		}
		return nums[start];
	}

	boolean isSubset(int a[], int sum) {
		boolean dp[][] = new boolean[sum + 1][a.length + 1];

		// first row is all true
		for (int i = 0; i <= a.length; i++) {
			dp[0][i] = true;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= a.length; j++) {
				if (i >= a[j - 1])
					dp[i][j] = dp[i][j - 1] || dp[i - a[j - 1]][j - 1];
				else
					dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[sum][a.length];
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<List<Integer>>> dp = new ArrayList<>();
		for (int i = 1; i <= target; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			for (int j = 0; j < candidates.length; j++) {
				if (candidates[j] <= i) {
					int rem = i - candidates[j];
					if (rem == 0)
						temp.add(Arrays.asList(candidates[j]));
					else {
						for (List<Integer> l : dp.get(rem - 1)) {
							// to avoid duplicacy and keep sequence in ascending
							// order
							if (candidates[j] <= l.get(0)) {
								List<Integer> a = new ArrayList<>();
								a.add(candidates[j]);
								a.addAll(l);
								temp.add(a);
							}
						}
					}
				}
			}
			dp.add(temp);
		}
		return dp.get(target - 1);
	}

	public int lengthOfLIS(int[] nums) {
		int dp[] = new int[nums.length];
		int len = 0;
		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}
		return len;
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		return subsetsWithDupHelper(nums, 0);
	}

	List<List<Integer>> previous;

	List<List<Integer>> subsetsWithDupHelper(int[] nums, int start) {
		List<List<Integer>> result = new ArrayList<>();

		if (start == nums.length) {
			result.add(new ArrayList<Integer>());
		} else {
			List<List<Integer>> nextSubsets = subsetsWithDupHelper(nums,
					start + 1);
			result.addAll(nextSubsets);

			// check if current element is same as next
			// in case its true, add current element only to previous
			if (start < nums.length - 1 && nums[start] == nums[start + 1])
				nextSubsets = previous;
			previous = new ArrayList<>();
			for (List<Integer> l : nextSubsets) {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[start]);
				temp.addAll(l);
				previous.add(temp);
				result.add(temp);
			}
		}
		return result;
	}

	boolean findDuplicate(int a[]) {
		int cur = 0;
		// maximum swaps can be n - 1, in that case in last iteration cur will
		// be moved to a.length
		for (int i = 0; i < a.length; i++) {
			while (cur < a.length && a[cur] == cur) {
				cur++;
			}
			if (cur == a.length)
				return false;
			int temp = a[cur];
			a[cur] = a[temp];
			if (a[temp] == temp)
				return true;
			a[temp] = temp;
		}
		return false;
	}

	public int calculate(String s) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					sum = sum * 10 + (s.charAt(i) - '0');
					i++;
				}
				i--;
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;
	}

	public int[] countBits(int num) {
		int result[] = new int[num + 1];
		if (num == 0)
			return result;
		result[0] = 0;
		int lastPowerOfTwo = 0;
		int curPower = 0;
		for (int i = 1; i <= num; i++) {
			// check if current number is power of 2
			if (Math.pow(2, curPower) == i) {
				result[i] = 1;
				lastPowerOfTwo = i;
				curPower++;
			} else {
				result[i] = result[lastPowerOfTwo] + result[i - lastPowerOfTwo];
			}
		}
		return result;
	}

	void countRepeated(String str) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!hm.containsKey(str.charAt(i)))
				hm.put(str.charAt(i), 1);
			else
				hm.put(str.charAt(i), 2);
		}

		int result = 0;
		for (char key : hm.keySet()) {
			if (hm.get(key) == 2)
				result++;
		}

		System.out.println(result);
	}

	void verifyMail(String str) {
		Pattern p = Pattern.compile(
				"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		if (m.matches())
			System.out.println("Valid email");
		else
			System.out.println("Invalid email");
	}

	List<String> getOneEditWords(String curWord, Set<String> wordList,
			String endWord) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < curWord.length(); i++) {
			char ch[] = curWord.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != curWord.charAt(i)) {
					ch[i] = c;
					String str = new String(ch);
					if (wordList.contains(str)) {
						result.add(str);
						if (!str.equals(endWord))
							wordList.remove(str);
					}
				}
			}
		}
		return result;
	}

	public String getPermutation(int n, int k) {

		int fact[] = new int[n + 1];
		List<Integer> numbers = new ArrayList<>();
		fact[0] = 1;
		int f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
			fact[i] = f;
		}

		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}

		k--;
		String result = "";
		for (int i = 1; i <= n; i++) {
			int index = k / fact[n - i];
			result += numbers.get(index);
			numbers.remove(index);
			k -= (index * fact[n - i]);
		}

		return result;
	}

	public String countAndSay(int n) {
		String str = "1";
		for (int i = 1; i < n; i++) {
			str = findNextSequence(str);
		}
		return str;
	}

	String findNextSequence(String str) {
		char c = str.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
			else {
				sb.append(count);
				sb.append(c);
				c = str.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(c);

		return sb.toString();
	}

	public void nextPermutation(int[] nums) {
		int i;
		for (i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				break;
		}
		if (i == 0)
			Arrays.sort(nums);
		else {
			// sort right side
			// search for smallest element greater than nums[i - 1] for swapping
			Arrays.sort(nums, i, nums.length);
			int j;
			for (j = i; j < nums.length; j++) {
				if (nums[j] > nums[i - 1])
					break;
			}
			int temp = nums[j];
			nums[j] = nums[i - 1];
			nums[i - 1] = temp;
		}
		System.out.println(Arrays.toString(nums));
	}

	int findDuplicateInArray(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		slow = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		for (Interval cur : intervals) {
			int startInterval = cur.start;
			int endInterval = cur.end;
			int i = 0;
			List<Interval> removeElements = new ArrayList<>();
			for (i = 0; i < result.size(); i++) {
				Interval inter = result.get(i);
				if ((startInterval >= inter.start && startInterval <= inter.end)
						|| (endInterval >= inter.start && endInterval <= inter.end)
						|| (startInterval >= inter.start && endInterval <= inter.end)
						|| (startInterval <= inter.start && endInterval >= inter.end)) {
					startInterval = Math.min(startInterval, inter.start);
					endInterval = Math.max(endInterval, inter.end);
					removeElements.add(inter);
				}
			}
			for (Interval iv : removeElements) {
				result.remove(iv);
			}
			result.add(new Interval(startInterval, endInterval));
		}
		return result;
	}

	public int maxProfit(int[] prices) {
		int trans = 2;
		int dp[][] = new int[trans + 1][prices.length];

		for (int i = 1; i <= trans; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < prices.length; j++) {
				min = Math.min(min, prices[j - 1] - dp[i - 1][j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
			}
		}
		return dp[trans][prices.length - 1];
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if ((m + n) % 2 != 0)
			return (double) findMedianSortedArraysHelper(nums1, 0, m - 1,
					nums2, 0, n - 1, (m + n + 1) / 2);
		else
			return ((double) findMedianSortedArraysHelper(nums1, 0, m - 1,
					nums2, 0, n - 1, (m + n + 1) / 2) + (double) findMedianSortedArraysHelper(
					nums1, 0, m - 1, nums2, 0, n - 1, (m + n + 2) / 2)) / 2;
	}

	int findMedianSortedArraysHelper(int nums1[], int start1, int end1,
			int nums2[], int start2, int end2, int size) {
		if (start1 > end1)
			return nums2[start2 + size - 1];
		if (start2 > end2)
			return nums1[start1 + size - 1];

		int mid1 = (start1 + end1) / 2;
		int mid2 = (start2 + end2) / 2;

		if (nums1[mid1] <= nums2[mid2]) {
			if (size <= (mid1 - start1) + (mid2 - start2) + 1)
				return findMedianSortedArraysHelper(nums1, start1, end1, nums2,
						start2, mid2 - 1, size);
			else
				return findMedianSortedArraysHelper(nums1, mid1 + 1, end1,
						nums2, start2, end2, size - (mid1 - start1) - 1);
		} else {
			if (size <= (mid1 - start1) + (mid2 - start2) + 1)
				return findMedianSortedArraysHelper(nums1, start1, mid1 - 1,
						nums2, start2, end2, size);
			else
				return findMedianSortedArraysHelper(nums1, start1, end1, nums2,
						mid2 + 1, end2, size - (mid2 - start2) - 1);
		}
	}

	// use window of left and right
	// reuse the value of z[i - left] if it doesn't touch/cross window,
	// otherwise recreate window
	long stringSimilarity(String a) {
		long result = a.length();
		int z[] = new int[a.length()];
		int left = 0;
		int right = 0;
		for (int i = 1; i < a.length(); i++) {
			if (i > right) {
				left = i;
				right = i;
				while (right < a.length()
						&& a.charAt(right) == a.charAt(right - left)) {
					right++;
				}
				z[i] = right - left;
				right--;
			} else {
				if (z[i - left] < right - i + 1)
					z[i] = z[i - left];
				else {
					left = i;
					right++;
					while (right < a.length()
							&& a.charAt(right) == a.charAt(right - left)) {
						right++;
					}
					z[i] = right - left;
					right--;
				}
			}
		}
		for (int i : z) {
			result += i;
		}
		return result;
	}

	public int superPow(int a, int[] b) {
		BigInteger result = BigInteger.valueOf(1);
		BigInteger cons = BigInteger.valueOf(1337);
		BigInteger aPower = BigInteger.valueOf(a);
		for (int i = b.length - 1; i >= 0; i--) {
			BigInteger d = BigInteger.valueOf(b[i]);
			result = aPower.modPow(d, cons).multiply(result);
			aPower = aPower.modPow(BigInteger.valueOf(10), cons);
		}
		return result.intValue();
	}

	public static void main(String[] args) {
		General g = new General();
		int b[] = {2, 0, 0};
		System.out.println(g.superPow(2147483647, b));
	}
}