package ex02_quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		
		// 문제. 두 개의 실수를 입력 받아서,
		// 두 실수의 값을 교환하시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 실수 입력 >>> ");
		double a = sc.nextDouble();
		System.out.print("두 번째 실수 입력 >>> ");
		double b = sc.nextDouble();
		
		double temp = a;
		a = b;
		b = temp;
		
		System.out.println(a + ", " + b);
		
		sc.close();

	}

}
