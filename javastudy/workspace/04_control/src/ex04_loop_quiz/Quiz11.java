package ex04_loop_quiz;

public class Quiz11 {

	public static void main(String[] args) {
		
		// 문제. 369게임
		// 1 ~ 99 사이 369게임 결과 출력하기
		// 1	2	짝		4	5	짝		7	8	짝		10
		// 11	12	짝		14	15	짝		17	18	짝		20
		// 21	22	짝		24	25	짝		27	28	짝		짝
		// 짝	짝	짝짝	짝	짝	짝짝	짝	짝	짝짝	40
		// ...
		
		// 0은 false를 의미하고, 1은 true를 의미한다.
		
		boolean condition1 = false;  // 일의 자리가 3,6,9이면 true
		boolean condition2 = false;  // 십의 자리가 3,6,9이면 true
		
		// 1 ~ 99
		for (int n = 1; n <= 99; n++) {
			
			// 일의 자리, 십의 자리 분리
			int units = n % 10;
			int tens = n / 10;
			
			// 369 검사
			condition1 = units == 3 || units == 6 || units == 9;
			condition2 = tens == 3 || tens == 6 || tens == 9;
			// condition1 = units % 3 == 0 && units != 0;
			// condition2 = tens % 3 == 0 && tens != 0;
					
			// 출력
			if (condition1 && condition2) {  // 둘 다 true이면
				System.out.print("짝짝\t");
			} else if (condition1 || condition2) {  // 둘 중 하나만 true이면
				System.out.print("짝\t");
			} else {  // 둘 다 false이면
				System.out.print(n + "\t");
			}
			
			// 줄 바꿈의 시점
			// n = 10, 20, 30, 40, ... 90
			if (n % 10 == 0) {  // n이 10의 배수이면
				System.out.println();  // 줄 바꿈
			}
					
		}

	}

}
