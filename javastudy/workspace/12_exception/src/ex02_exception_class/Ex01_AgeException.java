package ex02_exception_class;

// 이미 만들어진 예외클래스 : Exception 상속 받는다.
// 개발자가 만드는 예외클래스 : Exception 상속 받는다.

// Exception 클래스의 생성자 정보
/*
class Exception {
	// constructor
	public Exception() {
		super();
	}
	public Exception(String message) {
		super(message);
	}
}
*/

class Person {
	
	// field
	private String name;
	private int age;

	// constructor
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	// 매개변수 int age로 전달되는 값에 따라서,
	// 예외가 발생할 수 있는 메소드
	public void setAge(int age) {
		this.age = age;
	}
	
}

	/*
	 * 메소드가 예외를 처리하는 방법
	 * 1. 직접 try - catch 문을 작성한다. (지금 고려할 대상이 아님)
	 * 2. 메소드를 호출하는 곳으로 예외를 던진다.
	 */

	////////////////////////////////////////////
	// 1. 직접 try - catch 문을 작성한다.
	/*
	void a() {
		try {
			
		} catch (Exception e) {	}
	}
	void b() {
		try {
			
		} catch (Exception e) {	}
	}

	a();
	b();
	*/
	////////////////////////////////////////////


	////////////////////////////////////////////
	// 2. 메소드를 호출하는 곳으로 예외를 던진다.
	/*
	void a() throws ArithmeticException {
		
	}
	void b() throws NumberFormatException {
		
	}
	
	try {
		a();
		b();
	} catch (Exception e) {
		e.printStackTrace();
	}
	*/
	////////////////////////////////////////////

public class Ex01_AgeException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
