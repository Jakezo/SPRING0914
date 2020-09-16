package ex02_quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
		
		// 문제. 주민등록번호를 하이픈(-) 없이 입력 받아서,
		// "남자", "여자"를 구분하여 출력하시오.
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 문자열
		System.out.print("주민등록번호를 입력하세요 >>> ");
		String strSn = sc.next();
		char genderNum = strSn.charAt(6);  // 7번째 글자를 의미한다.
		// genderNum	코드값(정수)
		// '1'			49
		// '2'			50
		// '3'			51
		// '4'			52
		// 대표 코드값
		// '0' -> 48
		// 'A' -> 65
		// 'a' -> 97
		
		// String gender = genderNum % 2 == 0 ? "여자" : "남자";  genderNum은 코드값으로 계산된다.
		String gender = genderNum == '2' || genderNum == '4'  ? "여자" : "남자";
		System.out.println("성별은 " + gender + "입니다.");
		
		
		// 2. 정수
		System.out.print("주민등록번호를 입력하세요 >>> ");
		long sn = sc.nextLong();
		long genderNum2 = sn / 1000000 % 10;
		String gender2 = genderNum2 % 2 == 0 ? "여자" : "남자";
		System.out.println("성별은 " + gender2 + "입니다.");
		
		sc.close();
		
	}

}
