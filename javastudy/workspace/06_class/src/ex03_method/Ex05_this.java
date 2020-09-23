package ex03_method;

// this : 객체 자신의 참조값

class Computer {
	
	// field
	String model;
	String manufacturer;
	int price;
	
	// method
	// 1. setInfo
	void setInfo(String model, String manufacturer, int price) {
		this.model = model;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	// 2. info
	void info() {
		// System.out.println(this.model);
		System.out.println(model);
		System.out.println(manufacturer);
		System.out.println(price);
	}
	
}

public class Ex05_this {

	public static void main(String[] args) {
		
		Computer com = new Computer();
		com.setInfo("gram", "LG", 180);
		com.info();
		
	}

}