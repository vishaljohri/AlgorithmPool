
import java.util.Arrays;

public class ReverseWords {
	
	public void reverseWords(String s) {
		int pointerEnd = s.length();
		int pointerBegin = s.length() - 1;
		StringBuilder sb = new StringBuilder();
		while(pointerBegin != 0) {
			char ch = s.charAt(pointerBegin);
			if(ch == ' ') {
				sb.append(s.substring(pointerBegin + 1, pointerEnd)).append(" ");
				pointerEnd = pointerBegin;
			}
			pointerBegin--;
		}
		sb.append(s.substring(pointerBegin, pointerEnd));
		System.out.println(String.valueOf(sb));
	}
	
	public void reverseWordsInPlace(char[] s) {
		int j = 0;
		int i = 0;
		for(i = 0; i < s.length; i++) {
			if(s[i] == ' ') {
				reverse(s, j, i - 1);
				j = i + 1;
			}
		}
		reverse(s, j, i - 1);
		reverse(s, 0, s.length - 1);
		System.out.println(Arrays.toString(s));
	}
	
	void reverse(char ch[], int start, int end) {
		while(start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		rw.reverseWords("the sky is blue");
		char ch[] = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
		rw.reverseWordsInPlace(ch);
	}
}