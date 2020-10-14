package ex04_quiz;



public class Quiz04 {

	public static void main(String[] args) {
		
		Score score1 = new Score(80, 90, 100);
		Score score2 = new Score(80, 90, 100);
		
		System.out.println(score1);  // 국어: 80, 영어: 90, 수학: 100
		System.out.println(score2);  // 국어: 80, 영어: 90, 수학: 100
		
		if (score1.equals(score2)) {
			System.out.println("같은 점수이다.");  // 같은 점수이다.
		} else {
			System.out.println("다른 점수이다.");
		}

	}

}









