package edu.java.lambda02;

import java.util.Scanner;

@FunctionalInterface
interface Test1 {
	public abstract void testPrint();
}

@FunctionalInterface
interface Test2 {
	public abstract void testPrint(int n);
}

public class LambdaMain02 {

	public static void main(String[] args) {
		// 람다(Lambda) 표현식
		// (매개변수1, 매개변수2, ..) -> { 실행문; 리턴; }
		// 매개변수와 리턴타입 형태는 인터페이스의 추상 메소드에 따라 결정됨
		// 인터페이스 변수이름 = 람다 표현식
		
		// 연습
		// 1. "익명 클래스 연습!" 을 출력하는 익명 클래스 생성 및 출력하기
		Test1 t1 = new Test1() {
			@Override
			public void testPrint() {
				System.out.println("익명 클래스 연습!");
			}
		};
		t1.testPrint();
		// 2. "람다 표현식 연습!" 을 출력하는 람다 표현식 생성 및 출력하기
		Test1 lambda1 = () -> System.out.println("람다 표현식 연습!");
		lambda1.testPrint();
		
		// 3. 정수 하나를 입력받아서 "입력한 숫자는: 100" 을 출력하는
		//		익명 클래스 생성 및 출력하기
		Scanner sc = new Scanner(System.in);
		Test2 t2 = new Test2() {
			@Override
			public void testPrint(int n) {
				System.out.println("입력한 숫자는: " + n);
			}
		};
		System.out.print("숫자 입력 (100): ");
		int input1 = sc.nextInt();
		t2.testPrint(input1);
		
		
		// 4. 정수 하나를 입력받아서 "입력한 숫자는: 200"을 출력하는 
		//		람다 표현식 생성 및 출력 하기
		Test2 lambda2 = (n) -> System.out.println("입력한 숫자는: " + n);
		System.out.print("숫자 입력 (200): ");
		int input2 = sc.nextInt();
		lambda2.testPrint(input2);
		
		sc.close();
		
	}

}


