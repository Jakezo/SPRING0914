package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz12 {

	public static void main(String[] args) {
		
		// 문제. 10000원 모두 쓰기
		// 사용할 금액을 입력 받아서 10000원에서 공제하기
		
		// 현재 10000원 있습니다.
		// 결제금액 >>> 5000
		// 현재 5000원 있습니다.
		// 결제금액 >>> 10000
		// 5000원이 부족합니다.
		// 현재 5000원 있습니다.
		// 결제금액 >>> 5000
		// 현재 0원 있습니다.

		Scanner sc = new Scanner(System.in);
		
		int money = 10000;
		
		while (true) {
			
			System.out.println("현재 " + money + "원 있습니다.");
			
			if (money == 0) {
				break;
			}
			
			System.out.print("결제금액 >>> ");
			int spend = sc.nextInt();
			
			if (spend <= 0) {
				System.out.println("0 이하의 돈은 사용할 수 없습니다.");
				continue;
			} else if (spend > money) {
				System.out.println((spend - money) + "원 부족합니다.");
				continue;
			} else {
				money -= spend;
			}
			
		}
		
		sc.close();
		
	}

}
