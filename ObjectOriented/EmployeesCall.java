
import java.util.ArrayList;

abstract class Employee {
	private String name;
	private String phoneNumber;
	boolean isBusy;
	public Employee(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isBusy = false;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public boolean getIsBusy() {
		return isBusy;
	}
	
	public void answerCall() {
		
	}
	
	public void endCall() {
		
	}
	
	public void escalateCall() {
		
	}
}

class Respondent extends Employee {

	public Respondent(String name, String phoneNumber) {
		super(name, phoneNumber);
	}
	
	public void answerCall() {
		isBusy = true;
		System.out.println("Hi I am respondent: " + this.getName() + " how may I help you? ");
	}
	
	public void endCall() {
		isBusy = false;
		System.out.println("Thanks for calling. Have a nice day!");
	}
	
	public void escalateCall() {
		
	}
	
}

class Manager extends Employee {

	public Manager(String name, String phoneNumber) {
		super(name, phoneNumber);
	}
	
	public void answerCall() {
		isBusy = true;
		System.out.println("Hi I am Manager: " + this.getName() + " how may I help you? ");
	}
	
	public void endCall() {
		isBusy = false;
		System.out.println("Thanks for calling. Have a nice day!");
	}
	
	public void escalateCall() {
		
	}
	
}

class Director extends Employee {

	public Director(String name, String phoneNumber) {
		super(name, phoneNumber);
	}
	
	public void answerCall() {
		isBusy = true;
		System.out.println("Hi I am Director: " + this.getName() + " how may I help you? ");
	}
	
	public void endCall() {
		isBusy = false;
		System.out.println("Thanks for calling. Have a nice day!");
	}
	
	public void escalateCall() {
		
	}
	
}

class CallHandler {
	private static CallHandler handler;
	private CallHandler () {
		
	}
	static synchronized CallHandler getInstance() {
		if(handler == null) {
			handler = new CallHandler();
		}
		return handler;
	}
	
	void dispatchCall(ArrayList<ArrayList<Employee>> allEmployees) {
		for(int i = 0; i < 3; i ++) {
			int k = 0;
			while(k < allEmployees.get(i).size()) {
				if(allEmployees.get(i).get(k).isBusy == false) {
					allEmployees.get(i).get(k).answerCall();
					return;
				}
				k++;
			}
		}
		System.out.println("sorry all are busy");
		
	}
	
}


public class EmployeesCall {

	public static void main(String[] args) {
		ArrayList<ArrayList<Employee>> employees = new ArrayList<>();
		
		employees.add(new ArrayList<Employee>());
		employees.add(new ArrayList<Employee>());
		employees.add(new ArrayList<Employee>());
		
		employees.get(0).add(new Respondent("R1", "1234567890"));
		employees.get(0).add(new Respondent("R2", "1234567890"));
		employees.get(0).add(new Respondent("R3", "1234567890"));
		employees.get(0).add(new Respondent("R4", "1234567890"));
		
		employees.get(1).add(new Manager("M1", "1234567890"));
		employees.get(1).add(new Manager("M1", "1234567890"));
		
		employees.get(2).add(new Director("D1", "1234567890"));
		
		for(int i = 1; i <= 9; i++) {
			CallHandler.getInstance().dispatchCall(employees);
		}

	}

}
