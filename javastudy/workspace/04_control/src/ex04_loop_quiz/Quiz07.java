package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {
		
		// 문제. 퀴즈 맞추기
		// 대한민국의 수도 맞추기
		// 맞히면 "정답입니다", 틀리면 "오답입니다"
		// 몇 번만에 맞혔는지 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int times = 0;
		while (true) {
			System.out.print("대한민국의 수도는? >>> ");
			String city = sc.next();
			times++;
			if (city.equals("서울") || city.equalsIgnoreCase("seoul")) {
				System.out.println("정답입니다");
				break;
			} else {
				System.out.println("오답입니다");
			}
		}
		System.out.println(times + "번 만에 정답입니다.");
		
		sc.close();

	}

}