package ex04_quiz;

class Score {
	// field
	private int kor;
	private int eng;
	private int mat;
	// constructor
	public Score(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	// method
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("국어: ").append(kor);
		sb.append(", 영어: ").append(eng);
		sb.append(", 수학: ").append(mat);
		return sb.toString();
	}
	// score1.equals(score2)
	@Override
	public boolean equals(Object obj) {
		// this : score1
		// obj  : score2
		if (this == obj) {  // score1.equals(score1)
			return true;
		}
		if (obj instanceof Score) {
			Score score = (Score) obj;
			// return this.kor == score.kor && this.eng == score.eng && this.mat == score.mat;
			return kor == score.kor && eng == score.eng && mat == score.mat;
		}
		return false;  // obj가 Score가 아님
	}
	
}

public class Quiz04 {

	public static void main(String[] args) {
		
		Score score1 = new Score(80, 90, 100);
		Score score2 = new Score(80, 90, 100);
		
		// toString() 사용
		System.out.println(score1);  // 국어: 80, 영어: 90, 수학: 100
		System.out.println(score2);  // 국어: 80, 영어: 90, 수학: 100
		
		if (score1.equals(score2)) {
			System.out.println("같은 점수이다.");  // 같은 점수이다.
		} else {
			System.out.println("다른 점수이다.");
		}

	}

}