package ex02_inheritance_quiz;

// 슈퍼클래스
class Song {
	
	// field
	String title;
	String genre;
	double playTime;
	
	// constructor
	Song(String title, String genre, double playTime) {
		this.title = title;
		this.genre = genre;
		this.playTime = playTime;
	}
	
	// method
	void info() {
		System.out.println("제목: " + title);
		System.out.println("장르: " + genre);
		System.out.println("재생시간: " + playTime);
	}
	
}

// 서브클래스
class Singer extends Song {
	
	// field
	String name;
	
	// constructor
	Singer(String name, String title, String genre, double playTime) {
		super(title, genre, playTime);  // Song 클래스의 constructor 호출
		this.name = name;
	}
	
	// method
	@Override
	void info() {
		System.out.println("이름: " + name);
		System.out.println("대표곡");
		super.info();
	}
	
}


public class Quiz04 {

	public static void main(String[] args) {
		
		Singer s = new Singer("adele", "hello", "balad", 4.5);
		s.info();

	}

}
