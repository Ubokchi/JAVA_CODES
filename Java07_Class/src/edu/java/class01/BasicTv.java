package edu.java.class01;

// 클래스(Class)
// - 만들고자 하는 대상의 상태(속성) 정보들을 "멤버 변수(필드)"로 선언하고, 
//   대상이 가져야 할 기능들을 "메소드"로 정의하는,
//   새로이 만드는 "데이터 타입"
public class BasicTv {
	// TV가 가져야 할 상태 (속성, 성질) => 멤버 변수 (필드, 프로퍼티)
	boolean powerOn; // TV의 전원 상태 (true : on, false : off)
	int channel = 1; // TV의 채널 정보. 1으로 초기화
	int volume; // TV의 소리 정보, 0으로 초기화

	// TV가 가져야 할 기능 => 메소드
	public void turnOnOff()	{
		// 이 메소드를 호출하면
		// 만약 tv가 꺼져 있으면 -> "TV가 켜졌습니다." 출력
		if (powerOn == false) {
			powerOn = true;
			System.out.println("TV가 켜졌습니다.");
		} else { // 만약 tv가 켜져 있으면 -> "TV가 꺼졌습니다." 출력
			powerOn = false;
			System.out.println("TV가 꺼졌습니다.");
		}
	}
	
	// 채널 증가 기능
	public void channelUp() {
		if (powerOn == false) {
			return;
		}
		// 이 메소드를 호출하면 channel 변수값이 1씩 증가
		// 1, 2, 3, 4, 5, 1, 2, ... 순환구조를 갖는다.
		channel += 1;
		if (channel == 6)
			channel = 1;
		System.out.println("channel up: " + channel);
	}
	
	public void channelDown() {
		if (powerOn == false) {
			return;
		}
		// 이 메소드를 호출하면 channel 변수값이 1씩 감소
				// 1, 2, 3, 4, 5, 1, 2, ... 순환구조를 갖는다.
		channel -= 1;
		if (channel == 0)
			channel = 5;
		System.out.println("channel down: " + channel);
	}
	
	// 소리 증가 기능 (소리 최대 4)
	public void volumeUp() {
		if (volume < 4) {
			volume++;
		}
		System.out.println("volume up: " + volume);
	}
	
	// 소리 감소 기능 (소리 최소 0)
	public void volumeDown() {
		if (volume > 0) {
			volume--;
		}
		System.out.println("volume down: " + volume);
	}
}
