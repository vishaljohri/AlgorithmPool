
import java.util.Arrays;
import java.util.Comparator;

class Employee {
	String givenName;
	String surName;
	String extension;

	Employee(String givenName, String surName, String extension) {
		super();
		this.givenName = givenName;
		this.surName = surName;
		this.extension = extension;
	}

}

class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		int comp = o1.givenName.compareToIgnoreCase(o2.givenName);
		if (comp == 0)
			comp = o1.surName.compareToIgnoreCase(o2.surName);
		return comp;
	}

}

public class MultikeySort {

	public static void main(String[] args) {
		Employee[] e = { new Employee("Abc", "tfg", "m"),
				new Employee("fgb", "ash", "j"),
				new Employee("abc", "dhg", "l"),
				new Employee("fgb", "asa", "7") };
		Arrays.sort(e, new EmployeeComparator());
		for(Employee empl : e) {
			System.out.println(empl.givenName + " " + empl.surName + " " + empl.extension);
		}

	}

}
