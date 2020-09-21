package ex01_array;

public class Ex01_array {

	public static void main(String[] args) {
		
		/*
		 * 배열 (array)
		 * 
		 * 1. 변수가 여러 개 필요할 때 배열을 대신 사용할 수 있다.
		 * 2. 선언 방법
		 *    1) int[] a = new int[5];  // int 타입 5개 변수 생성, 배열 a 생성
		 *    2) int a[] = new int[5];  // 추천하지 않음
		 *    3) int[] a;
		 *       a = new int[5];
		 * 3. 초기화 방법
		 *    1) int[] a = {10, 20, 30, 40, 50};
		 *    2) int[] a = new int[]{10, 20, 30, 40, 50};  // 추천하지 않음
		 *    3) int[] a;  // 이미 초기화는 물 건너 갔음.
		 *       a = {10, 20, 30, 40, 50};  // 당연히 안 되는 코드임.
		 * 4. int[] a = new int[5];
		 *    a[0] == 0
		 *    a[1] == 0
		 *    a[2] == 0
		 *    a[3] == 0
		 *    a[4] == 0
		 *    각 변수들은 모두 자동으로 '0'으로 초기화가 된다. (일반 변수와 다른 특징)
		 * 5. 인덱스
		 *    1) 배열의 각 변수(=요소, element)를 구분하는 번호이다.
		 *    2) 인덱스는 0부터 시작한다.
		 *    3) 사용할 수 없는 인덱스를 사용하면 ArrayIndexOutOfBoundsException 예외가 발생한다.
		 * 6. 길이
		 *    1) 배열의 전체 요소 갯수이다.
		 *    2) length 필드 값을 사용한다.
		 */
		// 선언
		int[] a = new int[5];  // 모든 요소가 자동으로 0으로 초기화된다.
		
		// 확인
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		
		// 인덱스 : 0부터 배열의 길이 이전까지 (0 <= 인덱스 < 길이)
		for (int i = 0; i < a.length; i++) {
			System.out.println("인덱스: " + i);
		}
		
		// 요소 : 배열이름[인덱스]
		for (int i = 0; i < a.length; i++) {
			System.out.println("배열 요소: " + a[i]);
		}
		
		// 벗어난 인덱스
		System.out.println(a[5]);

	}

}