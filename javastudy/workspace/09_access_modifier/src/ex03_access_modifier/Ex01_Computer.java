package ex03_access_modifier;

class Computer {
	
	// field (private)
	private String model;
	private String manufacturer;
	private int price;

	// method
	
	// setters
	public void setModel(String model) {
		this.model = model;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// getters
	public String getModel() {
		return model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getPrice() {
		return price;
	}
	
}


public class Ex01_Computer {

	public static void main(String[] args) {

		// Computer 클래스 타입의 객체 myCom 생성
		Computer myCom = new Computer();
		
		// Computer 클래스 외부에서는 private 에 접근이 안 된다.
		// myCom.model = "GRAM";
		// myCom.manufacturer = "LG";
		// myCom.price = 180;
		// 위 작업은 Field 수정 작업이므로 setter 를 통해서 해결한다.
		myCom.setModel("GRAM");
		myCom.setManufacturer("LG");
		myCom.setPrice(180);
		
		// Field 를 읽는 것도 안 된다.
		// System.out.println(myCom.model);
		// System.out.println(myCom.manufacturer);
		// System.out.println(myCom.price);
		// 위 작업은 Field 읽기 작업이므로 getter 를 통해서 해결한다.
		System.out.println(myCom.getModel());
		System.out.println(myCom.getManufacturer());
		System.out.println(myCom.getPrice());

	}

}
