package ex01_thread;

// 더 자주 사용되는 스레드 생성 방법은 Runnable 인터페이스 구현

class Clean { }

// 이미 Clean을 상속 받고 있으므로 Thread를 상속 받을 수 없다.(다중 상속 금지)
// Runnable 인터페이스를 구현하는 방법을 사용해야 한다.
class RoomClean extends Clean implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);  // sleep() 메소드는 Thread 클래스 꺼.
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("방 청소 중");
		}
	}
}

class ToiletClean extends Clean implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);  // sleep() 메소드는 Thread 클래스 꺼.
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("화장실 청소 중");
		}
	}
}

public class Ex04_Runnable {

	public static void main(String[] args) {
		
		// Runnable 인터페이스 구현한 클래스는 생성 후 Thread로 바꾼다.
		RoomClean room = new RoomClean();
		Thread roomClean = new Thread(room);
		
		ToiletClean toilet = new ToiletClean();
		Thread toiletClean = new Thread(toilet);
		
		// 스레드 시작
		roomClean.start();
		toiletClean.start();

	}

}
