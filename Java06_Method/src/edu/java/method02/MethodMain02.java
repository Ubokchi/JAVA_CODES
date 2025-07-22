package edu.java.method02;

public class MethodMain02 {
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메소드 이름 : add
	// 리턴타입 : int
	// 매개변수 : int x, int y

	public static int add(int x, int y) {
		// int result = x + y;
		return x + y; //return result;
	}

	// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
	// 메소드 이름 : mul
	// 리턴타입 : double
	// 매개변수 : double x, double y
	
	public static double mul(double x, double y) {
		return x * y;
	}

	public static void main(String[] args) {
		System.out.println("메소드 연습");
		int result = add(10, 20);
		System.out.println("result = " + result);
		
		double m = mul(1.0, 2.0);
		System.out.println("m = " + m);
	}

}
