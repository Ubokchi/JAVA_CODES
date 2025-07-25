package edu.java.access03;

// 캡슐화(encapsulation)
// - 클래스를 설계할 때, 멤버 변수(필드)들을 private 선언하여
// 외부 클래스에서 멤버 변수들을 직접 접근해서 읽거나 쓰지 못하게 하는 것
// - 필요한 경우 public 메소드를 정의하여
// private 멤버 변수를 간접적으로 읽거나 쓰는 것을 가능하게 할 수 있음

public class AccessMain03 {

	public static void main(String[] args) {
		MyNumber num = new MyNumber(10);
		System.out.println("age = " + num.getAge());
		num.setAge(-10);
		System.out.println("age = " + num.getAge());
	}
}
