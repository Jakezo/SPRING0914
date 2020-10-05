package ex02_inheritance_quiz;

// 슈퍼클래스
class Elec {  // 전자제품
	
	// field
	int watt;  // 소비전력
	
	// constructor
	Elec(int watt) {
		this.watt = watt;
	}
	
	// method
	void info() {
		System.out.println("소비전력: " + watt + "w");
	}
	
}

// 서브클래스 (Elec 의 자식)
class Computer extends Elec {
	
	// field
	String model;
	int price;
	
	// constructor
	Computer(String model, int price, int watt) {
		super(watt);  // Elec 클래스의 constructor 호출
		this.model = model;
		this.price = price;
	}
	
	// method
	@Override
	void info() {
		System.out.print("모델: " + model + ", 가격: " + price + "만원, ");
		super.info();
	}
	
}

// 서브클래스 (Elec 의 자손, Computer 의 자식)
class Notebook extends Computer {
	
	// field
	int battery;
	
	// constructor
	Notebook(String model, int price, int battery, int watt) {
		super(model, price, watt);  // Computer 클래스의 constructor 호출
		this.battery = battery;
	}
	
	// method
	@Override
	void info() {
		System.out.print("배터리용량: " + battery + "w, ");
		super.info();  // Computer 클래스의 info 호출
	}
	
}

public class Quiz03 {

	public static void main(String[] args) {
		
		Computer com = new Computer("알라딘", 200, 500);
		com.info();  // 모델: 알라딘, 가격: 200만원, 소비전력: 500w
		
		Notebook note = new Notebook("gram", 150, 80, 400);
		note.info();  // 배터리용량: 80w, 모델: gram, 가격: 150만원, 소비전력: 400w
		
	}
	
}
