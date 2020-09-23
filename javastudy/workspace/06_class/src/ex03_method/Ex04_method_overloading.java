package ex03_method;

class Nemo {
	
	// field
	int width;	// 너비
	int height;	// 높이
	
	// method
	// 1. setInfo
	void setInfo(int w, int h) {
		width = w;
		height = h;
	}
	// 2. setInfo
	void setInfo(int side) {
		// width = side;
		// height = side;
		setInfo(side, side);
	}
	// 3. getArea
	int getArea() {
		return width * height;
	}
	// 4. info
	void info() {
		System.out.println("너비: " + width + ", 높이: " + height);
	}
	
}


public class Ex04_method_overloading {

	public static void main(String[] args) {
		
		// 사각형 만들기
		
		// 1. 직사각형
		Nemo nemo1 = new Nemo();
		nemo1.setInfo(3, 5);
		System.out.println("넓이: " + nemo1.getArea());  // 넓이: 15
		nemo1.info();  // 너비: 3, 높이: 5
		
		// 2. 정사각형
		Nemo nemo2 = new Nemo();
		nemo2.setInfo(3);
		System.out.println("넓이: " + nemo2.getArea());  // 넓이: 9
		nemo2.info();  // 너비: 3, 높이: 3
		
	}

}
