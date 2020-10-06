package ex01_upcasting;

// 모든 Coffee를 저장할 수 있는 Coffee 타입을 만든다.

class Coffee {
	// field
	private String beanOrigin;
	// constructor
	public Coffee(String beanOrigin) {
		super();  // Object 클래스
		this.beanOrigin = beanOrigin;
	}
	// method
	public void info() {
		System.out.println("커피원산지: " + beanOrigin);
	}
	public void taste() {
		// Espresso, Latte 에서 호출하려면 내용이 없더라도 메소드는 있어야 한다.
	}
}

class Espresso extends Coffee {
	// field
	private int water;
	// constructor
	public Espresso(String beanOrigin, int water) {
		super(beanOrigin);  // Coffee 클래스
		this.water = water;
	}
	// method
	@Override
	public void info() {
		super.info();  // Coffee 클래스의 info 메소드
		System.out.println("물의 양: " + water);
	}
	@Override
	public void taste() {
		System.out.println("Espresso는 쓰다.");
	}
	
}

class Latte extends Espresso {
	// field
	private int milk;
	// constructor
	public Latte(String beanOrigin, int water, int milk) {
		super(beanOrigin, water);  // Espresso 클래스
		this.milk = milk;
	}
	// method
	@Override
	public void info() {
		super.info();  // Espresso 클래스의 info 메소드
		System.out.println("우유량: " + milk);
	}
	@Override
	public void taste() {
		System.out.println("Latte는 부드럽다.");
	}
}


public class Ex03_Coffee {

	public static void main(String[] args) {
		
		// 모든 Coffee 는 Coffee 클래스의 서브클래스이므로,
		// Coffee 클래스 타입으로 저장할 수 있다.
		Coffee coffee1 = new Espresso("케냐", 30);
		Coffee coffee2 = new Latte("인도네시아", 30, 150);
		
		coffee1.info();
		coffee2.info();
		
		// 1. Coffee 클래스에서 info 메소드를 찾아서 호출 여부를 기다린다.
		// 2. new Espresso()를 통해서 생성된 객체를 확인한 뒤 Espresso 클래스의 info 메소드를 호출하기로 정한다.

		coffee1.taste();
		coffee2.taste();
		
	}

}
