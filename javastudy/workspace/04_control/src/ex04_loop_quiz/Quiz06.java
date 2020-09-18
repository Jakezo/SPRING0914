package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
		
		// 문제. 평점(1~5)을 3번 입력 받는다.
		// 1~5 사이의 입력이 아니면 다시 입력 받는다.
		// 실행)
		// 1번째 평점 입력 >>> 0
		// 1번째 평점 입력 >>> 10
		// 1번째 평점 입력 >>> 3
		// 2번째 평점 입력 >>> 4
		// 3번째 평점 입력 >>> 5
		
		Scanner sc = new Scanner(System.in);
		
		// 3번
		for (int a = 0; a < 3; a++) {
			
			// 입력
			int grade;
			do {
				System.out.print((a + 1) + "번째 평점 입력 >>> ");
				grade = sc.nextInt();
			} while (grade < 1 || grade > 5);
			
		}
		
		sc.close();

	}

}