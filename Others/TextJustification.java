
import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		List<List<String>> wordsInOneLine = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			int cur = 0;
			List<String> curLine = new ArrayList<String>();
			cur += words[i].length();
			while (i < words.length && cur <= maxWidth) {
				curLine.add(words[i++]);
				cur++;
				if (i < words.length)
					cur += words[i].length();
			}
			wordsInOneLine.add(curLine);
			i--;
		}

		// allot spaces
		for (int p = 0; p < wordsInOneLine.size()- 1; p++) {
			List<String> str = wordsInOneLine.get(p);
			int noSpaces = str.size() - 1;
			String oneLine = "";
			if (noSpaces > 0) {
				int c = 0;
				for (String s : str) {
					c += s.length();
				}
				int remChars = maxWidth - c;
				int a[] = new int[noSpaces];
				int i = 0;
				while (remChars != 0) {
					a[i]++;
					i++;
					i = i % noSpaces;
					remChars--;
				}
				for (int j = 0; j < str.size() - 1; j++) {
					oneLine += str.get(j);
					for (int k = 0; k < a[j]; k++) {
						oneLine += " ";
					}
				}
				oneLine += str.get(str.size() - 1);
			}
			else {
				oneLine += str.get(str.size() - 1);
				int remChars = maxWidth - oneLine.length();
				while(remChars > 0) {
					oneLine += " ";
					remChars--;
				}
			}
			
			result.add(oneLine);
		}
		
		//last line
		String lastLine = "";
		List<String> last = wordsInOneLine.get(wordsInOneLine.size() - 1);
		for(int i = 0; i < last.size() - 1; i++) {
			String s = last.get(i);
			lastLine = lastLine + s + " ";
		}
		lastLine += last.get(last.size() - 1);
		int rem = maxWidth - lastLine.length();
		while(rem > 0) {
			lastLine += " ";
			rem--;
		}
		result.add(lastLine);

		return result;
	}

	public static void main(String[] args) {
		TextJustification tf = new TextJustification();
		String words[] = {"What","must","be","shall","be."};
		System.out.println(tf.fullJustify(words, 12));

	}

}
