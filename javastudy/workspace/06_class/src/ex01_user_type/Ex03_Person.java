package ex01_user_type;

// 클래스 Person
// 이름, 나이, 성별, 키, 성인 유무(나이가 20 이상이면 성인)
class Person {
	
	String name;		// null
	int age;			// 0
	char gender;		// 코드 값 0인 문자 : 널 문자('\0')
	double height;		// 0.0
	boolean isAdult;	// false
	
}

public class Ex03_Person {

	public static void main(String[] args) {
		
		Person p = new Person();
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.gender);
		System.out.println(p.height);
		System.out.println(p.isAdult);

	}

}