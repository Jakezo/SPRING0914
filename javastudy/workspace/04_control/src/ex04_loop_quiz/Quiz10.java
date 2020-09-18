package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		
		// 문제. UpDown 게임
		// 1 ~ 10000 사이의 난수를 발생시키고,
		// 해당 난수를 맞히는 게임
		// 입력마다 "Up!", "Down!"
		// 
		// 난수 : 4500
		// 입력 >>> 5000
		// Down!
		// 입력 >>> 2500
		// Up!
		// ...
		// 입력 >>> 4500
		// 정답. 총 5번만에 성공.
		
		Scanner sc = new Scanner(System.in);
		
		int target = (int)(Math.random() * 10000) + 1;  // 발생된 난수
		int guess = 0;  // 사용자 입력 값
		int times = 0;  // 입력 횟수
		
		do {
			// 사용자 입력
			System.out.print("입력 >>> ");
			guess = sc.nextInt();
			// 입력 횟수 증가
			times++;
			// 잘못된 입력 체크
			if (guess < 1 || guess > 10000) {
				System.out.println("1~10000 사이만 유효합니다.");
				continue;
			}
			// 비교
			if (guess == target) {
				System.out.println("정답. 총 " + times + "번만에 성공.");
				break;  // 생략 가능
			} else if (guess > target) {
				System.out.println("Down!");
			} else {  // guess < target
				System.out.println("Up!");
			}
		} while (guess != target);
		
		sc.close();

	}

}
