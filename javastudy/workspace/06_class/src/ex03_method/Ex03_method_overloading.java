package ex03_method;

/*
 * 메소드 오버로딩 (method overloading)
 * 1. 메소드명이 같은 메소드를 여러 개 만들 수 있다.
 * 2. 반드시 매개변수가 달라야 한다.
 * 3. 결과타입은 전혀 상관이 없다.
 */

class Book {
	
	// field
	String title;	// null
	String author;	// null
	int price;		// 0
	
	// method
	
	// 1. 필드 정보 저장 메소드
	void setInfo(String t, String a, int p) {
		title = t;
		author = a;
		price = p;
	}
	// 2. 필드 정보 저장 메소드
	void setInfo(String t, int p) {
		setInfo(t, "미상", p);
	}
	// 3. 필드 정보 저장 메소드
	void setInfo(String t, String a) {
		setInfo(t, a, 0);
	}
	// 4. 필드 정보 출력 메소드
	void info() {
		System.out.println("제목: " + title);
		System.out.println("저자: " + author);
		System.out.println("가격: " + price + "원");
	}
	
}


public class Ex03_method_overloading {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.setInfo("어린왕자", "생떽쥐베리", 15000);
		b1.info();
		
		Book b2 = new Book();
		b2.setInfo("홍길동전", 10000);
		b2.info();
		
		Book b3 = new Book();
		b3.setInfo("좋은생각", "박철수");
		b3.info();

	}

}