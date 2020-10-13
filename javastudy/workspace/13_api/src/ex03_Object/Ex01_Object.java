package ex03_Object;

// Object 클래스
// 1. 모든 클래스들의 슈퍼클래스이다.
// 2. Object 타입으로 모든 데이터를 저장할 수 있다.
// 3. 모든 클래스들은 Object 클래스의 모든 메소드를 사용할 수 있다.

class Dog {
	// method
	public void run() {
		System.out.println("개가 달린다.");
	}
}

public class Ex01_Object {

	public static void main(String[] args) {
		
		// 모든 걸 저장할 수 있는 Object 클래스
		Object obj = new Object();
		
		// 1. 변수(기본 자료형) 저장
		obj = 10;
		System.out.println(obj);
		obj = 1.5;
		System.out.println(obj);
		
		// 2. 객체(인스턴스, 참조 자료형) 저장
		obj = new Dog();

		// 개가 달린다.
		// obj 객체는 타입이 Object 이므로 Object 의 메소드만 호출할 수 있다.
		// Dog 클래스의 메소드를 호출하려면 Object 타입 -> Dog 타입으로 변경해야 한다.
		// 다운캐스팅을 해야 한다.
		if (obj instanceof Dog) {
			((Dog) obj).run();
		}
		((Dog) obj).run();
		
		
	}

}