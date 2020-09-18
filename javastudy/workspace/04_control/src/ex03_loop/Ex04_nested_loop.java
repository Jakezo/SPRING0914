package ex03_loop;

public class Ex04_nested_loop {

	public static void main(String[] args) {
		
		// 1일차 1교시입니다.
		// 1일차 2교시입니다.
		// ...
		// 5일차 8교시입니다.
		
		for (int day = 1; day <= 5; day++) {  // outer loop
			
			for (int hour = 1; hour <= 8; hour++) {  // inner loop
				System.out.println(day + "일차 " + hour + "교시입니다.");
			}
			
			System.out.println("-----------------");
			
		}

	}

}
