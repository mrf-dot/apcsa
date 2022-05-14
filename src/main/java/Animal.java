import java.util.ArrayList;

public class Animal {
	public static void main(String[] args) {
		Dog d1 = new Dog("Fido", "Mutt", 5, 12.5);
		d1.getAge();
		d1.MakeNoise();
		Pet p1 = new Pet("Pinky", 5, 11);
		p1.MakeNoise();
		Animal a1 = new Animal(2, 26);
		// a1.MakeNoise(); // Causes error
		p1 = new Dog("Ziggy", "Pug", 8, 17);
		p1.MakeNoise();
		a1 = new Dog("Rascal", "Greyhound", 8, 17);
		// a1.MakeNoise(); // Causes error
		ArrayList<Animal> kennel = new ArrayList<Animal>();
		kennel.add(new Dog());
		kennel.add(new Cat());
		kennel.add(new Bird());
		kennel.add(new Dog());
		for (Animal a : kennel)
			System.out.println(a.getAge());
		for (int i = 0; i < kennel.size(); i++) {
			if (kennel.get(i) instanceof Dog)
				((Dog) kennel.get(i)).bark();
		}

	}

	private int age;
	private double weight;

	public Animal() {
		age = 0;
		weight = 0.0;
	}

	public Animal(int a, double w) {
		if (a >= 0)
			age = a;
		else
			age = 0;
		if (w > 0)
			weight = w;
		else
			weight = -1;
	}

	public String toString() {
		return "age: " + age + "\nweight: " + weight;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}
}

class Pet extends Animal {
	private String name;

	public Pet() {
		super();
	}

	public Pet(String n, int a, double w) {
		super(a, w);
		name = n;
	}

	public void MakeNoise() {
		System.out.println("GRRRR");
	}

	public String toString() {
		return name + "\n" + super.toString();
	}

	public String getName() {
		return name;
	}
}

class Bird extends Pet {
}

class Cat extends Pet {
}

class Dog extends Pet {
	private String breed;

	public Dog() {
		super();
	}

	public Dog(String n, String b, int a, double w) {
		super(n, a, w);
		breed = b;
	}

	public void MakeNoise() {
		System.out.println("Bark! Bark!");
	}

	public String toString() {
		return super.toString() + "\nbreed: " + breed;
	}

	public void bark() {
		System.out.println("Woof");
	}
}
