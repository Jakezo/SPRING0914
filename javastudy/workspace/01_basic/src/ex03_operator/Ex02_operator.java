package ex03_operator;

public class Ex02_operator {

	public static void main(String[] args) {

		/*
		 * 4. 관계 연산자
		 *    1) >  : 초과, 크다
		 *    2) >= : 이상, 크거나 같다
		 *    3) <  : 미만, 작다
		 *    4) <= : 이하, 작거나 같다
		 *    5) != : 같지 않다
		 *    6) == : 같다 (primitive type)
		 *       equals : 같다 (reference type)
		 *    7) 결과 : true 또는 false
		 *    
		 * 5. 논리 연산자   
		 *    1) && : 모든 조건식의 결과가 true이면 true, 아니면 false  (and)
		 *    2) || : 조건식의 결과가 하나라도 true이면 true, 아니면 false  (or)
		 *    3) !  : 조건식의 결과를 반대로 변경  (not)
		 *    4) short circuit evaluation 을 지원한다.
		 *       (1) && : 조건식의 결과가 false가 나타나면 더 이상 진행하지 않는다. 어차피 결과는 false 이므로.
		 *       (2) || : 조건식의 결과가 true가 나타나면 더 이상 진행하지 않는다. 어차피 결과는 true 이므로.
		 *    
		 * 6. 조건 연산자
		 *    1) 조건식의 결과가 true일 때와 false일 때 모두 한 번에 처리하는 연산자이다.
		 *    2) 조건식 ? true일 때 실행문 : false일 때 실행문
		 *    3) 항이 3개가 필요하기 때문에 삼항 연산자라고도 한다.
		 *    4) 조건문인 if - else문의 대용으로 널리 사용된다.
		 *    
		 */
		
		int a = 10;
		int b = 11;
		
		System.out.println(a > b);   // false
		System.out.println(a >= b);  // false
		System.out.println(a < b);   // true
		System.out.println(a <= b);  // true
		System.out.println(a == b);  // false
		System.out.println(a != b);  // true
		
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		System.out.println(str1 == str2);  // false (두 Hello가 저장된 위치를 비교)
		System.out.println(str1.equals(str2));  // true (두 Hello의 내용을 비교)
		
		
		int c = 10;
		int d = 11;
		
		boolean r1 = c > d && c == 10;  // false
		boolean r2 = c > d || c == 10;  // true
		boolean r3 = !r1;  // true
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		String str3 = "Hello";
		String str4 = "Hello";
		boolean r4 = !str3.equals(str4);  // str3과 str4의 내용이 다른가? false
		System.out.println(r4);
		
		
		// Short Circuit Evaluation
		int x = 10;
		int y = 10;
		boolean r5 = x > 10 && y++ > 10;  // false
		
		System.out.println(r5);
		System.out.println(y);  // 10 : x > 10 의 결과가 false 이고, && 연산이므로 최종 결과가 false 가 된다.
		                        // 최종 결과가 정해지고 나면 더 이상 조건식은 처리하지 않는다.
		
		int score = 50;  // 80점 이상은 "합격", 80점 미만은 "불합격"
		String pass = score >= 80 ? "합격" : "불합격";
		System.out.println(pass);
		
		
		// 문제1. 국어점수와 영어점수가 모두 80점 이상이고, 평균이 85점 이상이면 true 아니면 false 를 출력하시오.
		int kor = 80;
		int eng = 90;
		boolean result1 = kor >= 80 && eng >= 80 && (kor + eng) / 2 >= 85;  // 평균 구하기를 안 할 수도 있기 때문에 효율적
		boolean result2 = (kor + eng) / 2 >= 85 && kor >= 80 && eng >= 80;  // 평균 구하기를 무조건 진행하기 때문에 비효율적
		System.out.println(result1);
		System.out.println(result2);
		
		// 문제2. 나이가 20살 이상이면 요금 5000원, 20살 미만이면 요금 2500원을 출력하시오.
		int age = 15;
		int fee = age >= 20 ? 5000 : 2500;
		System.out.println("요금은 " + fee + "원입니다.");
		
		// 문제3. 아이디가 "admin"이면 "관리자", "admin"이 아니면 "일반유저"를 출력하시오.
		String id = "conan";
		System.out.println(id.equals("admin") ? "관리자" : "일반유저");
		
		
		// 문제4. 2자리 정수(10 ~ 99)중 하나를 선언하고,
		// 그 수가 '카프리카수'인지 판단해서 맞으면 "맞다" 아니면 "아니다"를 출력하시오.
		// 45, 55, 99 는 '카프리카수'이다.
		// 45 -> 45 * 45 -> 2025 -> 20 25 -> 20 + 25 -> 45
		int n = 98;
		int square = n * n;  // 2025
		int front = square / 100;  // 20
		int end = square % 100;  // 25
		boolean isKaprekar = (front + end) == n;
		System.out.println(n + (isKaprekar ? "는 카프리카수이다." : "는 카프리카수가 아니다."));
		
	}

}