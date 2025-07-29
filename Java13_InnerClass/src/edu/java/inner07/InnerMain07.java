package edu.java.inner07;

interface Hello {
	void hello();
}

class Person implements Hello {
	@Override
	public void hello() {
		System.out.println("안녕?");
	}
}

class Dog implements Hello {
	@Override
	public void hello() {
		System.out.println("멍멍?");
	}
}

public class InnerMain07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		p1.hello();
		
		Hello p2 = new Person();
		p2.hello();
		
		Hello dog = new Dog();
		dog.hello();
		
		Hello cat = new Hello() {
			
			@Override
			public void hello() {
				System.out.println("야옹?");
			}
		};
		cat.hello();
		// new Hel() { 본체 }: 익명 클래스
		// 본체 : Hello interface를 구현하는 클래스의 내용(객체_
		
		// * 익명 클래스를 사용하는 이유
		// - 객체를 한 번 생성하고 더 이상 사용하지 않을 경우 사용
		// - 주로 call back, 이벤트 처리, 오버라이드 등에 활용
	}

}