package ex02_quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {
		
		// 문제. 체질량지수(bmi)를 구하고 건강상태 출력하기
		// 체질량지수 = 몸무게(kg) / 키(m)의 제곱
		// 건강상태 = 체질량지수 25이상이면 "과체중", 24~20 "정상", 20미만이면 "저체중"
		// 몸무게는 kg단위로 입력 받고, 키는 cm단위로 입력 받는다.

		Scanner sc = new Scanner(System.in);
		
		System.out.print("몸무게를 입력하세요 >>> ");
		double weight = sc.nextDouble();
		System.out.print("키를 입력하세요 >>> ");
		double height = sc.nextDouble();  // cm
		
		// height : 185.5cm -> 1.855m
		height /= 100;
		
		// bmi
		double bmi = weight / (height * height);
		
		// 건강상태
		String health = bmi >= 25 ? "과체중" : bmi >= 20 ? "정상" : "저체중";
		
		// 출력
		System.out.println("체지량지수: " + bmi + "(" + health + ")");
		
		sc.close();
		
	}

}