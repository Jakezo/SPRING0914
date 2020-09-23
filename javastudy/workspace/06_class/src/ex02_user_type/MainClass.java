package ex02_user_type;

public class MainClass {

	public static void main(String[] args) {
		
		// Computer 생성
		Computer myCom = new Computer();
		myCom.model = "GRAM";
		myCom.manufacturer = "LG";
		myCom.price = 180;
		
		// Book 생성
		Book myBook = new Book();
		myBook.title = "스프링5";
		myBook.author = "최범균";
		myBook.price = 26500;
		myBook.amount = 5000;
		myBook.isBestSeller = myBook.amount >= 1000;
		
		// Person 생성
		Person p = new Person();
		p.name = "제임스";
		p.age = 25;
		p.gender = '남';
		p.height = 170.5;
		p.isAdult = p.age >= 20;
		p.computer = myCom;
		p.book = myBook;
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.gender);
		System.out.println(p.height);
		System.out.println(p.isAdult);
		
		System.out.println(p.computer.model);
		System.out.println(p.computer.manufacturer);
		System.out.println(p.computer.price);
		
		System.out.println(p.book.title);
		System.out.println(p.book.author);
		System.out.println(p.book.price);
		System.out.println(p.book.amount);
		System.out.println(p.book.isBestSeller);

	}

}
