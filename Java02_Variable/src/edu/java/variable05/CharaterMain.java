package edu.java.variable05;

public class CharaterMain {

	public static void main(String[] args) {
		System.out.println("문자(char) 자료형");
		
		char ch1 = 'A';
		System.out.println("ch1 = " + ch1);
		
		char ch2 = 67;
		System.out.println("ch2 = " + ch2);
		
		char ch3 = '1';
		System.out.println("ch3 = " + ch3);
		
		char ch4 = 1;
		System.out.println("ch4 = " + ch4);
		
		char ch5 = '\n'; // 줄바꿈(enter) 문자를 의미
		System.out.println("ch5 = " + ch5);
		System.out.println("줄바꿈");

		boolean b = '가' < '나';
		System.out.println("b = " + b);
		
		System.out.println("문자열(String) 자료형");
		String str = "안녕하세요";
		System.out.println("str = " + str);
	}

}
