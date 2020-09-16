package ex02_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {
		
		// 문제. 온도 변환기
		// 섭씨 온도를 입력하면 해당 화씨 온도를 출력하시오.
		// 화씨 = 섭씨 * 1.8 + 32

		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 온도를 입력하세요 >>> ");
		double cel = sc.nextDouble();
		
		double fah = cel * 1.8 + 32;
		
		System.out.println("입력된 " + cel + "도는 화씨로 " + fah + "도입니다.");
		
		sc.close();
		
	}

}
