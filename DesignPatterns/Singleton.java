
public class Singleton {
	private static Singleton single;
	private Singleton() {
	}
	public static Singleton getInstance() {
		if(single == null) {
			synchronized (Singleton.class) {
				if(single == null)
					single = new Singleton();
			}
		}
		return single;
	}

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}

}
