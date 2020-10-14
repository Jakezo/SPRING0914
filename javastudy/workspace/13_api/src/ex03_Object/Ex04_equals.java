package ex03_Object;

class Car {
	// field
	private String model;
	private int year;
	// constructor
	public Car(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}
	// method
	/*
	 * Object 클래스의 equals() 메소드
	 * 
	 * public boolean equals(Object obj) {
	 *     return this == obj;
	 * }
	 */
	@Override
	public boolean equals(Object obj) {
		// 모델명과 년식이 같으면 true 리턴
		if (this == obj) {  // 나랑 같은 객체이다.
			return true;
		}
		if (obj instanceof Car) {
			Car car = (Car) obj;
			// 내 모델: model				내 연식: year
			// 비교할 모델: car.model       비교할 연식: car.year
			if (model.equals(car.model) && year == car.year) {  // model은 String타입이므로 String클래스의 equals() 호출
				return true;
			} else {
				return false;
			}
		}
		return false;  // 전달된 obj가 Car 가 아님
	}
	
	
	
	
	
	
}

public class Ex04_equals {

	public static void main(String[] args) {
		
		// 동일한 자동차가 2대 있다.
		
		Car car1 = new Car("bmw520d", 2020);
		Car car2 = new Car("bmw520d", 2020);
		
		// 동등비교(==) : 다른 객체이다. (저장된 메모리 주소가 다르다.)
		if (car1 == car2) {
			System.out.println("같은 자동차이다.");
		} else {
			System.out.println("다른 자동차이다.");
		}
		
		// Object 클래스의 equals 메소드 : 동등비교(==)로 동작한다.
		/*
		if (car1.equals(car2)) {
			System.out.println("같은 자동차이다.");
		} else {
			System.out.println("다른 자동차이다.");
		}
		*/
		
		// 같은 모델인지 다른 모델인지 판단하려면
		// Object 클래스의 equals 메소드로 판단할 수 없다.
		
		// Object 클래스의 equals 메소드를 사용하기 싫으면
		// 다시 만들어서 사용한다. (메소드 오버라이드)
		
		if (car1.equals(car2)) {
			System.out.println("같은 모델이다.");
		} else {
			System.out.println("다른 모델이다.");
		}
		
	}

}

