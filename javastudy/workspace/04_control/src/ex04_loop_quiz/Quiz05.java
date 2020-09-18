package ex04_loop_quiz;

public class Quiz05 {

	public static void main(String[] args) {
		
		// 1. 세로로 출력하는 전체 구구단
		// 2x1=2
		// 2x2=4
		// ...
		// 9x9=81
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println(dan + "단입니다.");
			for (int num = 1; num <= 9; num++) {
				System.out.println(dan + "x" + num + "=" + (dan * num));
			}
		}
		
		// 2. 가로로 출력하는 전체 구구단
		// 2x1=2	3x1=3	...		9x1=9
		// 2x2=4	3x2=6	...		9x2=18
		// ...
		// 2x9=18	3x9=27	...		9x9=81
		for (int num = 1; num <= 9; num++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "x" + num + "=" + (dan * num) + "\t");
			}
			System.out.println();  // 줄 바꿈
		}

	}

}