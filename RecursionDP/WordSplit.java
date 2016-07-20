
import java.util.ArrayList;

public class WordSplit {
	
	boolean dictionaryContains(String str) {
		ArrayList<String> dictionary = new ArrayList<>();
		dictionary.add("mobile"); 
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
		
		if(dictionary.contains(str))
			return true;
		else 
			return false;
	
	}
	
	boolean splitSequence(String str) {
		int size = str.length();
		if(size == 0)
			return true;
		for(int i = 0; i < size; i++) {
			if(dictionaryContains(str.substring(0, i+1)) && splitSequence(str.substring(i+1)))
				return true;
		}
		return false;
	}

	boolean wordBreakDynamicProgramming(String str) {
		int size = str.length();
		boolean dp[] = new boolean[size];
		
		for(int i = 0; i < size; i++) {
			
			if(dp[i] == false && dictionaryContains(str.substring(0, i+1)))
				dp[i] = true;
			
			if(dp[i] == true) {
				if(i == size-1)
					return true;
				for(int j = i+1; j < size; j++) {
					if(dp[j] == false && dictionaryContains(str.substring(i+1, j+1)))
						dp[j] = true;
					if(j == size-1 && dp[j] == true)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "ilikesamsunggo";
		WordSplit w = new WordSplit();
		System.out.println(w.splitSequence(str));
		System.out.println(w.wordBreakDynamicProgramming(str));
	}

}
