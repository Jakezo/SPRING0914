package ex03_array_quiz;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
		
		// 문제. 5명의 키를 입력 받아서 가장 큰 키를 가진 사람의
		// 이름을 출력하시오.
		// 실행 예)
		// james의 키 입력 >>> 155.5
		// alice의 키 입력 >>> 165.5
		// amanda의 키 입력 >>> 175.5
		// jessica의 키 입력 >>> 185.5
		// emily의 키 입력 >>> 195.5
		// 가장 키가 큰 사람은 emily입니다.
		
		Scanner sc = new Scanner(System.in);
		
		String[] names = {"james", "alice", "amanda", "jessica", "emily"};
		double[] heights = new double[names.length];
		
		double max = 0;
		String result = null;
		// int no = 0;
		
		// 입력
		for (int i = 0; i < heights.length; i++) {
			System.out.print(names[i] + "의 키 입력 >>> ");
			heights[i] = sc.nextDouble();
		}
		
		// 최고
		for (int i = 0; i < heights.length; i++) {
			if (max < heights[i]) {
				max = heights[i];
				result = names[i];  // no = i;
			}
		}
		
		// 확인
		System.out.println("가장 키가 큰 사람은 " + result + "입니다.");
		// System.out.println("가장 키가 큰 사람은 " + names[no] + "입니다.");
		
		sc.close();

	}

}
