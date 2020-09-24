package ex01_oop;

// 좌표
class Coord {
	
	// field
	int x;
	int y;
	
	// constructor
	Coord(int x, int y) {  // new Coord(3, 5);
		this.x = x;
		this.y = y;
	}
	Coord(Coord coord) {   // new Coord(coord1);
		// 매개변수가 2개인 다른 생성자를 호출
		this(coord.x, coord.y);
	}
	
	// method
	void info() {
		System.out.print("좌표 [" + x + ", " + y + "]");
	}
	
}

// 원
class Circle {
	
	// field
	double r;
	Coord center;
	
	// constructor
	Circle(double r) {  // new Circle(1.5);
		// 매개변수가 3개인 다른 생성자를 호출
		this(1, 1, r);
	}
	Circle(int x, int y, double r) {  // new Circle(33, 55, 1.5);
		// center.x = x;  NullPointerException 발생
		// center.y = y;  center 가 null 이라는 의미이다.
		// center 의 생성이 필요하다. 언제나 객체 생성은 new 로 처리한다.
		this.r = r;
		center = new Coord(x, y);
	}
	
	// method
	double getArea() {
		return Math.PI * Math.pow(r, 2);
	}
	void info() {
		center.info();
		System.out.println(", 반지름: " + r + ", 크기: " + getArea());
	}
	
}

public class Ex02_Circle {

	public static void main(String[] args) {
		
		Coord coord1 = new Coord(3, 5);
		Coord coord2 = new Coord(coord1);
		
		coord1.info();  // 좌표 [3, 5]
		coord2.info();  // 좌표 [3, 5]
		
		Circle circle1 = new Circle(1.5);
		Circle circle2 = new Circle(33, 55, 1.5);
		
		circle1.info();  // 좌표 [1, 1], 반지름 1.5, 크기 7.xxx
		circle2.info();  // 좌표 [33, 55], 반지름 1.5, 크기 7.xxx

	}

}
