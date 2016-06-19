
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Unchecked Exception
class ProductNotPresentException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int productID;
	public ProductNotPresentException(String message, int productID) {
		super(message);
		this.productID = productID;
	}
	public int getProductID() {
		return productID;
	}
	@Override
	public String getMessage() {
		return super.getMessage() + " product id: " + productID;
	}
	@Override
	public String toString() {
		return super.toString();
	}	
}


class ProductFactory {
	HashMap<Integer, String> products = new HashMap<>();
	void addProduct(int id, String name) {
		products.put(id, name);
	}
	
	String getProduct(int id) {
		if(products.containsKey(id) == false)
			throw new ProductNotPresentException("Product is not present", id);
		return products.get(id);
	}
}


//Checked Exception
class InsufficientFundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double amount;

	public InsufficientFundException(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}

class CheckingAccount {
	private int accountNumber;
	private double balance;
	public CheckingAccount(int account) {
		balance = 0.0;
		accountNumber = account;
	}
	
	void deposit(double amount) {
		balance += amount;
	}
	
	void withdraw(double amount) throws InsufficientFundException {
		if(amount > balance) {
			System.out.println("insufficient funds");
			throw new InsufficientFundException(amount - balance);
		}
		else {
			balance -= amount;
			System.out.println("amount is successfully withdrawn: " + amount);
		}
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
}
public class ExceptionHandling {

	public static void main(String[] args) {
		
		
		//file handling
		FileReader fileReader = null;
		try {
			File file = new File("test.txt");
			fileReader = new FileReader(file);
			char []a = new char[50];
			fileReader.read(a);
			for(char c : a) {
				System.out.print(c);
			}
			System.out.println();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//try with resources
		try(FileReader fileReader1 = new FileReader("test.txt")) {
			char []a = new char[50];
			fileReader1.read(a);
			for(char c : a) {
				System.out.print(c);
			}
			System.out.println();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		
		//arithmetic exceptions
		try {
			int a[] = new int[5];
			a[5] = 1;
		}
		catch(ArrayIndexOutOfBoundsException | ArithmeticException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		System.out.println("finally block");
		}
		System.out.println("excption successfully handled, continue further");
		
		
		//user defined exceptions
		System.out.println("trying out user defined exceptions");
		CheckingAccount ca = new CheckingAccount(14);
		ca.deposit(100);
		ca.deposit(60.5);
		System.out.println(ca.getBalance());
		try {
			ca.withdraw(90);
			ca.withdraw(72.5);
		} catch (InsufficientFundException e) {
			System.out.println("deposit this amount to proceed: " + e.getAmount());
			e.printStackTrace();
		}
		System.out.println("balance left: " + ca.getBalance());
		
		//test unchecked exception
		ProductFactory productFactory = new ProductFactory();
		productFactory.addProduct(1, "pizza");
		productFactory.addProduct(2, "donut");
		productFactory.addProduct(3, "calzone");
		productFactory.addProduct(4, "burger");
		productFactory.addProduct(5, "salad");
		
		System.out.println(productFactory.getProduct(1));
		System.out.println(productFactory.getProduct(2));
		System.out.println(productFactory.getProduct(8));
		System.out.println(productFactory.getProduct(4));
		System.out.println(productFactory.getProduct(5));
	}

}
