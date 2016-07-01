import java.util.Iterator;



public class CircularArray<T> implements Iterable<T>{
	private T[] items;
	private int head = 0;
	
	public CircularArray(int size) {
		items = (T[])new Object[size];
	}
	
	private int convert(int index) {
		if(index < 0)
			index += items.length;
		return((head + index) % items.length);
	}
	
	public void rotate(int rightShift) {
		head = convert(rightShift);
	}
	
	public T get(int i) {
		if(i < 0 || i >= items.length)
			throw new java.lang.IndexOutOfBoundsException();
		return(items[convert(i)]);
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}

	class CircularArrayIterator<T1> implements Iterator<T1> {
		
		private int current = -1;
		private T1[] items;
		public CircularArrayIterator(CircularArray<T1> array) {
			items = array.items;
		}
		@Override
		public boolean hasNext() {
			return current < (items.length - 1);
		}

		@Override
		public T1 next() {
			current++;
			T1 item = (T1)items[convert(current)];
			return item;
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	public static void main(String[] args) {
		CircularArray<Integer> ca = new CircularArray<>(6);
		ca.set(0, 1);
		ca.set(1, 2);
		ca.set(2, 3);
		ca.set(3, 4);
		ca.set(4, 5);
		ca.set(5, 6);
		
		for(Integer i : ca) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		ca.rotate(4);
		for(Integer i : ca) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	

}
