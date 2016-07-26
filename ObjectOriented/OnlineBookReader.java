
import java.util.ArrayList;
import java.util.Hashtable;

class User {
	private String name;
	private String id;
	private boolean isMember;
	public User(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.isMember = false;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public boolean isMember() {
		return isMember;
	}
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	void getMembership() {
		isMember = true;
	}
	
	void requestBook(Book b, Library l) {
		l.displayBook(b, this);
	}
	
}

class Book {
	private String name;
	private int id;
	public Book(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

class Library {
	private ArrayList<Book> allBooks = new ArrayList<>();
	
	void addBook(Book b) {
		allBooks.add(b);
		System.out.println("successfully added: " + b.getName());
	}
	
	void removeBook(Book b) {
		if(allBooks.contains(b)) {
			allBooks.remove(b);
			System.out.println("successfully removed: " + b.getName());
			return;
		}
		System.out.println("book is not in library");
	}
	
	void displayBook(Book b, User u) {
		if(u.isMember() == false) {
			System.out.println("sorry you are not a memeber");
			return;
		}
			
		if(allBooks.contains(b)) {
			System.out.println("Display the book titled :" + b.getName());
		}
		else
			System.out.println("there is no such book");
	}
}

class RequestHandler {
	
}

public class OnlineBookReader {

	public static void main(String[] args) {
		Book b1 = new Book("a", 1);
		Book b2 = new Book("b", 1);
		Book b3 = new Book("c", 1);
		Book b4 = new Book("d", 1);
		Book b5 = new Book("e", 1);
		
		Library l = new Library();
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.addBook(b4);
		
		User u1 = new User("vishal", "1");
		u1.setMember(true);
		u1.requestBook(b1, l);
		u1.requestBook(b5, l);
		
		User u2 = new User("x", "2");
		u2.requestBook(b1, l);
		u2.requestBook(b5, l);

	}

}
