package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		
		// 문제. 입력 받은 구구단만 출력하시오.
		// 2~9 사이 정수를 입력 받아 해당 구구단만 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("보고 싶은 구구단을 입력하세요 >>> ");
		int dan = sc.nextInt();
		
		for (int num = 1; num <= 9; num++) {
			System.out.println(dan + "x" + num + "=" + (dan * num));
		}
		
		sc.close();

	}

}
