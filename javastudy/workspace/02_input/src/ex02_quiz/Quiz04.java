package ex02_quiz;

import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		
		// 문제. 매출액(정수)과 등급("VIP", "일반")을 입력 받아서,
		// "VIP" 등급은 매출액의 20%를 할인하고,
		// "일반" 등급은 매출액의 5%를 할인하여 실제 매출액을 출력하시오.

		Scanner sc = new Scanner(System.in);
		
		System.out.print("매출액을 입력하세요 >>> ");
		int sales = sc.nextInt();  // 10000\n 입력하면 sales는 10000저장, \n은 스트림에 남아 있다.
		
		sc.nextLine();  // 스트림에 남아 있는 \n 입력 받아서 그냥 버린다.
		
		System.out.print("등급을 입력하세요 >>> ");
		String grade = sc.nextLine();
		
		// equalsIgnoreCase()는 대소문자를 구분하지 않는다.
		double earn = grade.equalsIgnoreCase("VIP") ? sales * 0.8 : sales * 0.95;
		
		System.out.println("실제 매출액: " + (int)earn + "원");
		
		sc.close();
		
	}

}