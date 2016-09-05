import java.util.ArrayList;
import java.util.List;

// s will have only +/-. 
// In the game each user flips ++ to -- till there are any left
public class FlipGame {
	
	
	public List<String> generatePossibleNextMoves(String s) {
		char ch[] = s.toCharArray();
		List<String> result = new ArrayList<>();
		for(int i = 0; i < s.length() - 1; i++) {
			if(ch[i] == ch[i + 1] && ch[i] == '+') {
				ch[i] = '-';
				ch[i + 1] = '-';
				result.add(String.valueOf(ch));
				ch[i] = '+';
				ch[i + 1] = '+';
			}
		}
		return result;
	}
	
	boolean canWin(String s) {
		if(s.length() == 0)
			return false;
		return canWinHelper(s.toCharArray());
	}
	
	boolean canWinHelper(char ch[]) {
		for(int i = 0; i < ch.length - 1; i++) {
			if(ch[i] == '+' && ch[i + 1] == '+') {
				ch[i] = '-';
				ch[i + 1] = '-';
				boolean win = canWinHelper(ch);
				ch[i] = '+';
				ch[i + 1] = '+';
				if(!win)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FlipGame fg = new FlipGame();
		System.out.println(fg.generatePossibleNextMoves("++++-++"));
		System.out.println(fg.canWin("++++"));

	}

}
