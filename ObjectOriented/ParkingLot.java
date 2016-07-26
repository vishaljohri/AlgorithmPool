
import java.util.ArrayList;

class Vehicle {
	String name;
	boolean isParked;

	public Vehicle(String name) {
		super();
		this.name = name;
	}

	public boolean isParked() {
		return isParked;
	}

	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}

	void requestParking() {

	}

	void RequestExit() {

	}
}

class TwoWheeler extends Vehicle {

	public TwoWheeler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	void requestParking() {
		ParkingHandler.park(this);
	}

	void RequestExit() {
		ParkingHandler.exit(this);

	}
}

class FourWheeler extends Vehicle {

	public FourWheeler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	void requestParking() {
		ParkingHandler.park(this);
	}

	void RequestExit() {
		ParkingHandler.exit(this);

	}
}

class ParkingHandler {
	static int twoWheelerSlots = 5;
	static int fourWheelerSlots = 4;

	static void park(Vehicle v) {
		if (v instanceof TwoWheeler) {
			if (twoWheelerSlots > 0) {
				System.out.println("two wheeler slot alloted: "
						+ twoWheelerSlots);
				twoWheelerSlots--;
				v.setParked(true);
			} else {
				System.out.println("no two wheeler avail slots");
			}
		} else if (v instanceof FourWheeler) {
			if (fourWheelerSlots > 0) {
				System.out.println("four wheeler slot alloted: "
						+ fourWheelerSlots);
				fourWheelerSlots--;
				v.setParked(true);
			} else {
				System.out.println("no four wheeler avail slots");
			}
		}

	}

	static void exit(Vehicle v) {
		if (v instanceof TwoWheeler) {
			twoWheelerSlots++;
			v.setParked(false);
		} else if (v instanceof FourWheeler) {
			fourWheelerSlots++;
			v.setParked(false);
		}

	}
}

public class ParkingLot {

	public static void main(String[] args) {
		ArrayList<Vehicle> allVehicles = new ArrayList<>();
		allVehicles.add(new TwoWheeler("fz"));
		allVehicles.add(new TwoWheeler("r15"));
		allVehicles.add(new TwoWheeler("duke"));
		allVehicles.add(new TwoWheeler("ninja"));
		allVehicles.add(new TwoWheeler("pulsar"));
		allVehicles.add(new TwoWheeler("ducati"));

		allVehicles.add(new FourWheeler("bmw"));
		allVehicles.add(new FourWheeler("audi"));
		allVehicles.add(new FourWheeler("hyundai"));
		allVehicles.add(new FourWheeler("honda"));
		allVehicles.add(new FourWheeler("maruti"));

		for (Vehicle v : allVehicles) {
			v.requestParking();
		}

	}

}
