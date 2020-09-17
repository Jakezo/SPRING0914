package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		
		// 문제. 권한을 정수(1~3)로 입력 받아서 구분해서 출력하시오.
		// 권한1 : "실행, 쓰기, 읽기"
		// 권한2 : "쓰기, 읽기"
		// 권한3 : "읽기"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("권한을 입력하세요 >>> ");
		int power = sc.nextInt();
		
		switch (power) {
		case 1: System.out.print("실행, ");
		case 2: System.out.print("쓰기, ");
		case 3: System.out.println("읽기");
		}
		
		sc.close();

	}

}
