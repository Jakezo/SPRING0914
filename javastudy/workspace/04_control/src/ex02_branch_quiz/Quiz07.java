package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {
		
		// 문제. 가위바위보
		// 실행
		// 가위바위보 >>> 가위
		// 당신은 가위, 컴퓨터는 보, 이겼습니다.
		// Hint : 가위는 0, 바위는 1, 보는 2로 처리한다.
		
		// 컴퓨터 : player1
		String player1 = null;
		int gbb1 = (int)(Math.random() * 3);
		switch (gbb1) {
		case 0: player1 = "가위"; break;
		case 1: player1 = "바위"; break;
		case 2: player1 = "보";
		}
		
		// 사용자 : player2
		Scanner sc = new Scanner(System.in);
		System.out.print("가위바위보 >>> ");
		String player2 = sc.next();
		int gbb2;
		switch (player2) {
		case "가위": gbb2 = 0; break;
		case "바위": gbb2 = 1; break;
		default: gbb2 = 2;
		}
		
		// 비교
		String result = null;
		switch (gbb2 - gbb1) {
		case 0: result = "비겼습니다";
				break;
		case -2:
		case 1: result = "이겼습니다";
				break;
		default: result = "졌습니다";
		}
		
		System.out.println("컴퓨터는 " + player1 + ", 당신은 " + player2 + ", " + result);
		
		sc.close();
		
	}

}
