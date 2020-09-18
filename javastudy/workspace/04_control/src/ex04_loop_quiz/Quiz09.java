package ex04_loop_quiz;

public class Quiz09 {

	public static void main(String[] args) {
		
		// 문제. 구구단의 일부만 출력하시오.
		// 2x1=2
		// ...
		// 4x4=16
		
		for (int dan = 2; dan <= 9; dan++) {  // outer loop
			
			int num;
			
			for (num = 1; num <= 9; num++) {  // inner loop
				
				System.out.println(dan + "x" + num + "=" + (dan * num));
				if (dan == 4 && num == 4) {
					break;  // inner loop 의 종료
				}
				
			}  // inner loop
			
			if (dan == 4 && num == 4) {
				break;
			}
			
		}  // outer loop

	}

}








