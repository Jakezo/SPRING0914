package ex04_quiz;

import java.util.Calendar;

public class Quiz02 {

	public static void main(String[] args) {
		
		// 기념일 계산하기
		// Calendar 클래스를 이용해 특정 기념일로부터
		// 며칠이 지났는지 출력하시오.
		
		Calendar anniversary = Calendar.getInstance();
		anniversary.set(2014, 7, 25);  // 2014-08-25, 기념일
		
		Calendar today = Calendar.getInstance();  // 오늘
		
		// 두 날짜 차이 구하기
		
		// today - anniversary
		// getTimeInMillis() : Calendar 타입 날짜 -> long 타입 숫자 (단위: 밀리초)
		long elapseTime = today.getTimeInMillis() - anniversary.getTimeInMillis();
		
		// 밀리초 -> 초 -> 분 -> 시 -> 일
		long elapseDay = elapseTime / (1000 * 60 * 60 * 24);
		
		System.out.println("경과한 일수는 " + elapseDay + "일입니다.");

	}

}