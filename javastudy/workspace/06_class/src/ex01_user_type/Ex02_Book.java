package ex01_user_type;

// 클래스 Book
// 제목, 저자, 가격, 판매량, 베스트셀러 유무(판매량이 1000 이상은 베스트셀러)
class Book {
	
	// 필드는 자동으로 초기화된다.
		
	String title;			// null
	String author;			// null
	int price;				// 0
	int amount;				// 0
	boolean isBestSeller;	// false
	
}

public class Ex02_Book {

	public static void main(String[] args) {
		
		// 객체 생성
		Book javaBook = new Book();
		
		javaBook.title = "멘토씨리즈 자바";
		javaBook.author = "코리아교육그룹";
		javaBook.price = 25000;
		javaBook.amount = 2000;
		javaBook.isBestSeller = javaBook.amount >= 1000;
		
		System.out.println(javaBook.title);
		System.out.println(javaBook.author);
		System.out.println(javaBook.price);
		System.out.println(javaBook.amount);
		System.out.println(javaBook.isBestSeller ? "베스트셀러" : "일반서적");

	}

}
