package ex05_static;

/*
 * 클래스 필드/클래스 메소드
 * 1. 클래스에 저장된 1개의 필드 값,  모든 인스턴스가 사용할 수 있다.
 * 2. 클래스에 저장된 1개의 메소드,  모든 인스턴스가 사용할 수 있다.
 * 3. 중요
 *    1) 인스턴스가 사용하기 위해서 static 처리하는 것은 아니다.
 *    2) 인스턴스 생성 전에(new 이전, new 가 없어도) 사용하는 것이 주 목적이다.
 *    3) 접근 방법
 *       (1) 클래스로 접근 : 추천
 *           예) Math.PI, Math.random(), Math.pow(), Integer.parseInt(). System.out, System.in 등
 *       (2) 인스턴스로 접근 : 비추천
 */

class Korean {
	// field
	String name;  // 인스턴스 필드
	static String country = "한국";  // 클래스 필드
	// constructor
	Korean(String name) {
		this.name = name;
	}
	// method
	void info() {
		System.out.println("이름: " + name + ", 국가: " + country);
	}
}

public class Ex01_Korean {

	public static void main(String[] args) {
		
		// 객체 = 인스턴스
		
		// 3개 인스턴스 korean1, korean2, korean3 가 있으므로
		// 3개의 name과 3개의 country가 생성되었다.
		
		// 모든 Korean 클래스로 생성한 인스턴스는 "한국"이라고 보면,
		// country는 Korean 클래스에서 단 1개만 저장해 두면 좋다.
		
		// 필드 구분
		// 1. 인스턴스 필드 : 인스턴스마다 다른 값을 가지는 필드 (name)
		// 2. 클래스 필드 : 모든 인스턴스가 공유하는 하나의 값을 가지는 필드 (country)
		//    클래스 필드는 static 키워드를 필드 선언에 추가하면 된다.
		
		Korean korean1 = new Korean("김철수");
		Korean korean2 = new Korean("박영희");
		Korean korean3 = new Korean("송도순");
		
		korean1.info();
		korean2.info();
		korean3.info();

	}

}
