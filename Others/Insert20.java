import java.util.ArrayList;



public class Insert20 {

	public static void main(String[] args) {
		String str = "Mr John Smith";
		ArrayList<Character> c = new ArrayList<>();
		for(char ch : str.toCharArray()) {
			c.add(ch);
		}
		int spaceCount = 0;
		for(int i = 0; i < c.size(); i++) {
			if(c.get(i) == ' ')
				spaceCount++;
		}
		int origSize = c.size();
		int newLength = c.size() + spaceCount*2;
		for (int i = c.size()-1; i < newLength-1; i++) {
			c.add(' ');
		}
		System.out.println("intermediate string: " + c);
		//c.set(newLength, '\0');
		newLength = newLength - 1;
		for(int i = origSize-1; i >=0; i--) {
			if(c.get(i) == ' ') {
				c.set(newLength--, '0');
				c.set(newLength--, '2');
				c.set(newLength--, '%');
			}
			else {
				c.set(newLength--, c.get(i));
			}
		}
		
		System.out.println("Modified String is: " + (c));

	}

}
