package edu.java.access08;

import java.util.Scanner;

// *Java Runtime Environment(JRE)
// - Java 애플리케이션을 생성하고 실행하기 위한 구성 요소
// - JRE는 Java 개발 도구(Java Development Kit, JDK)의 일부
// - 운영체제와 Java 프로그램 사이에서 조정 역할을 수행

// *JVM (Java Virtual Machine)
// - Java 바이트 코드를 실행하는 주체(소프트웨어)
// - 특정 공간을 할당하여 메모리 관리

// JVM에서 관리하는 메모리 영역:
// - Stack(스택): 지역 변수 및 매개 변수들이 저장되는 메모리 영역
// - Heap(힙): 인스턴스(참조 자료형)가 저장되는 메모리 영역
// - Method(메소드): static으로 선언한 변수, 메소드의 실행 코드 및 상수등이 저장되는 메모리 영역

// * 가비지 컬렉터 (Garbage Collector, GC):
// - JVM에서 사용하지 않는 객체를 자동으로 메모리에서 해제하는 기능
// - 주로 힙 영역에서 사용되지 않는 메모리를 제거함

// * final 제한자
// - 초기화된 값을 바꿀 수 없음
// - final: 최종적인, 변경할 수 없는
// - final + 멤버 변수, 지역 변쉬: 상수(한 번 초기화된 값을 변경할 수 업슨 수)
// - final + 메소드 : override 할 수 없는 a메소드
// - final + 클래스 : 상속을 허용하지 않는 클래스
public class AccessMain08 {

	public static final int MENU_INSERT = 1;
	public static final int MENU_DELETE = 2;
	public static int test = 100;
	
	
	public static void main(String[] args) {
		String str = new String("test"); // 힙 영역에 인스턴스 메모리 생성
		str = null;	// 객체 참조 해제
		// new String("test"); 는 참조가 해제된 상황
		// Garbage Collector가 필요없는 인스턴스를 특정 시점에 해제
		
		// 멤버 변수: 클래스 단계에서 선언된 변수
		// 지역 변수: 메소드나 특정 위치에 포함된 곳에서 선언된 변수
		// - 지역 변수의 이름은 멤버 변수와 동일하게 선언하지 않는다.
		
		int x = 10;
		final int y = 10;
		
		x = 123;
		// 일반적인 지역 변수는 초기화 이후에도 언제든지 값을 변경
//		y = 100;
		// final 지역 변수는 처음 초기화된 값을 변경할 수 없음
		test = 20;
		// final이 아닌 멤버 변수는 언제든지 값을 변경 가능
		
		System.out.println("1. 등록, 2. 삭제");
		System.out.println("메뉴 선택");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		switch (select) {
		case MENU_INSERT :
			System.out.println("등록");
			break;
		case MENU_DELETE:
			System.out.println("삭제");
			break;
		default:
			break;
		}
	}

}
