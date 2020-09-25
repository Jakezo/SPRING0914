package ex01_oop;

class Exam {
	// field
	String examName;
	int kor, eng, mat;  // 0 ~ 100
	double ave;
	char grade;  // A, B, C, D, F
	// constructor
	Exam(String examName) {
		this.examName = examName;
	}
	// method
	void setScore() {
		kor = (int)(Math.random() * 101) + 0;  // 0부터 101개 난수(0~100)
		eng = (int)(Math.random() * 101) + 0;  // 0부터 101개 난수(0~100)
		mat = (int)(Math.random() * 101) + 0;  // 0부터 101개 난수(0~100)
		setAverage();
		setGrade();
	}
	void setAverage() {
		// 평균
		ave = (kor + eng + mat) / 3.0;
	}
	void setGrade() {
		// 학점
		if (ave >= 90)      { grade = 'A'; }
		else if (ave >= 80) { grade = 'B'; }
		else if (ave >= 70) { grade = 'C'; }
		else if (ave >= 60) { grade = 'D'; }
		else                { grade = 'F'; }
	}
	void info() {
		System.out.println(examName + "의 결과");
		System.out.println("국, 영, 수: " + kor + ", " + eng + ", " + mat);
		System.out.println("평균: " + ave + "(" + grade + ")");
	}
}

class Student {
	// field
	String name;
	Exam exam;
	// constructor
	Student(String name) {
		this.name = name;
	}
	// method
	void setExam(Exam exam) {
		this.exam = exam;
	}
	void setScore() {
		exam.setScore();
	}
	void info() {
		System.out.println("학생이름: " + name);
		exam.info();
	}
}

public class Ex08_Student {

	public static void main(String[] args) {
		
		Exam exam1 = new Exam("중간고사");
		Exam exam2 = new Exam("기말고사");
		
		Student student = new Student("사만다");
		
		student.setExam(exam1);
		student.setScore();
		student.info();
		
		student.setExam(exam2);
		student.setScore();
		student.info();
		
	}

}