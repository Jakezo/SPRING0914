package ex01_oop;

class Watch {
	
	// field
	int hour;		// 0 ~ 23
	int minute;		// 0 ~ 59
	int second;		// 0 ~ 59
	
	// constructor
	Watch(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// method
	void addHour(int hour) {
		if (hour < 0) {
			return;  // 결과타입이 void인 경우 return; 은 메소드의 종료를 의미한다.
		}
		this.hour += hour;
		this.hour %= 24;
	}
	void addMinute(int minute) {
		if (minute < 0) {
			return;
		}
		this.minute += minute;
		// 시간: this.minute / 60
		// 분:   this.minute % 60
		addHour(this.minute / 60);
		this.minute %= 60;
	}
	void addSecond(int second) {
		if (second < 0) {
			return;
		}
		this.second += second;
		// 분 : this.second / 60
		// 초 : this.second % 60
		addMinute(this.second / 60);
		this.second %= 60;
	}
	void see() {
		System.out.println(hour + "시 " + minute + "분 " + second + "초");
	}
	
}


public class Ex01_Watch {

	public static void main(String[] args) {
		
		Watch watch = new Watch(16, 15, 30);
		
		watch.addHour(25);  	// 25시간 후(1시간)
		watch.addMinute(61);	// 61분 후 	(1시간 1분)
		watch.addSecond(3661);	// 3661초 후(1시간 1분 1초)
		
		watch.see();  // 19시 17분 31초
		
	}

}
