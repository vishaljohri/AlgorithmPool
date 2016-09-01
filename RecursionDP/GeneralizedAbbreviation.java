
import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

	public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<>();
		generateAbbreviationsHelper(word, 0, result, true);
		return result;
	}

	void generateAbbreviationsHelper(String word, int cur, List<String> result, boolean isOriginal) {
		if(!isOriginal)
			result.add(word);
		for(int i = cur; i < word.length(); i++) {
			String newWord = "";
			if(i > 0 && Character.isDigit(word.charAt(i - 1))) {
				int d = word.charAt(i - 1) - '0' + 1;
				newWord = word.substring(0, i - 1) + d + word.substring(i + 1);
				generateAbbreviationsHelper(newWord, i, result, false);
			}
			else {
				newWord = word.substring(0, i) + 1 + word.substring(i + 1);
				generateAbbreviationsHelper(newWord, i + 1, result, false);
			}
		}
	}

	public static void main(String[] args) {
		GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
		System.out.println(ga.generateAbbreviations("word"));
	}
}
