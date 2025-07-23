package edu.java.access09;

// static : 멤버 변수 또는 메소드를 선언(정의) 할 때 사용
// - 클래스가 메모리에 로드될 때, 메소드 영역에 자동으로 생성

// 클래스 변수(static 변수): static으로 선언한 멤버 변수
// - 클래스 인스턴스를 생성하지 않아도 사용 가능
// - static 변수는 메소드 영역에 생성된 공간에서 공유됨
// - 메소드 영역에서 공유하기 때문에 값의 변경에 대해서 주의해야 한다!
// - 사용 형식:
// 		클래스이름.변수이름

// * 인스턴스 변수 : static으로 선언되지 않은 멤버 변수
// - 인스턴스를 생성한 후에만 사용할 수 있는 변수
// - 사용 형식:
//		Any 참조 변수 = new Any();
// 		참조변수.변수이름

// * 클래스 메소드(static 메소드): static으로 선언한 메소드
// - 인스턴스를 생성하지 않아도 사용 가능한 메소드
// - 사용 형식:
//		클래스이름.메소드()

// * 인스턴스 메소드: static으로 선언되지 않은 메소드
// - 인스턴스를 생성한 후에만 사용할 수 있는 메소드
// - 사용 형식:
// 		참조변수.메소드()

public class AccessMain09 {

	public static void main(String[] args) {
		// static 멤버 변수 - 인스턴스 생성 없이 사용 가능
		TestStatic.num2 = 123;	// 위험한 행동
		System.out.println(TestStatic.num2);
		
		TestStatic test = new TestStatic();
		test.num1 = 100;
		System.out.println(test.num1);
		
		// static 메소드 - 인스턴스 생성 없이 사용 가능
		TestStatic.display2();
		test.display1();

	}

}
