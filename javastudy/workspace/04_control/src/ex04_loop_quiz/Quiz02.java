package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		
		// 문제. 퀴즈 정답 맞추기
		// 질문 : 대한민국의 수도는? >>> 서울, seoul
		// 정답입니다.
		// 질문 : 대한민국의 수도는? >>> 인천
		// 오답입니다.
		
		
		
		Scanner sc = new Scanner(System.in);
		
		String city = null;
		
		do {
			
			if (city != null) {
				System.out.println("오답입니다.");
			}
			
			System.out.print("대한민국의 수도는? >>> ");
			city = sc.next();
			
		} while ( !city.equals("서울") && !city.equalsIgnoreCase("seoul") );
		
		System.out.println("정답입니다.");
		
		sc.close();

	}

}
