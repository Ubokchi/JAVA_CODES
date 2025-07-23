package edu.java.access07;

public class MyNumber {
	// 멤버 변수
	private int number;
	
	// 생성자
	public MyNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public MyNumber add(MyNumber number) {
		this.number = this.number + number.number;
		return this;
	}
}
