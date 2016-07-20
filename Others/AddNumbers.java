
public class AddNumbers {

	public static void main(String[] args) {
		int a = 1059;
		int b = 11;
		int c = 0;
		String s = "";
		
		StringBuilder sb = new StringBuilder("");
		while(a != 0 || b != 0) {
			int la = a & 1;
			int lb = b & 1;
			sb = sb.insert(0, (c ^ la ^ lb)) ;
			a = a >> 1;
			b = b >> 1;
			c = (la & lb) | (c & la) | (c & lb);
		}
		sb = sb.insert(0, c);
		s = new String(sb);
		System.out.println(Integer.parseInt(s, 2));

	}

}
