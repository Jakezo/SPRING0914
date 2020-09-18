package ex04_loop_quiz;

import java.util.Scanner;

public class Quiz08 {

	public static void main(String[] args) {
		
		// 문제. 비밀번호를 "1234"로 가정한다.
		// 비밀번호를 입력 받아서 "1234"와 같으면 "성공"
		// "1234"가 아니면 다시 비밀번호를 입력
		// 최대 5번 가능하고 최종적으로 "실패"
		
		Scanner sc = new Scanner(System.in);
		
		String pwd = "1234";
		boolean success = false;  // 어떤 상태를 의미하는 변수(flag)
		
		// 5번
		for (int a = 0; a < 5; a++) {
			
			System.out.print("비밀번호? >>> ");
			String inputPwd = sc.next();
			
			if (pwd.equals(inputPwd)) {
				success = true;
				break;
			}
			
		}
		
		// 5번 입력이 끝난 뒤
		// "성공", "실패" 출력
		if (success) {  // 성공했다면
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		sc.close();

	}

}