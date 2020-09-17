package ex03_loop;

import java.util.Scanner;

public class Ex01_while {

	public static void main(String[] args) {
		
		/*
		 * while문
		 * 1. 조건식의 결과가 True이면 반복되는 제어문
		 * 2. 형식
		 *    while (조건식) {
		 *        반복 실행문;
		 *    }
		 */
		
		// 1. 1 ~ 3 출력하기
		int a = 1;
		while (a <= 3) {
			System.out.println(a);
			a++;
		}
		// 변수 a	조건식 a<=3		조건식 결과		실행문
		// 1		1<=3			true			System.out.println(1);
		// 2		2<=3			true			System.out.println(2);
		// 3		3<=3			true			System.out.println(3);
		// 4		4<=3			false			종료
		
		
		// 2. 3 ~ 1 출력하기
		int b = 3;
		while (b >= 1) {
			System.out.println(b);
			b--;
		}
		
		
		// 3. 'A' ~ 'Z' 출력하기
		// char 타입의 변수는 내부적으로 정수로 처리가 된다.
		// char 타입의 변수도 ++ 연산이 가능하다.
		char ch = 'A';
		while (ch <= 'Z') {
			System.out.println(ch);
			ch++;
		}
		
		
		// 4. 사용자가 0을 입력할때까지 계속 입력 받아서 합계를 구하시오.
		// 사용자 입력 : n
		// 합계 : total
		Scanner sc = new Scanner(System.in);
		int n = 999999;  // 의도적으로 0이 아닌 값 : 최초 while문 진입 가능
		int total = 0;
			
		while (n != 0) {  // 입력이 0이 아니면 더해주겠다.
			System.out.print("더할 값을 입력하세요 >>> ");
			n = sc.nextInt();
			total += n;
		}
		
		System.out.println("합계: " + total);
		
		sc.close();

	}

}
