package ex02_object_array;


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


class Singer {
	
	// field
	String name;
	Song[] songList;  // 길이가 없는 배열 선언
					  // new Song[3]처럼 배열 길이를 고정하면 안 된다.
	int i;  // songList 배열의 인덱스
			// 실제로는 현재 추가된 Song의 개수	
	
	// constructor
	Singer(String name, int songCount) {
		this.name = name;
		// songCount의 길이를 가지는 songList 배열 생성
		songList = new Song[songCount];
	}
	
	// method
	// 1. Song 을 전달 받아서 songList 배열에 저장하는 메소드
	// 1) 결과타입 : void
	// 2) 메소드명 : addSong
	// 3) 매개변수 : Song song
	void addSong(Song song) {
		// 1번째 호출 : songList[0] = song;
		// 2번째 호출 : songList[1] = song;
		// 3번째 호출 : songList[2] = song;

		// int i = 0;   // 여기에 두면 addSong 호출할때마다 0으로 초기화되기 때문에 안 된다.
						// int i; 의 선언은 field 에서 한다.
		songList[i] = song;
		i++;
	}
	// 2. info
	void info() {
		System.out.println("가수이름: " + name);
		System.out.println("=====대표곡목록=====");
		// 1) 일반 for문
		for (int i = 0; i < songList.length; i++) {
			// songList[i] : 하나의 Song
			songList[i].info();  // class Song 에 구현한 info 메소드
		}
		// 2) 향상 for문
		/*
		for (Song song : songList) {
			// song : 하나의 Song
			song.info();  // class Song 에 구현한 info 메소드
		}
		*/
	}
	
}

public class Ex02_Singer {

	public static void main(String[] args) {
		
		Singer singer = new Singer("IU", 3);  // IU의 노래는 3곡이다.

		// 1. Song을 미리 만들어서 전달
		Song song = new Song("Bluming", "balad", 3.5);
		singer.addSong(song);
		
		// 2. Song을 만들어서 바로 전달
		singer.addSong( new Song("자장가", "balad", 4.0) );
		singer.addSong( new Song("Love poem", "balad", 4.5) );
		
		
		singer.info();
		
		
	}

}
