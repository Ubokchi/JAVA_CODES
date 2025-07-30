package edu.java.exception03;

public class ExceptionMain03 {
	
	public static void main(String[] args) {
		try {
			System.out.println("try 내부");
			int[] array = new int[10];
			array[13] = 100;
			System.out.println(array[10]);
		} catch (Exception e) {
			System.out.println("예외 메시지: " + e.toString());
		}
		System.out.println("프로그램 종료");
	}
	
}
