
import java.util.ArrayList;
import java.util.List;

class Subject {
	private List<ObserverImpl> observers = new ArrayList<>();
	private int state;
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}
	
	public void attach(ObserverImpl o) {
		observers.add(o);
	}
	
	public void notifyAllObservers() {
		for(ObserverImpl o : observers) {
			o.update();
		}
	}
}

abstract class ObserverImpl {
	Subject subject;
	public abstract void update();
	
}

class BinaryObserver extends ObserverImpl {
	
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	@Override
	public void update() {
		System.out.println("binary string : " + Integer.toBinaryString(subject.getState()));
		
	}
	
}

class HexadecimalObserver extends ObserverImpl {
	
	public HexadecimalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	@Override
	public void update() {
		System.out.println("hexadecimal string : " + Integer.toHexString(subject.getState()));
		
	}
	
}

public class Observer {

	public static void main(String[] args) {
		Subject s = new Subject();
		new BinaryObserver(s);
		new HexadecimalObserver(s);
		s.setState(8);

	}

}
