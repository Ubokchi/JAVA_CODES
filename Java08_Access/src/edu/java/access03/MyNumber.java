package edu.java.access03;

public class MyNumber {
	// 멤버 변수
	private int age;
	
	// 생성자
	public MyNumber(int age) {
		this.age = age;
	}
	
	// private 멤버 변수를 간접적으로 읽어오는 메소드 - getter
	public int getAge() {
		return age;
	}
	
	// private 멤버 변수를 간접적으로 변경하는 메소드 - setter
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("나이 데이터가 잘못 입력되었습니다.");
			return;
		}
		this.age = age;
	}
	
	
}
