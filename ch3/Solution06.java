package chapter3;

import java.util.LinkedList;

public class Solution06 {
	//Use to LinkedList to store dogs and cats separately
	//Associate a timestamp for each element when added
	//If an animal of any kind is poped, pop according to the timestamp
	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int timestamp = 0;
	
	class Animal {
		String name;
		int order;
		Animal(String name) {
			this.name = name;
			order = timestamp++;
		}
	}
	
	class Dog extends Animal {
		Dog (String name) {
			super(name);
		}
	}

	class Cat extends Animal {
		Cat (String name) {
			super(name);
		}
	}
	
	public void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.add((Dog) animal);
		}
		if (animal instanceof Cat) {
			cats.add((Cat) animal);
		}
	}
	
	public Animal dequeueAny() {
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.order < cat.order) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
	
	public Animal dequeueDog() {
		return dogs.poll();
	}
	
	public Animal dequeueCat() {
		return cats.poll();
	}
	
	public static void main(String[] args) {
		Solution06 s = new Solution06();
		Dog d1 = s.new Dog("dog1");
		Cat c1 = s.new Cat("cat1");
		Dog d2 = s.new Dog("dog2");
		Cat c2 = s.new Cat("cat2");
		s.enqueue(d1);
		s.enqueue(c1);
		s.enqueue(d2);
		s.enqueue(c2);
		System.out.println(s.dequeueCat().name);
		System.out.println(s.dequeueAny().name);
		System.out.println(s.dequeueDog().name);

	}

}
