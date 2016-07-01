import java.util.LinkedList;

abstract class Animal {
	String name;
	private int order;
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Animal(String name) {
		this.name = name;
	}
}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}
}

public class AnimalShelter {
	java.util.Queue<Dog> dogs = new LinkedList<>();
	java.util.Queue<Cat> cats = new LinkedList<>();
	int count = 0;
	
	void enqueueAnimal(Animal a) {
		count++;
		a.setOrder(count);
		if(a instanceof Dog) {
			dogs.add((Dog)a);
		}
		else {
			cats.add((Cat)a);
		}
	}
	
	Animal DequeueAny() {
		if((dogs.size() == 0) && (cats.size() == 0)) {
			System.out.println("no animals");
			return null;
		}
		else if(dogs.size() == 0) {
			return cats.poll();
		}
		else if(cats.size() == 0) {
			return cats.poll();
		}
		else {
			Cat c = cats.peek();
			Dog d = dogs.peek();
			if(c.getOrder() < d.getOrder())
				return cats.poll();
			else
				return dogs.poll();
		}
	}

	public static void main(String[] args) {
		Animal a1 = new Dog("Tommy");
		Animal a2 = new Dog("Happy");
		Animal a3 = new Cat("cat");
		Animal a4 = new Cat("smelly");
		AnimalShelter as = new AnimalShelter();
		as.enqueueAnimal(a1);
		as.enqueueAnimal(a2);
		as.enqueueAnimal(a3);
		as.enqueueAnimal(a4);
		Animal a5 = as.DequeueAny();
		System.out.println(a5.name);
		a5 = as.DequeueAny();
		System.out.println(a5.name);
		a5 = as.DequeueAny();
		System.out.println(a5.name);
		a5 = as.DequeueAny();
		System.out.println(a5.name);
		
	}

}
