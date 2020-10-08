package ex05_static;


class MyMath {
	
	// field
	final static double PI = 3.141592;
	
	// method
	static double pow(double n, double times) {
		// n의 times 제곱
		double result = 1;
		for (int i = 0; i < times; i++) {
			result *= n;
		}
		return result;
	}
	
}

public class Ex02_MyMath {

	public static void main(String[] args) {

		System.out.println(MyMath.PI);
		
		// pow() 가 static이 아니면 일어나는 일
		MyMath myMath = new MyMath();
		System.out.println(myMath.pow(2, 5));
		
		// pow() 가 static이면 일어나는 일
		// new 없이 (인스턴스 없이) 호출
		System.out.println(MyMath.pow(2, 6));

	}

}
