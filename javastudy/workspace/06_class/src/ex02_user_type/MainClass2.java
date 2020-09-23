package ex02_user_type;

public class MainClass2 {

	public static void main(String[] args) {
		
		Computer myCom = new Computer();	// Computer 생성
		myCom.save("GRAM", "LG", 180);		// save 메소드 호출
		// myCom.info();						// info 메소드 호출

		Book myBook = new Book();
		myBook.setInfo("어린왕자", "생떽쥐베리", 15000, 10000);
		// myBook.print();
		
		Person p = new Person();
		p.save("에밀리", 30, '여', 165.6, myCom, myBook);
		p.info();
		
	}

}