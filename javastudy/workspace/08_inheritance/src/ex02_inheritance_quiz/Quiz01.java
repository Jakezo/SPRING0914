package ex02_inheritance_quiz;

// 슈퍼클래스
class Protector {
	
	// field
	String name;
	
	// constructor
	Protector() {
		name = "없음";
	}
	Protector(String name) {
		this.name = name;
	}
	
	// method
	void info() {
		System.out.println("(주인: " + name + ")");
	}
	
}

// 서브클래스
class Cat extends Protector {
	
	// field
	String catName;
	
	// constructor
	Cat(String catName, String name) {
		super(name);
		this.catName = catName;
	}
	Cat(String catName) {
		super();  // Protector() { ... } 호출
		this.catName = catName;
	}
	
	// method
	@Override
	void info() {
		System.out.print("이름: " + catName);
		super.info();
	}
	
}

public class Quiz01 {

	public static void main(String[] args) {
		
		// 서브클래스
		Cat cat1 = new Cat("야옹이", "제임스");
		cat1.info();  // 이름: 야옹이 (주인: 제임스)
		
		Cat cat2 = new Cat("냥냥이");
		cat2.info();  // 이름: 냥냥이 (주인: 없음)
		
	}

}