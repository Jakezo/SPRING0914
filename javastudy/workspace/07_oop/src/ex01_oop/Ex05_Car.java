package ex01_oop;

class Engine {
	// field
	String type;	// 가솔린, 디젤
	int cc;			// 배기량
	int hp;			// 마력
	// constructor
	Engine(String type, int cc, int hp) {
		this.type = type;
		this.cc = cc;
		this.hp = hp;
	}
	// method
	void info() {
		System.out.println("=====엔진 사양=====");
		System.out.println("연료 타입: " + type);
		System.out.println("배기량: " + cc);
		System.out.println("마력: " + hp);
	}
}

class Car {
	// field
	String model;
	double fuelEfficiency;  // 연비
	Engine engine;
	// constructor
	Car(String model, double fuelEfficiency, Engine engine) {
		this.model = model;
		this.fuelEfficiency = fuelEfficiency;
		this.engine = engine;
	}
	Car(String model, double fuelEfficiency, String type, int cc, int hp) {
		this.model = model;
		this.fuelEfficiency = fuelEfficiency;
		this.engine = new Engine(type, cc, hp);
	}
	// method
	void info() {
		System.out.println("모델명: " + model);
		System.out.println("연비: " + fuelEfficiency);
		engine.info();
	}
}

public class Ex05_Car {

	public static void main(String[] args) {
		
		// 2개의 자동차를 생성하시오.
		Car car1 = new Car("e-class", 10.5, new Engine("디젤", 1998, 245));
		Car car2 = new Car("530i", 11.5, "가솔린", 1995, 255);
		car1.info();
		car2.info();

	}

}