package ex02_interface;

interface Animal {
	void eat();  // public abstract void eat();
}

class Lion implements Animal {
	// 반드시 구현해야 하는 추상 메소드
	@Override
	public void eat() {
		System.out.println("사자가 먹는다.");
	}
	// Lion만 가지고 있는 일반 메소드
	public void run() {
		System.out.println("사자는 달린다.");
	}
}

class Shark implements Animal {
	// 반드시 구현해야 하는 추상 메소드
	@Override
	public void eat() {
		System.out.println("상어가 먹는다.");
	}
	// Shark만 가지고 있는 일반 메소드
	public void swim() {
		System.out.println("상어는 헤엄친다.");
	}
}

class Eagle implements Animal {
	// 반드시 구현해야 하는 추상 메소드
	@Override
	public void eat() {
		System.out.println("독수리가 먹는다.");
	}
	// Eagle만 가지고 있는 일반 메소드
	public void fly() {
		System.out.println("독수리는 하늘을 난다.");
	}
}

class Zoo {
	// field
	private Animal[] animals;
	private int idx;
	// constructor
	public Zoo() {
		animals = new Animal[3];
	}
	// method
	public void addAnimal(Animal animal) {
		animals[idx++] = animal;
	}
	public void animalListInfo() {
		for (Animal animal : animals) {
			if (animal != null) {
				animal.eat();  // 구현한 메소드
				if (animal instanceof Lion) {
					((Lion) animal).run();
				} else if (animal instanceof Shark) {
					((Shark) animal).swim();
				} else if (animal instanceof Eagle) {
					((Eagle) animal).fly();
				}
			}
		}
	}
}

public class Ex02_Animal {

	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		zoo.addAnimal(new Lion());
		zoo.addAnimal(new Shark());
		zoo.addAnimal(new Eagle());
		zoo.animalListInfo();

	}

}