package ex02_inheritance_quiz;

// 슈퍼클래스
class Person {
	
	// field
	String name;
	int age;
	
	// constructor
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// method
	void info() {
		System.out.print("이름: " + name + ", 나이: " + age + "살, ");
	}
	
}

// 서브클래스
class Student extends Person {
	
	// field
	String school;
	
	// constructor
	Student(String name, int age, String school) {
		super(name, age);  // Person 클래스의 constructor 호출
		this.school = school;
	}
	
	// method
	@Override
	void info() {
		super.info();  // Person 클래스의 info 메소드 호출 (이름, 나이 출력)
		System.out.println("학교: " + school);
	}
	
}

// 서브클래스
class Worker extends Person {
	
	// field
	String job;
	
	// constructor
	Worker(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}
	
	// method
	@Override
	void info() {
		super.info();
		System.out.println("직업: " + job);
	}
	
}

public class Quiz02 {

	public static void main(String[] args) {
		
		// 학생과 직장인
		Student student = new Student("에밀리", 21, "서강대");  // 이름, 나이, 학교
		Worker worker = new Worker("아만다", 25, "변호사");  // 이름, 나이, 직업
		
		student.info();  // 이름: 에밀리, 나이: 21살, 학교: 서강대
		worker.info();  // 이름: 아만다, 나이: 25살, 직업: 변호사

	}

}
