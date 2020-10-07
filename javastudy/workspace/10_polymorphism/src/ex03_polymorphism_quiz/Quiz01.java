package ex03_polymorphism_quiz;

class Elec {
	// field
	private String model;
	private int price;
	// constructor
	public Elec(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	// method
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

class TV extends Elec {
	// constructor
	public TV(String model, int price) {
		super(model, price);
	}
}

class Radio extends Elec {
	// constructor
	public Radio(String model, int price) {
		super(model, price);
	}
}

class Customer {
	// field
	private int money;
	private double bonusPoint;
	private Elec[] cart;
	private int idx;
	// constructor
	public Customer(int money) {
		super();
		this.money = money;
		cart = new Elec[5];
	}
	// method
	public void buy(Elec product) {
		
		// cart 에 product 추가 + product 금액만큼 money 사용 + bonusPoint 추가
		
		// product의 price : product.getPrice()
		// customer의 money : money
		if (money < product.getPrice()) {
			System.out.println("돈이 " + (product.getPrice() - money) + "만원 부족합니다.");
			return;  // buy 메소드의 종료
		}
		
		cart[idx++] = product;
		money -= product.getPrice();
		bonusPoint += (product.getPrice() * 0.05);
		
	}
	public void buyList() {
		
		if (idx == 0) {
			System.out.println("구매한 제품이 없습니다.");
			return;
		}
		
		int total = 0;
		for (Elec product : cart) {
			if (product != null) {
				System.out.println(product.getModel() + "\t" + product.getPrice() + "만원");
				total += product.getPrice();
			}
		}
		System.out.println("==========================");
		System.out.println("총 구매금액: " + total + "만원");
		System.out.println("보너스포인트: " + bonusPoint + "만원");
		System.out.println("남은돈: " + money);
		
	}
	
}

public class Quiz01 {

	public static void main(String[] args) {
		
		Customer customer = new Customer(1000);
		customer.buy( new TV("LGTV", 200) );
		customer.buy( new Radio("삼성Radio", 10) );
		customer.buyList();

	}

}
