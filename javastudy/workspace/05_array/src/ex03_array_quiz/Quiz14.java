package ex03_array_quiz;

import java.util.Arrays;

public class Quiz14 {

	public static void main(String[] args) {
		
		// 문제. 빙고
		// 5 x 5
		// 1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
		// 2. 섞는다.
		//    1) 총 25번의 교환이 발생된다.
		//    2) bingo[0][0] <-> 랜덤
		//       bingo[0][1] <-> 랜덤
		//       ...
		//       bingo[4][4] <-> 랜덤

		final int SIZE = 5;  // 상수(변치 않는 수) SIZE
		int[][] bingo = new int[SIZE][SIZE];
		
		// 1. 1~25 순차적으로 채우기
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = (i * SIZE) + (j + 1);
			}
		}
		// 생성되었는지 간단히 검사
		for(int[] a : bingo) {
			System.out.println(Arrays.toString(a));
		}
		
		// 2. 섞기
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int x = (int)(Math.random() * SIZE);
				int y = (int)(Math.random() * SIZE);
				// bingo[i][j]와 bingo[x][y]의 교환
				int temp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = temp;
			}
		}
		
		// 3. 출력
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}