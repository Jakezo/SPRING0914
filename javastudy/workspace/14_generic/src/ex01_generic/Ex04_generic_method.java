package ex01_generic;

import java.util.ArrayList;

public class Ex04_generic_method {

	// <N extends Number>
	// Integer, Double 의 슈퍼클래스로 Number 클래스가 있다.
	// 전달되는 타입은 Number 타입이어야 한다.
	
	public static <N extends Number> double getTotal(N[] a) {
		double total = 0;
		for (int i = 0; i < a.length; i++) {
			total += a[i].doubleValue();  // N타입은 Number의 서브클래스 타입이므로 Number클래스의 메소드를 사용할 수 있다.
		}
		return total;
	}
	
	public static void main(String[] args) {
			
		Integer[] a = {1, 2, 3, 4, 5};
		Double[] b = {1.1, 2.2, 3.3};
		String[] c = {"나", "너"};
		
		double r1 = getTotal(a);
		double r2 = getTotal(b);
		// getTotal(c);  // 오류 발생
		
		System.out.println(r1);
		System.out.println(r2);

	}

}