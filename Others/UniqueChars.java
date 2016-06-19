
public class UniqueChars {

	public static void main(String[] args) {
		String str = "abcdesthxb";
		boolean []char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			if(char_set[str.charAt(i)]) {
				System.out.println("duplicate chars are present");
				System.exit(0);
			}
			else
				char_set[str.charAt(i)] = true;
		}
		System.out.println("no duplicate chars are present");

	}

}
