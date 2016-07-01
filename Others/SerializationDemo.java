import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Employee implements Serializable {
	String name;
	String address;
	transient int ssn;
	int number;

	public void mailCheck() {
		System.out.println("mailing a check to " + name + " " + address);
	}
}

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*Employee e = new Employee();
		e.name = "Vishal";
		e.address = "university pointe";
		e.ssn = 1234;
		e.number = 14;
		
		//write to the file
		FileOutputStream fout = new FileOutputStream("output.ser");
		ObjectOutputStream  out = new ObjectOutputStream(fout);
		out.writeObject(e);
		out.close();
		fout.close();
		System.out.println("serialization done.");*/
		
		Employee e = null;
		
		//read from the file
		FileInputStream fInput = new FileInputStream("output.ser");
		ObjectInputStream oInput = new ObjectInputStream(fInput);
		e = (Employee) oInput.readObject();
		oInput.close();
		fInput.close();
		
		System.out.println(e.name);
		System.out.println(e.address);
		System.out.println(e.ssn);
		System.out.println(e.number);
		

	}

}
