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
}

public class Ex03_toString {

	public static void main(String[] args) {
		
		Book book = new Book("이것이 자바다");
		
		// 책 정보 출력하려면
		book.info();
		
		// 책 정보 출력하고 싶어서 이런 코드도 가능한가?
		System.out.println(book);
		System.out.println(book.toString());
		
		// Object 클래스의 toString 메소드는 
		// 클래스타입@메모리주소  를 반환한다.

	}

}
