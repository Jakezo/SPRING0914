package ex03_Object;

class Book {
	// field
	private String title;
	// constructor
	public Book(String title) {
		super();
		this.title = title;
	}
	// method
	public void info() {
		System.out.println("책 제목: " + title);
	}
	
	/*
	 * Object 클래스의 toString() 메소드
	 * 
	 * public String toString() {
	 *     return 클래스이름@메모리주소;
	 * }
	 */
	// Object 클래스의 toString() 메소드를 사용하기 싫으면
	// 다시 만들면 된다. (메소드 오버라이드)
	@Override
	public String toString() {
		return "책 제목: " + title;
	}
	
}

public class Ex03_toString {

	public static void main(String[] args) {
		
		Book book = new Book("이것이 자바다");
		
		// 책 정보 출력하려면
		book.info();
		
		// 책 정보 출력하고 싶어서 이런 코드도 가능한가?
		System.out.println(book);
		System.out.println(book.toString());  // 위와 같은 코드이다.
		
		// Object 클래스의 toString 메소드는 
		
		//    클래스타입         @  메모리주소  를 반환한다.
		
		// getClass().getName()  @  hashCode()값
		

	}

}








