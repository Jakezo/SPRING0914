package ex02_quiz;

import java.util.Scanner;

public class Quiz05 {

	public static void main(String[] args) {
		
		// 문제. 성별을 의미하는 숫자(정수) 1 ~ 4를 입력 받아서,
		// "남자", "여자" 를 구분하여 출력하시오.
		// 1, 3 이 "남자",   2, 4 가 "여자"
		
		// Hint. 홀수이면 "남자", 짝수이면 "여자"
		// 홀수는 2로 나눈 나머지 값이 1인 수
		// 짝수는 2로 나눈 나머지 값이 0인 수
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성별을 의미하는 숫자(1~4)를 입력하세요 >>> ");
		int iGender = sc.nextInt();
		
		String gender = iGender % 2 == 0 ? "여자" : "남자";
		// String gender = iGender % 2 == 1 ? "남자" : "여자";
		
		System.out.println("성별은 " + gender + "입니다.");
		
		sc.close();
		
	}

}
