package ex03_access_modifier;

class Book {
	
	// field
	private String title;
	private String author;
	private int price;
	private int amount;
	private boolean isBestSeller;
	
	// method
	// setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
		setBestSeller(this.amount >= 1000);  // setAmount 호출하면 setBestSeller 함께 호출된다.
	}
	
	
	// Book 클래스 내부에서만 호출할 수 있도록 private 처리했다.
	private void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}
	
	
	
	// getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	public boolean isBestSeller() {
		return isBestSeller;
	}
	
}


public class Ex02_Book {

	public static void main(String[] args) {

		Book javaBook = new Book();
		
		// 아래 작업은 setter 로 변경해야 한다.
		// javaBook.title = "멘토씨리즈 자바";
		// javaBook.author = "코리아교육그룹";
		// javaBook.price = 25000;
		// javaBook.amount = 2000;
		// javaBook.isBestSeller = javaBook.amount >= 1000;
		javaBook.setTitle("멘토씨리즈 자바");
		javaBook.setAuthor("코리아교육그룹");
		javaBook.setPrice(25000);
		javaBook.setAmount(2000);
		// javaBook.setBestSeller(false);  // 막을 방법? private
		
		// 아래 작업은 getter 로 변경해야 한다.
		// System.out.println(javaBook.title);
		// System.out.println(javaBook.author);
		// System.out.println(javaBook.price);
		// System.out.println(javaBook.amount);
		// System.out.println(javaBook.isBestSeller ? "베스트셀러" : "일반서적");
		
		System.out.println(javaBook.getTitle());
		System.out.println(javaBook.getAuthor());
		System.out.println(javaBook.getPrice());
		System.out.println(javaBook.getAmount());
		System.out.println(javaBook.isBestSeller() ? "베스트셀러" : "일반서적");

	}

}
