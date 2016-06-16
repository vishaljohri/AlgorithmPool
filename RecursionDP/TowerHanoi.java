
public class TowerHanoi {
	
	public void moveDisks(int discs, String origin, String buffer, String destination) {
		if(discs == 1) {
			System.out.println(origin + "->" + destination);
		}
		else {
			moveDisks(discs-1, origin, destination, buffer);
			System.out.println(origin + "->" + destination);
			moveDisks(discs-1, buffer, origin, destination);
		}
	}

	public static void main(String[] args) {
		TowerHanoi th = new TowerHanoi();
		th.moveDisks(4, "A", "B", "C");
	}

}
