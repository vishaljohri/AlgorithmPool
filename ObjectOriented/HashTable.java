
import java.util.ArrayList;
import java.util.LinkedList;

class Cell{
	int key;
	int value;
	public Cell(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}
}

class Bucket {
	int id;
	LinkedList<Cell> list = new LinkedList<>();
	public Bucket(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LinkedList<Cell> getList() {
		return list;
	}
	public void setList(LinkedList<Cell> list) {
		this.list = list;
	}
	
	void addValue(int key, int value) {
		list.add(new Cell(key, value));
	}
}

class Table {
	ArrayList<Bucket> allBuckets = new ArrayList<>();
	
	Table() {
		allBuckets.add(new Bucket(0));
		allBuckets.add(new Bucket(1));
		allBuckets.add(new Bucket(2));
		allBuckets.add(new Bucket(3));
		allBuckets.add(new Bucket(4));
	}
	int hashFunction(int x) {
		return x % 5;
	}
	
	void put(int key, int value) {
		int id = hashFunction(key);
		allBuckets.get(id).addValue(key, value);
	}
	
	int get(int n) {
		int id = hashFunction(n);
		LinkedList<Cell> list = allBuckets.get(id).list;
		for(int i = 0; i < list.size(); i++) {
			if(n == list.get(i).key)
				return list.get(i).value;
			
		}
		return -1;
	}
}

public class HashTable {

	public static void main(String[] args) {
		Table t = new Table();
		t.put(2, 9);
		t.put(7, 10);
		t.put(1, 9);
		t.put(6, 10);
		
		System.out.println(t.get(7));
		System.out.println(t.get(2));
		
		System.out.println((t.allBuckets.get(0).list));
		System.out.println((t.allBuckets.get(1).list));
		System.out.println((t.allBuckets.get(2).list));
		System.out.println((t.allBuckets.get(3).list));
		System.out.println((t.allBuckets.get(4).list));

	}

}
