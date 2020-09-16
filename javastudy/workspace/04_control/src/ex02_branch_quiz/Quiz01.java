package ex02_branch_quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		
		// 문제. 국어와 영어 점수를 입력 받아서,
		// "합격", "불합격"을 구분하여 출력하시오.
		// 국어와 영어 점수가 모두 80점 이상이고, 평균이 85점 이상이면 "합격"
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하세요 >>> ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 >>> ");
		int eng = sc.nextInt();
		
		if ( kor >= 80 && eng >= 80 && (kor + eng) / 2.0 >= 85 ) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		
		sc.close();

	}

}
