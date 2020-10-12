package ex03_exception_quiz;

import java.util.Scanner;

/*
 * UpDownGame
 * 
 * 1. 1 ~ 100 사이의 난수를 사용자가 해당 난수를 맞히는 게임
 * 2. 몇 번만에 맞혔는지 게임 종료 시 출력
 * 3. 1 ~ 100 사이를 벗어난 값을 입력하면 NumberOutOfBoundsException 예외 발생
 *    예외 메시지 : 1 ~ 100 사이의 정수만 입력할 수 있습니다.
 */

class UpDownGame {
	// field
	private int answer;  // 발생된 난수
	private int count;   // 시도 횟수
	private Scanner sc;  // 입력 받을 sc (모든 메소드에서 sc 객체를 사용할 수 있다.)
	// constructor
	public UpDownGame() {
		answer = ??;
		count = ??;
		sc = ??;
	}
	// method
	// 사용자가 1 ~ 100 값 입력
	// 사용자가 입력한 값을 리턴
	// NumberOutOfBoundsException 발생 가능
	public int challenge() {
		
	}
	public void play() {
		challenge() 호출
		try - catch 문 필요
	}
}

class NumberOutOfBoundsException extends Exception {
	// constructor
	public NumberOutOfBoundsException(String message) {
		super(message);
	}
}

public class Quiz01 {

	public static void main(String[] args) {

		UpDownGame game = new UpDownGame();
		game.play();

	}

}