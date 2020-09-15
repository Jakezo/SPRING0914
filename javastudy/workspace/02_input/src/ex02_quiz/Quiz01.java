package ex02_quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		// 문제. 국어, 영어 점수를 사용자로부터 입력 받아서,
		// 평균을 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 >>> ");
		int kor = sc.nextInt();
		System.out.print("영어 >>> ");
		int eng = sc.nextInt();
		
		double ave = (kor + eng) / 2;
		System.out.println("평균 : " + ave + "점");
		
		sc.close();

	}

}
