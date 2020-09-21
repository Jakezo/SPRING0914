package ex03_array_quiz;

public class Quiz08 {

	public static void main(String[] args) {
		
		// 문제. 0~9 사이 난수를 100개 생성하고,
		// 각 숫자들의 생성 횟수(빈도수)를 그래프화 하여 출력하시오.
		// 실행 예)
		// 0 : ##### 5
		// 1 : ######## 8
		// ...
		// 9 : #### 4

		
		// 100개 랜덤 저장 a 배열
		// | 5 | 4 | 0 | 7 |....| 6 |
		// a[0] a[1] ...         a[99]
		// a[0]~a[99] : 0~9
		
		// 10개 요소를 가지는 counter 배열
		// | 7 | 5 | 10 | ... | 13 |
		// counter[0] : 7	(0이 7개)
		// counter[1] : 5	(1이 5개)
		// ...
		// counter[9] : 13	(9가 13개)

		
		int[] a = new int[100];
		int[] counter = new int[10];
		
		// 100개 랜덤 생성 : a[i]
		// counter 배열의 인덱스 a[i] 요소를 증가
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 10) + 0;
			counter[a[i]]++;
		}
		
		// 출력
		for (int i = 0; i < counter.length; i++) {
			String graph = "";
			// counter[i] 만큼 # 이어 붙이기 반복
			for (int j = 0; j < counter[i]; j++) {
				graph += "#";
			}
			System.out.println(i + " : " + graph + " " + counter[i]);
		}
		
	}

}
