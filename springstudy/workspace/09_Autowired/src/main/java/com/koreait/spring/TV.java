package com.koreait.spring;

public class TV {
	
	// field
	private Speaker speaker;
	private int channel;
	
	// method
	public void channelUp() {
		channel++;
		if (channel > 100) {
			channel = 0;
		}
		System.out.println("현재 채널: " + channel);
	}
	public void channelDown() {
		channel--;
		if (channel < 0) {
			channel = 100;
		}
		System.out.println("현재 채널: " + channel);
	}
	public void volumeUp(int volume) {
		speaker.volumeUp(volume);
	}
	public void volumeDown(int volume) {
		speaker.volumeDown(volume);
	}

}
